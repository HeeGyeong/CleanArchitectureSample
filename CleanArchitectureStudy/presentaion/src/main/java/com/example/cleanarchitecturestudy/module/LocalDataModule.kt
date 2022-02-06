package com.example.cleanarchitecturestudy.module

import androidx.room.Room
import com.example.data.db.movie.MovieDao
import com.example.data.db.movie.MovieDatabase
import com.example.data.repository.search.local.MovieLocalDataSource
import com.example.data.repository.search.local.MovieLocalDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Local Data 사용에 관련 된 Module.
 *
 * Room 에 대한 선언도 이곳에서 처리한다.
 */
val localDataModule: Module = module {
    single<MovieLocalDataSource> { MovieLocalDataSourceImpl(get()) }
    single<MovieDao> { get<MovieDatabase>().movieDao() }

    // singleTon 으로 Room 선언.
    single<MovieDatabase> {
        Room.databaseBuilder(
            get(),
            MovieDatabase::class.java,
            "Movie.db" // Local DB name
        ).build()
    }
}