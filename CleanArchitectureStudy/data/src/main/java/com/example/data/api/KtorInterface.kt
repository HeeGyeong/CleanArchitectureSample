package com.example.data.api

import com.example.data.model.movie.MovieResponse
import kotlinx.coroutines.flow.Flow

interface KtorInterface {

    suspend fun requestMoveSearchData(
        query: String,
        start: Int = 1,
        display: Int = 15,
    ): Flow<MovieResponse>
}