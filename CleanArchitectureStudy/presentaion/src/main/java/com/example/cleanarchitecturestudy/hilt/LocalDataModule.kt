package com.example.cleanarchitecturestudy.hilt

import android.content.Context
import androidx.room.Room
import com.example.data.db.movie.MovieDao
import com.example.data.db.movie.MovieDatabase
import com.example.data.repository.search.MovieRepositoryImpl
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object LocalDataModule {

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
}