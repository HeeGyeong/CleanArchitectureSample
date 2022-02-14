package com.example.data.model.movie;

import java.lang.System;

/**
 * Movie Data Class
 * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
 * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
 *
 * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
 *         즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
 *         DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
 * DTO : 변경이 쉽게 가능한 Data Class.
 *       데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
 *       데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
 */
@androidx.room.Entity(tableName = "movie")
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/example/data/model/movie/MovieEntity;", "", "actor", "", "director", "image", "link", "pubDate", "subtitle", "title", "userRating", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActor", "()Ljava/lang/String;", "getDirector", "getImage", "getLink", "getPubDate", "getSubtitle", "getTitle", "getUserRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "data_debug"})
public final class MovieEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "actor")
    private final java.lang.String actor = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "director")
    private final java.lang.String director = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "image")
    private final java.lang.String image = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "link")
    private final java.lang.String link = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "pubDate")
    private final java.lang.String pubDate = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "subtitle")
    private final java.lang.String subtitle = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey(autoGenerate = false)
    @com.google.gson.annotations.SerializedName(value = "title")
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userRating")
    private final java.lang.String userRating = null;
    
    /**
     * Movie Data Class
     * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
     * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
     *
     * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
     *         즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
     *         DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
     * DTO : 변경이 쉽게 가능한 Data Class.
     *       데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
     *       데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.model.movie.MovieEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String actor, @org.jetbrains.annotations.NotNull()
    java.lang.String director, @org.jetbrains.annotations.NotNull()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String pubDate, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String userRating) {
        return null;
    }
    
    /**
     * Movie Data Class
     * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
     * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
     *
     * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
     *         즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
     *         DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
     * DTO : 변경이 쉽게 가능한 Data Class.
     *       데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
     *       데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    /**
     * Movie Data Class
     * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
     * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
     *
     * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
     *         즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
     *         DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
     * DTO : 변경이 쉽게 가능한 Data Class.
     *       데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
     *       데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Movie Data Class
     * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
     * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
     *
     * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
     *         즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
     *         DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
     * DTO : 변경이 쉽게 가능한 Data Class.
     *       데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
     *       데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public MovieEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String actor, @org.jetbrains.annotations.NotNull()
    java.lang.String director, @org.jetbrains.annotations.NotNull()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String pubDate, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String userRating) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDirector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLink() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPubDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubtitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserRating() {
        return null;
    }
}