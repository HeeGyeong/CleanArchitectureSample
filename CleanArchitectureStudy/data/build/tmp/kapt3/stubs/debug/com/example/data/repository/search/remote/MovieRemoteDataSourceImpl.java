package com.example.data.repository.search.remote;

import java.lang.System;

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Api 를 통해 Data 를 가져오는 것이기 때문에 ApiInterface 를 사용한다.
 *
 * @param apiInterface api 호출을 위한 Interface
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/data/repository/search/remote/MovieRemoteDataSourceImpl;", "Lcom/example/data/repository/search/remote/MovieRemoteDataSource;", "apiInterface", "Lcom/example/data/api/ApiInterface;", "(Lcom/example/data/api/ApiInterface;)V", "getSearchMovies", "Lio/reactivex/Single;", "Lcom/example/data/model/movie/MovieResponse;", "query", "", "start", "", "getSearchMoviesFlow", "Lkotlinx/coroutines/flow/Flow;", "data_debug"})
public final class MovieRemoteDataSourceImpl implements com.example.data.repository.search.remote.MovieRemoteDataSource {
    private final com.example.data.api.ApiInterface apiInterface = null;
    
    public MovieRemoteDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.api.ApiInterface apiInterface) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.example.data.model.movie.MovieResponse> getSearchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.example.data.model.movie.MovieResponse> getSearchMoviesFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start) {
        return null;
    }
}