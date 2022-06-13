package com.example.cleanarchitecturestudy.hilt

import android.annotation.SuppressLint
import com.example.data.repository.search.MovieRepositoryImpl
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.local.MovieLocalDataSourceImpl
import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSourceImpl
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("Lint-MethodNameDetector")
@Module
@InstallIn(ActivityComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun bindDataSource(movieLocalDataSourceImpl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindRemoveDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource



    /*
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource)
    }*/
}