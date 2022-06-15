package com.example.data.repository.search.local;

import java.lang.System;

/**
 * Local 에 저장되어 있는 Movie Data 를 사용하기 위한 interface
 * DataSourceImpl 에서 구현된다.
 *
 * DataSource 는 Data layer 의 CRUD 를 호출하는 interface.
 * DataSourceImpl 은 DataSource interface 의 구현부.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/example/data/repository/search/local/MovieLocalDataSource;", "", "deleteAllMovies", "Lio/reactivex/Completable;", "getAllMovies", "Lio/reactivex/Single;", "", "Lcom/example/data/model/movie/MovieEntity;", "getSearchMovies", "title", "", "insertMovies", "movies", "data_debug"})
public abstract interface MovieLocalDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getAllMovies();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.example.data.model.movie.MovieEntity>> getSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteAllMovies();
}