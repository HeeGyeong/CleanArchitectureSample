package com.example.domain.usecase.rank

import com.example.domain.model.Ranking
import com.example.domain.repository.RankingRepository
import io.reactivex.Single

class ChangeCategoryUseCase(private val repository: RankingRepository) {

    fun execute(
        categoryId: String
    ): Single<List<Ranking>> = repository.getRankingData(categoryId)

}