package com.example.data.db.movie;

import java.lang.System;

/**
 * Room DB
 * DB 의 entities 는 MovieEntity 로 설정.
 */
@androidx.room.Database(entities = {com.example.data.model.movie.MovieEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/db/movie/MovieDatabase;", "Landroidx/room/RoomDatabase;", "()V", "movieDao", "Lcom/example/data/db/movie/MovieDao;", "data_debug"})
public abstract class MovieDatabase extends androidx.room.RoomDatabase {
    
    public MovieDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.db.movie.MovieDao movieDao();
}