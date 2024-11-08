// Generated by Dagger (https://dagger.dev).
package com.example.cleanarchitecturestudy.hilt;

import com.example.data.db.movie.MovieDao;
import com.example.data.db.movie.MovieDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideMovieDaoFactory implements Factory<MovieDao> {
  private final Provider<MovieDatabase> movieDatabaseProvider;

  public DataModule_ProvideMovieDaoFactory(Provider<MovieDatabase> movieDatabaseProvider) {
    this.movieDatabaseProvider = movieDatabaseProvider;
  }

  @Override
  public MovieDao get() {
    return provideMovieDao(movieDatabaseProvider.get());
  }

  public static DataModule_ProvideMovieDaoFactory create(
      Provider<MovieDatabase> movieDatabaseProvider) {
    return new DataModule_ProvideMovieDaoFactory(movieDatabaseProvider);
  }

  public static MovieDao provideMovieDao(MovieDatabase movieDatabase) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideMovieDao(movieDatabase));
  }
}
