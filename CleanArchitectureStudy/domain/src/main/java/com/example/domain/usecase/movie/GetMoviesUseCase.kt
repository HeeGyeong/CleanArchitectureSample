package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

/**
 * Movie Data 를 가져오기 위한 함수.
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(
        query: String
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)

    fun getFlowData(
        query: String
    ): Flow<List<Movie>> = repository.getSearchMoviesFlow(query)
}