package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 다음 페이지에 있는 Movie Data 를 가져오기 위한 함수
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetPagingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    
    /**
     * 페이지네이션 기반으로 영화 데이터를 가져오는 Flow 메소드
     */
    fun getFlowPagingData(
        query: String,
        offset: Int
    ): Flow<List<Movie>> = flow {
        // 레포지토리에 Flow API가 있다면 그것을 사용
        // repository.getPagingMoviesFlow(query, offset)
        
        // 임시 구현 (repository에 Flow API가 없다면)
        try {
            val movies = repository.getPagingMovies(query, offset).blockingGet()
            emit(movies)
        } catch (e: Exception) {
            throw e
        }
    }

    /**
     * RxJava 버전 API - 레거시 지원용
     */
    @Deprecated("RxJava API - Use getFlowPagingData instead")
    operator fun invoke(
        query: String,
        offset: Int
    ): Single<List<Movie>> = repository.getPagingMovies(query, offset)
}