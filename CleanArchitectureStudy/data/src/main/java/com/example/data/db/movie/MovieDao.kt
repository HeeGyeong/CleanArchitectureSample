package com.example.data.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.example.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Data Access Object
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>): Completable

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Single<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :title || '%'")
    fun getMoviesByTitle(title: String): Single<List<MovieEntity>>

    @Query("DELETE FROM movie")
    fun deleteAllMovies(): Completable
}