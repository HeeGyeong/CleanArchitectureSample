package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Local 데이터를 가져오는 UseCase
 *
 * 네트워크 등이 연결이 되어 있지 않을 때 Local에 저장 된 데이터를 가져와 뿌려주는 역할.
 *
 * @param repository Local 데이터에 접근할 수 있는 Repository
 */
class GetLocalMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    /**
     * Flow를 사용하여 로컬 영화 데이터 가져오기
     */
    fun getFlowLocalMovies(query: String): Flow<List<Movie>> = flow {
        // 레포지토리에 Flow API가 있다면 그것을 사용
        // repository.getLocalSearchMoviesFlow(query)
        
        // 임시 구현 (repository에 Flow API가 없다면)
        try {
            val localMovies = repository.getLocalSearchMovies(query).blockingFirst()
            emit(localMovies)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
    
    /**
     * RxJava 버전 API - 레거시 지원용
     */
    @Deprecated("RxJava API - Use getFlowLocalMovies instead")
    operator fun invoke(query: String): Flowable<List<Movie>> {
        return repository.getLocalSearchMovies(query)
    }
}