package com.example.cleanarchitecturestudy.module

import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteDataModule: Module = module {
   single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
}