package com.example.data.repository.search.local

import com.example.data.db.movie.MovieDao
import com.example.data.model.movie.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Local DB 를 사용하기 때문에 MovieDao 를 사용하여 데이터를 가져온다.
 *
 * @param movieDao Local movie Data 가 저장 되어있는 DB
 */
class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) :
    MovieLocalDataSource {
    override fun insertMovies(movies: List<MovieEntity>): Completable =
        movieDao.insertMovies(movies)

    override fun getAllMovies(): Single<List<MovieEntity>> = movieDao.getAllMovies()

    override fun getSearchMovies(title: String): Single<List<MovieEntity>> =
        movieDao.getMoviesByTitle(title)

    override fun deleteAllMovies(): Completable = movieDao.deleteAllMovies()

}