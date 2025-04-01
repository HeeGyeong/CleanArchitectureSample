package com.example.cleanarchitecturestudy.di

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
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(apiInterface: ApiInterface): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiInterface)
    }

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Provides
    @Singleton
    fun provideKtorInterface(client: HttpClient): KtorInterface {
        return KtorInterfaceImpl(client)
    }

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        // HttpClient의 인스턴스를 생성하는 코드
        return HttpClient()
    }
}