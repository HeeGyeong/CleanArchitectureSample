package com.example.cleanarchitecturestudy.hilt;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/cleanarchitecturestudy/hilt/LocalDataModule;", "", "()V", "provideMovieDao", "Lcom/example/data/db/movie/MovieDao;", "movieDatabase", "Lcom/example/data/db/movie/MovieDatabase;", "provideRoom", "context", "Landroid/content/Context;", "presentaion_debug"})
@dagger.Module()
public final class LocalDataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cleanarchitecturestudy.hilt.LocalDataModule INSTANCE = null;
    
    private LocalDataModule() {
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
}