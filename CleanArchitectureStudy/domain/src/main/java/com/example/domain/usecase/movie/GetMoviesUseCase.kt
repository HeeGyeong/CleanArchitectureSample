package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Movie Data 를 가져오기 위한 함수.
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    /**
     * Kotlin Flow를 사용하여 영화 데이터 가져오기 (권장)
     */
    fun getFlowData(
        query: String,
    ): Flow<List<Movie>> = repository.getSearchMoviesFlow(query)
    
    /**
     * RxJava를 사용하여 영화 데이터 가져오기 (레거시 지원)
     */
    @Deprecated("RxJava API - Use getFlowData instead", ReplaceWith("getFlowData(query)"))
    operator fun invoke(
        query: String,
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)
}