// Generated by Dagger (https://dagger.dev).
package com.example.domain.usecase.movie;

import com.example.domain.repository.MovieRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetPagingMoviesUseCase_Factory implements Factory<GetPagingMoviesUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public GetPagingMoviesUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPagingMoviesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetPagingMoviesUseCase_Factory create(
      Provider<MovieRepository> repositoryProvider) {
    return new GetPagingMoviesUseCase_Factory(repositoryProvider);
  }

  public static GetPagingMoviesUseCase newInstance(MovieRepository repository) {
    return new GetPagingMoviesUseCase(repository);
  }
}