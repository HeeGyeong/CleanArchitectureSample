package com.example.data.repository.search.local;

import java.lang.System;

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Local DB 를 사용하기 때문에 MovieDao 를 사용하여 데이터를 가져온다.
 *
 * @param movieDao Local movie Data 가 저장 되어있는 DB
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/data/repository/search/local/MovieLocalDataSourceImpl;", "Lcom/example/data/repository/search/local/MovieLocalDataSource;", "movieDao", "Lcom/example/data/db/movie/MovieDao;", "(Lcom/example/data/db/movie/MovieDao;)V", "deleteAllMovies", "Lio/reactivex/Completable;", "getAllMovies", "Lio/reactivex/Single;", "", "Lcom/example/data/model/movie/MovieEntity;", "getSearchMovies", "title", "", "insertMovies", "movies", "data_debug"})
public final class MovieLocalDataSourceImpl implements com.example.data.repository.search.local.MovieLocalDataSource {
    private final com.example.data.db.movie.MovieDao movieDao = null;
    
    public MovieLocalDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.db.movie.MovieDao movieDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getAllMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteAllMovies() {
        return null;
    }
}