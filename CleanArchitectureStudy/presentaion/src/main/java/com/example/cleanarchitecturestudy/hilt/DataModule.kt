package com.example.cleanarchitecturestudy.hilt

import android.content.Context
import androidx.room.Room
import com.example.data.api.ApiInterface
import com.example.data.db.movie.MovieDao
import com.example.data.db.movie.MovieDatabase
import com.example.data.repository.search.MovieRepositoryImpl
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.local.MovieLocalDataSourceImpl
import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSourceImpl
import com.example.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "Movie.db"
        ).build()
    }

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
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource)
    }
}