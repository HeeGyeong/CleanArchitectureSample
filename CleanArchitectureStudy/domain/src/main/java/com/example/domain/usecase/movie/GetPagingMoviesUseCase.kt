package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Single

/**
 * 다음 페이지에 있는 Movie Data 를 가져오기 위한 함수
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetPagingMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(
        query: String,
        offset: Int
    ): Single<List<Movie>> = repository.getPagingMovies(query, offset)
}