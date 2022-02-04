package com.example.data.repository.search.remote

import com.example.data.api.ApiInterface
import com.example.data.model.example.MovieResponse
import io.reactivex.Single

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 *
 * @param apiInterface api 호출을 위한 Interface
 */
class MovieRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }

}