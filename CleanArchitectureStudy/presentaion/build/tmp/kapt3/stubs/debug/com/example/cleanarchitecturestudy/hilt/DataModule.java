package com.example.cleanarchitecturestudy.hilt;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\t2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/cleanarchitecturestudy/hilt/DataModule;", "", "()V", "provideLocalDataSource", "Lcom/example/data/repository/search/local/MovieLocalDataSource;", "movieDao", "Lcom/example/data/db/movie/MovieDao;", "provideMovieDao", "movieDatabase", "Lcom/example/data/db/movie/MovieDatabase;", "provideMovieRepository", "Lcom/example/domain/repository/MovieRepository;", "movieRemoteDataSource", "Lcom/example/data/repository/search/remote/MovieRemoteDataSource;", "movieLocalDataSource", "provideRemoteDataSource", "apiInterface", "Lcom/example/data/api/ApiInterface;", "provideRoom", "context", "Landroid/content/Context;", "presentaion_debug"})
@dagger.Module()
public final class DataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cleanarchitecturestudy.hilt.DataModule INSTANCE = null;
    
    private DataModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.db.movie.MovieDao provideMovieDao(@org.jetbrains.annotations.NotNull()
    com.example.data.db.movie.MovieDatabase movieDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.db.movie.MovieDatabase provideRoom(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.repository.search.remote.MovieRemoteDataSource provideRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.api.ApiInterface apiInterface) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.repository.search.local.MovieLocalDataSource provideLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.db.movie.MovieDao movieDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.domain.repository.MovieRepository provideMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.remote.MovieRemoteDataSource movieRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.search.local.MovieLocalDataSource movieLocalDataSource) {
        return null;
    }
}