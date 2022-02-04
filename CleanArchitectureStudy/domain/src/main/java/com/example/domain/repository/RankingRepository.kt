package com.example.domain.repository

import com.example.domain.model.Ranking
import io.reactivex.Flowable
import io.reactivex.Single

interface RankingRepository {

    fun getRankingData (
        categoryId: String
    ): Single<List<Ranking>>
}