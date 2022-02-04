package com.example.data.repository.rank

import android.util.Log
import com.example.data.mapper.mapperToRanking
import com.example.data.repository.rank.nomal.NormalRankingDataSource
import com.example.domain.model.Ranking
import com.example.domain.repository.RankingRepository
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RankingRepositoryImpl(
    private val normalRankingDataSource: NormalRankingDataSource
) : RankingRepository {


    override fun getRankingData(categoryId: String): Single<List<Ranking>> {
        Log.d("useCase" , "RankingRepositoryImpl start getRankingData")

        Thread {
            normalRankingDataSource.getSearchMovies("과자")
                .subscribe({
                    Log.d("useCase", "getSearchMovies it ? ${it}")
                }, {
                    Log.d("useCase", "getSearchMovies error :: $it")
                })
        }.start()

        return normalRankingDataSource.getRankingData(categoryId)
            .map {
                Log.d("useCase" , "domain.code ? ${it.code}")
                Log.d("useCase" , "domain.message ? ${it.message}")
                Log.d("useCase" , "domain.data ? ${it.data}")
                Log.d("useCase" , "==============================================")
                Log.d("useCase" , "domain.data.total ? ${it.data.totalCnt}")
                Log.d("useCase" , "domain.data.rcCode ? ${it.data.rcCode}")
                Log.d("useCase" , "domain.data.updateDate ? ${it.data.updateDate}")
                Log.d("useCase" , "domain.data.goodsList?.size ? ${it.data.goodsList?.size ?: "null data"}")
                Log.d("useCase" , "==============================================")
//                Single.just(mapperToRanking(it.data.goodsList!!))
                mapperToRanking(it.data.goodsList!!)
            }
    }

}