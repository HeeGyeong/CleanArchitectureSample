package com.example.domain.repository

import com.example.domain.model.Movie
import io.reactivex.Flowable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

/**
 * UseCase 에 필요한 Interface 를 선한한 Repository.
 * RepositoryImpl 에서 구현되며, 실제 필요한 데이터를 가져온다.
 */
interface MovieRepository {
    fun getSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getSearchMoviesFlow(
        query: String
    ): Flow<List<Movie>>

    fun getLocalSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>>

    fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>>
}