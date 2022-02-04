package com.example.data.repository.search.local

import com.example.data.model.example.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Local 에 저장되어 있는 Movie Data 를 사용하기 위한 interface
 * DataSourceImpl 에서 구현된다.
 */
interface MovieLocalDataSource {
    fun insertMovies(movies: List<MovieEntity>): Completable
    fun getAllMovies(): Single<List<MovieEntity>>
    fun getSearchMovies(title: String): Single<List<MovieEntity>>
    fun deleteAllMovies(): Completable
}