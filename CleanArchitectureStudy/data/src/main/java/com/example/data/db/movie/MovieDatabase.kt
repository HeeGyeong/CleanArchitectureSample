package com.example.data.db.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.movie.MovieEntity

/**
 * Room DB
 * DB 의 entities 는 MovieEntity 로 설정.
 */
@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}