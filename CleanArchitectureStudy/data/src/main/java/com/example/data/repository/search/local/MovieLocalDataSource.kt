package com.example.data.repository.search.local

import com.example.data.model.movie.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Local 에 저장되어 있는 Movie Data 를 사용하기 위한 interface
 * DataSourceImpl 에서 구현된다.
 *
 * DataSource 는 Data layer 의 CRUD 를 호출하는 interface.
 * DataSourceImpl 은 DataSource interface 의 구현부.
 */
interface MovieLocalDataSource {
    fun insertMovies(movies: List<MovieEntity>): Completable
    fun getAllMovies(): Single<List<MovieEntity>>
    fun getSearchMovies(title: String): Single<List<MovieEntity>>
    fun deleteAllMovies(): Completable
}