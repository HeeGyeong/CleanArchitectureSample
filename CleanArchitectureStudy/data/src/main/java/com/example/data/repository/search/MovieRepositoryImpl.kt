package com.example.data.repository.search

import com.example.data.mapper.mapperToMovie
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Domain Layer 의 Repository Interface 구현부.
 * DataSource 를 인자로 받아 컨트롤 하여 필요한 Movie Data 를 가져옴.
 *
 * @param movieLocalDataSource Local 에 저장 되어있는 Data
 * @param movieRemoteDataSource api 에서 가져오는 Data
 */
class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    //첫 영화검색
    override fun getSearchMovies(query: String): Flowable<List<Movie>> {
        return movieLocalDataSource.getSearchMovies(query)
            .onErrorReturn { listOf() }
            // flatMapPublisher : 함수 결과를 return
            .flatMapPublisher { localMovies ->
                if (localMovies.isEmpty()) { // 로컬 DB가 비어있으면
                    getRemoteSearchMovies(query)
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val local = Single.just(mapperToMovie(localMovies)) // 로컬 DB
                    val remote = getRemoteSearchMovies(query) // 서버 API
                        .onErrorResumeNext { local }
                    Single.concat(local, remote) // 순서대로 불러옴
                }
            }
    }

    // 인터넷이 끊킨 경우 로컬디비에서 검색
    override fun getLocalSearchMovies(query: String): Flowable<List<Movie>> {
        return movieLocalDataSource.getSearchMovies(query)
            .onErrorReturn { listOf() }
            .flatMapPublisher { cachedMovies ->
                if (cachedMovies.isEmpty()) {
                    Flowable.error(IllegalStateException("NO_DATA_FROM_LOCAL_DB"))
                } else {
                    Flowable.just(mapperToMovie(cachedMovies))
                }
            }
    }

    // 서버 DB 영화검색 요청
    override fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query)
            .flatMap {
                // insertMovie 는 MovieEntity 로 localDB에 insert.
                // andThen 연산자를 통해 localDB에 insert 한 Data 들을 Mapper 클래스로 Movie type 으로 mapping 하고 해당 list 를 return
                movieLocalDataSource.insertMovies(it.movies)
                    .andThen(Single.just(mapperToMovie(it.movies)))
            }
    }

    //영화 검색 후 스크롤 내리면 영화 더 불러오기
    override fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query, offset).flatMap {
            if (it.movies.isEmpty()) {
                Single.error(IllegalStateException("LAST_PAGE"))
            } else {
                if (offset != it.start) {
                    Single.error(IllegalStateException("LAST_PAGE"))
                } else {
                    movieLocalDataSource.insertMovies(it.movies)
                        .andThen(Single.just(mapperToMovie(it.movies)))
                }
            }
        }
    }

}