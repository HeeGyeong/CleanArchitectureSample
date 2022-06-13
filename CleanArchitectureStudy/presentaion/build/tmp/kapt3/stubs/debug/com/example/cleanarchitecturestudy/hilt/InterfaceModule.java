package com.example.cleanarchitecturestudy.hilt;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityComponent.class})
@android.annotation.SuppressLint(value = {"Lint-MethodNameDetector"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/cleanarchitecturestudy/hilt/InterfaceModule;", "", "()V", "bindDataSource", "Lcom/example/data/repository/search/local/MovieLocalDataSource;", "movieLocalDataSourceImpl", "Lcom/example/data/repository/search/local/MovieLocalDataSourceImpl;", "bindMovieRepository", "Lcom/example/domain/repository/MovieRepository;", "movieRepositoryImpl", "Lcom/example/data/repository/search/MovieRepositoryImpl;", "bindRemoveDataSource", "Lcom/example/data/repository/search/remote/MovieRemoteDataSource;", "movieRemoteDataSourceImpl", "Lcom/example/data/repository/search/remote/MovieRemoteDataSourceImpl;", "presentaion_debug"})
@dagger.Module()
public abstract class InterfaceModule {
    
    public InterfaceModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.data.repository.search.local.MovieLocalDataSource bindDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.local.MovieLocalDataSourceImpl movieLocalDataSourceImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.domain.repository.MovieRepository bindMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.MovieRepositoryImpl movieRepositoryImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.data.repository.search.remote.MovieRemoteDataSource bindRemoveDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.remote.MovieRemoteDataSourceImpl movieRemoteDataSourceImpl);
}