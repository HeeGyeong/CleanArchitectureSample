package com.example.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/data/api/KtorInterface;", "", "requestMoveSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/data/model/movie/MovieResponse;", "query", "", "start", "", "display", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface KtorInterface {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object requestMoveSearchData(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int start, int display, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.example.data.model.movie.MovieResponse>> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}