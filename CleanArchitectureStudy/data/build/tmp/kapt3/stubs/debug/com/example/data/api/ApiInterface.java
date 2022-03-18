package com.example.data.api;

import java.lang.System;

/**
 * 서버와 통신 할 API 리스트
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH\'J/\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/data/api/ApiInterface;", "", "getSearchMovie", "Lio/reactivex/Single;", "Lcom/example/data/model/movie/MovieResponse;", "query", "", "start", "", "display", "getSearchMovieFlow", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/search/movie.json")
    public abstract io.reactivex.Single<com.example.data.model.movie.MovieResponse> getSearchMovie(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String query, @retrofit2.http.Query(value = "start")
    int start, @retrofit2.http.Query(value = "display")
    int display);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v1/search/movie.json")
    public abstract java.lang.Object getSearchMovieFlow(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String query, @retrofit2.http.Query(value = "start")
    int start, @retrofit2.http.Query(value = "display")
    int display, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.model.movie.MovieResponse> p3);
    
    /**
     * 서버와 통신 할 API 리스트
     */
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}