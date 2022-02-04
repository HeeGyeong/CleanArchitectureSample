package com.example.data.repository.rank.nomal

import com.example.data.api.ApiInterface
import com.example.data.model.Domain
import com.example.data.model.example.MovieResponse
import com.example.data.model.rank.RankingResponse
import io.reactivex.Single

class NormalRankingDataSourceImpl(private val apiInterface: ApiInterface) : NormalRankingDataSource {

    override fun getRankingData(categoryId: String): Single<Domain<RankingResponse>> =
        apiInterface.getRankingData("001002000000000", null, null)

    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }

}