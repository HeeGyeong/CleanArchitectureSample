package com.example.cleanarchitecturestudy.di.hilt

import com.example.data.api.ApiInterface
import com.example.data.api.KtorInterface
import com.example.data.db.movie.MovieDao
import com.example.data.repository.search.ktor.KtorInterfaceImpl
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.local.MovieLocalDataSourceImpl
import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(apiInterface: ApiInterface): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiInterface)
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideKtorInterface(client: HttpClient): KtorInterface {
        return KtorInterfaceImpl(client)
    }
}