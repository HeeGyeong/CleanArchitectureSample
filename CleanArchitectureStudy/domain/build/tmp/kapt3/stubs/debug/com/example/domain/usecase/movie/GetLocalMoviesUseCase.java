package com.example.domain.usecase.movie;

import java.lang.System;

/**
 * Local DB 에 있는 Movie Data 를 가져오기 위한 함수
 * Repository 를 통해 선언 된 함수를 사용한다.
 * getMovieUseCase 와 동일한 동작을 하고 있지만, VM 에서 OffLine 일 때만 호출되기 때문에 Local 로 naming
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/domain/usecase/movie/GetLocalMoviesUseCase;", "", "repository", "Lcom/example/domain/repository/MovieRepository;", "(Lcom/example/domain/repository/MovieRepository;)V", "execute", "Lio/reactivex/Flowable;", "", "Lcom/example/domain/model/Movie;", "query", "", "invoke", "domain_debug"})
public final class GetLocalMoviesUseCase {
    private final com.example.domain.repository.MovieRepository repository = null;
    
    @javax.inject.Inject()
    public GetLocalMoviesUseCase(@org.jetbrains.annotations.NotNull()
    com.example.domain.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<java.util.List<com.example.domain.model.Movie>> execute(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    /**
     * invoke 를 사용하게 되면, 호출 부에서 해당 메소드 이름을 호출하지 않고, class 이름만으로 호출이 가능하다.
     * 해당 프로젝트에서 사용된 useCase 의 경우 내부에서 많은 일을 하는 것이 아닌 repository 내부의 함수를 호출하는 역할만 하기 때문에
     * invoke 를 사용하여 호출 하는 것도 좋은 방법이라 생각한다.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<java.util.List<com.example.domain.model.Movie>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}