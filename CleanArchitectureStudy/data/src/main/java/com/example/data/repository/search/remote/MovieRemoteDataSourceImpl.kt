package com.example.data.repository.search.remote

import android.util.Log
import com.example.data.api.ApiInterface
import com.example.data.model.movie.MovieResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Api 를 통해 Data 를 가져오는 것이기 때문에 ApiInterface 를 사용한다.
 *
 * @param apiInterface api 호출을 위한 Interface
 */
class MovieRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }

    override fun getSearchMoviesFlow(query: String, start: Int): Flow<MovieResponse> {
        return flow {
            emit(apiInterface.getSearchMovieFlow(query, start))
        }
    }
}