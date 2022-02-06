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

    /**
     * invoke 를 사용하게 되면, 호출 부에서 해당 메소드 이름을 호출하지 않고, class 이름만으로 호출이 가능하다.
     * 해당 프로젝트에서 사용된 useCase 의 경우 내부에서 많은 일을 하는 것이 아닌 repository 내부의 함수를 호출하는 역할만 하기 때문에
     * invoke 를 사용하여 호출 하는 것도 좋은 방법이라 생각한다.
     */
    operator fun invoke(
        query: String
    ) : Flowable<List<Movie>> = repository.getSearchMovies(query)
}