package com.example.data.repository.search.ktor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/data/repository/search/ktor/KtorInterfaceImpl;", "Lcom/example/data/api/KtorInterface;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "requestMoveSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/data/model/movie/MovieResponse;", "query", "", "start", "", "display", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class KtorInterfaceImpl implements com.example.data.api.KtorInterface {
    private final io.ktor.client.HttpClient client = null;
    
    @javax.inject.Inject()
    public KtorInterfaceImpl(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object requestMoveSearchData(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start, int display, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.example.data.model.movie.MovieResponse>> continuation) {
        return null;
    }
}