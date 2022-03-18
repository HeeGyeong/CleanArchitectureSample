package com.example.data.repository.search;

import java.lang.System;

/**
 * Domain Layer 의 Repository Interface 구현부.
 * DataSource 를 인자로 받아 컨트롤 하여 필요한 Movie Data 를 가져옴.
 *
 * @param movieLocalDataSource Local 에 저장 되어있는 Data
 * @param movieRemoteDataSource api 에서 가져오는 Data
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/data/repository/search/MovieRepositoryImpl;", "Lcom/example/domain/repository/MovieRepository;", "movieRemoteDataSource", "Lcom/example/data/repository/search/remote/MovieRemoteDataSource;", "movieLocalDataSource", "Lcom/example/data/repository/search/local/MovieLocalDataSource;", "(Lcom/example/data/repository/search/remote/MovieRemoteDataSource;Lcom/example/data/repository/search/local/MovieLocalDataSource;)V", "getLocalSearchMovies", "Lio/reactivex/Flowable;", "", "Lcom/example/domain/model/Movie;", "query", "", "getPagingMovies", "Lio/reactivex/Single;", "offset", "", "getRemoteSearchMovies", "getSearchMovies", "getSearchMoviesFlow", "Lkotlinx/coroutines/flow/Flow;", "data_debug"})
public final class MovieRepositoryImpl implements com.example.domain.repository.MovieRepository {
    private final com.example.data.repository.search.remote.MovieRemoteDataSource movieRemoteDataSource = null;
    private final com.example.data.repository.search.local.MovieLocalDataSource movieLocalDataSource = null;
    
    public MovieRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.remote.MovieRemoteDataSource movieRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.local.MovieLocalDataSource movieLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.example.domain.model.Movie>> getSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.model.Movie>> getSearchMoviesFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.example.domain.model.Movie>> getLocalSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.domain.model.Movie>> getRemoteSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.domain.model.Movie>> getPagingMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int offset) {
        return null;
    }
}