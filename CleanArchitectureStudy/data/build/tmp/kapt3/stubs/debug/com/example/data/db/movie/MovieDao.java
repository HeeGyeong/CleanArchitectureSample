package com.example.data.db.movie;

import java.lang.System;

/**
 * Data Access Object
 *
 * 필요한 데이터를 DB 에서 가지고 오기 위한 쿼리를 작성.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'\u00a8\u0006\r"}, d2 = {"Lcom/example/data/db/movie/MovieDao;", "", "deleteAllMovies", "Lio/reactivex/Completable;", "getAllMovies", "Lio/reactivex/Single;", "", "Lcom/example/data/model/movie/MovieEntity;", "getMoviesByTitle", "title", "", "insertMovies", "movies", "data_debug"})
public abstract interface MovieDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract io.reactivex.Completable insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movie")
    public abstract io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getAllMovies();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movie WHERE title LIKE \'%\' || :title || \'%\'")
    public abstract io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getMoviesByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "DELETE FROM movie")
    public abstract io.reactivex.Completable deleteAllMovies();
}