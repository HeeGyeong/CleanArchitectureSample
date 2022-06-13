package com.example.data.repository.search.remote;

import java.lang.System;

/**
 * Api 호출을 통해 Movie Data 를 가져오기 위한 interface
 * DataSourceImpl 에서 구현된다.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/data/repository/search/remote/MovieRemoteDataSource;", "", "getSearchMovies", "Lio/reactivex/Single;", "Lcom/example/data/model/movie/MovieResponse;", "query", "", "start", "", "getSearchMoviesFlow", "Lkotlinx/coroutines/flow/Flow;", "data_debug"})
public abstract interface MovieRemoteDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.example.data.model.movie.MovieResponse> getSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.model.movie.MovieResponse> getSearchMoviesFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start);
    
    /**
     * Api 호출을 통해 Movie Data 를 가져오기 위한 interface
     * DataSourceImpl 에서 구현된다.
     */
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}