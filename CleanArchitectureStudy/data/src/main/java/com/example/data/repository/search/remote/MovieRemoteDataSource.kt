package com.example.data.repository.search.remote

import com.example.data.model.movie.MovieResponse
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

/**
 * Api 호출을 통해 Movie Data 를 가져오기 위한 interface
 * DataSourceImpl 에서 구현된다.
 */
interface MovieRemoteDataSource {
    fun getSearchMovies(
        query: String,
        start: Int = 1
    ): Single<MovieResponse>

    fun getSearchMoviesFlow(
        query: String,
        start: Int = 1
    ): Flow<MovieResponse>
}