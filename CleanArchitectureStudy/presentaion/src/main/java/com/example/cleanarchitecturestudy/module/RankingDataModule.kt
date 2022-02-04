package com.example.cleanarchitecturestudy.module

import com.example.data.repository.rank.nomal.NormalRankingDataSource
import com.example.data.repository.rank.nomal.NormalRankingDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val rankingDataModule: Module = module {
    single<NormalRankingDataSource> { NormalRankingDataSourceImpl(get()) }
}