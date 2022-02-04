package com.example.data.api

import com.example.data.model.Domain
import com.example.data.model.example.MovieResponse
import com.example.data.model.rank.RankingResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 서버와 통신 할 API 리스트
 */
interface ApiInterface {

    @GET("/api/V1/app/main/ranking/millions")
    fun getRankingData (
        @Query("categoryDepth1") categoryDepth1: String?,
        @Query("ageGroup") ageGroup: String?,
        @Query("gender") gender: String?
    ) : Single<Domain<RankingResponse>>

    // query : 검색어, start : 시작, display : 갖고올개수
    @GET("v1/search/movie.json")
    fun getSearchMovie(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 15
    ): Single<MovieResponse>
}