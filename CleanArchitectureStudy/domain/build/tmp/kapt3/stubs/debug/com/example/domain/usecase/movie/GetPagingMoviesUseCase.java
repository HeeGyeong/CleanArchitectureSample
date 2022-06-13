package com.example.domain.usecase.movie;

import java.lang.System;

/**
 * 다음 페이지에 있는 Movie Data 를 가져오기 위한 함수
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/domain/usecase/movie/GetPagingMoviesUseCase;", "", "repository", "Lcom/example/domain/repository/MovieRepository;", "(Lcom/example/domain/repository/MovieRepository;)V", "invoke", "Lio/reactivex/Single;", "", "Lcom/example/domain/model/Movie;", "query", "", "offset", "", "domain_debug"})
public final class GetPagingMoviesUseCase {
    private final com.example.domain.repository.MovieRepository repository = null;
    
    @javax.inject.Inject()
    public GetPagingMoviesUseCase(@org.jetbrains.annotations.NotNull()
    com.example.domain.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.example.domain.model.Movie>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int offset) {
        return null;
    }
}