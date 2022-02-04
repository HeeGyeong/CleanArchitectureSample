package com.example.data.repository.rank.nomal

import com.example.data.model.Domain
import com.example.data.model.example.MovieResponse
import com.example.data.model.rank.RankingResponse
import io.reactivex.Single

interface NormalRankingDataSource {

    fun getRankingData(categoryId: String): Single<Domain<RankingResponse>>

    fun getSearchMovies(
        query: String,
        start: Int = 1
    ): Single<MovieResponse>

}