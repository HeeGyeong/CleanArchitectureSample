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
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0Bi\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fBE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001J!\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u00c7\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012\u00a8\u00061"}, d2 = {"Lcom/example/data/model/movie/MovieEntity;", "", "seen1", "", "actor", "", "director", "image", "link", "pubDate", "subtitle", "title", "userRating", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActor", "()Ljava/lang/String;", "getDirector", "getImage", "getLink", "getPubDate", "getSubtitle", "getTitle", "getUserRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "data_debug"})
@kotlinx.serialization.Serializable()
public final class MovieEntity {
    
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
    public static final com.example.data.model.movie.MovieEntity.Companion Companion = null;
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
    java.lang.Object other) {
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
    @kotlin.jvm.JvmStatic()
    public static final void write$Self(@org.jetbrains.annotations.NotNull()
    com.example.data.model.movie.MovieEntity self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
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
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/example/data/model/movie/MovieEntity$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/data/model/movie/MovieEntity;", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
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
        public final kotlinx.serialization.KSerializer<com.example.data.model.movie.MovieEntity> serializer() {
            return null;
        }
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
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/example/data/model/movie/MovieEntity.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/example/data/model/movie/MovieEntity;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_debug"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.example.data.model.movie.MovieEntity> {
        
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
        public static final com.example.data.model.movie.MovieEntity.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
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
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
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
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.data.model.movie.MovieEntity deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
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
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
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
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        com.example.data.model.movie.MovieEntity value) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
}