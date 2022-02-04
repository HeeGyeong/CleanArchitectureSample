package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Flowable

/**
 * Local DB 에 있는 Movie Data 를 가져오기 위한 함수
 * Repository 를 통해 선언 된 함수를 사용한다.
 * getMovieUseCase 와 동일한 동작을 하고 있지만, VM 에서 OffLine 일 때만 호출되기 때문에 Local 로 naming
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetLocalMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)

}