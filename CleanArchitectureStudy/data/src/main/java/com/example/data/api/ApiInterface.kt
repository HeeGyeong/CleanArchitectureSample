package com.example.data.api

import com.example.data.model.movie.MovieResponse
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 서버와 통신 할 API 리스트
 */
interface ApiInterface {
    // query : 검색어, start : 시작, display : 가지고 올 개수
    @GET("v1/search/movie.json")
    fun getSearchMovie(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 15
    ): Single<MovieResponse>

    // Flow를 사용하기 위해서는 suspend를 붙여주어야 한다.
    @GET("v1/search/movie.json")
    suspend fun getSearchMovieFlow(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 15
    ): MovieResponse
}