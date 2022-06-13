package com.example.data.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"mapperToMovie", "", "Lcom/example/domain/model/Movie;", "movies", "Lcom/example/data/model/movie/MovieEntity;", "data_debug"})
public final class MapperKt {
    
    /**
     * Data Entity to Data Model
     * Data Layer 에서는 Data Entity 로 받아서 사용하지만, Domain, Presentation Layer 에서는 Data Model 로 사용한다.
     * 즉, Mapper 는 Data Layer 에 존재하면서 다른 계층으로 Data 를 전달할 때, 사용하는 Data Model 에 맞춰서 변환하여 던지는 역할.
     *
     * @param movies Data Model 로 변환 할 Entity
     * @return Data Model
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.example.domain.model.Movie> mapperToMovie(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.movie.MovieEntity> movies) {
        return null;
    }
}