package com.example.data.model.movie;

import java.lang.System;

/**
 * api return 값의 형태
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\bH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/example/data/model/movie/MovieResponse;", "", "display", "", "movies", "", "Lcom/example/data/model/movie/MovieEntity;", "lastBuildDate", "", "start", "total", "(ILjava/util/List;Ljava/lang/String;II)V", "getDisplay", "()I", "getLastBuildDate", "()Ljava/lang/String;", "getMovies", "()Ljava/util/List;", "getStart", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class MovieResponse {
    @com.google.gson.annotations.SerializedName(value = "display")
    private final int display = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "items")
    private final java.util.List<com.example.data.model.movie.MovieEntity> movies = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "lastBuildDate")
    private final java.lang.String lastBuildDate = null;
    @com.google.gson.annotations.SerializedName(value = "start")
    private final int start = 0;
    @com.google.gson.annotations.SerializedName(value = "total")
    private final int total = 0;
    
    /**
     * api return 값의 형태
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.model.movie.MovieResponse copy(int display, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies, @org.jetbrains.annotations.NotNull()
    java.lang.String lastBuildDate, int start, int total) {
        return null;
    }
    
    /**
     * api return 값의 형태
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    /**
     * api return 값의 형태
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * api return 값의 형태
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public MovieResponse(int display, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies, @org.jetbrains.annotations.NotNull()
    java.lang.String lastBuildDate, int start, int total) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getDisplay() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.model.movie.MovieEntity> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.model.movie.MovieEntity> getMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastBuildDate() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getStart() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getTotal() {
        return 0;
    }
}