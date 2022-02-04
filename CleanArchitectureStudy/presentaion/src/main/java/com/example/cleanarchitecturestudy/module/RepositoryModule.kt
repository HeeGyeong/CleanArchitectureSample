package com.example.cleanarchitecturestudy.module

import com.example.data.repository.rank.RankingRepositoryImpl
import com.example.data.repository.search.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import com.example.domain.repository.RankingRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Repository 에 관련 된 Module
 */
val repositoryModule: Module = module {

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<RankingRepository> { RankingRepositoryImpl(get()) }
}