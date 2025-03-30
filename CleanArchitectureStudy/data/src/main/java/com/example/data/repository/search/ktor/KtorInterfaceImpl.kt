package com.example.data.repository.search.ktor

import com.example.data.api.ApiClient
import com.example.data.api.KtorInterface
import com.example.data.model.movie.MovieResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
//import javax.inject.Inject

class KtorInterfaceImpl /*@Inject*/ constructor(private val client: HttpClient) : KtorInterface {

    override suspend fun requestMoveSearchData(
        query: String,
        start: Int,
        display: Int,
    ): Flow<MovieResponse> {
        return flow {
            emit(client.get(ApiClient.KTOR_BASE_URL) {
                parameter("query", query)
                parameter("start", start)
                parameter("display", display)
            }.body())
        }
    }
}