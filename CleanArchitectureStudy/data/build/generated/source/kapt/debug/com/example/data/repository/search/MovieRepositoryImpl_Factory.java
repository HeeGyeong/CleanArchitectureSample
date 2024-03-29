// Generated by Dagger (https://dagger.dev).
package com.example.data.repository.search;

import com.example.data.api.KtorInterface;
import com.example.data.repository.search.local.MovieLocalDataSource;
import com.example.data.repository.search.remote.MovieRemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<MovieRemoteDataSource> movieRemoteDataSourceProvider;

  private final Provider<MovieLocalDataSource> movieLocalDataSourceProvider;

  private final Provider<KtorInterface> ktorInterfaceProvider;

  public MovieRepositoryImpl_Factory(Provider<MovieRemoteDataSource> movieRemoteDataSourceProvider,
      Provider<MovieLocalDataSource> movieLocalDataSourceProvider,
      Provider<KtorInterface> ktorInterfaceProvider) {
    this.movieRemoteDataSourceProvider = movieRemoteDataSourceProvider;
    this.movieLocalDataSourceProvider = movieLocalDataSourceProvider;
    this.ktorInterfaceProvider = ktorInterfaceProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(movieRemoteDataSourceProvider.get(), movieLocalDataSourceProvider.get(), ktorInterfaceProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(
      Provider<MovieRemoteDataSource> movieRemoteDataSourceProvider,
      Provider<MovieLocalDataSource> movieLocalDataSourceProvider,
      Provider<KtorInterface> ktorInterfaceProvider) {
    return new MovieRepositoryImpl_Factory(movieRemoteDataSourceProvider, movieLocalDataSourceProvider, ktorInterfaceProvider);
  }

  public static MovieRepositoryImpl newInstance(MovieRemoteDataSource movieRemoteDataSource,
      MovieLocalDataSource movieLocalDataSource, KtorInterface ktorInterface) {
    return new MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, ktorInterface);
  }
}
