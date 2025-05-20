package com.example.cleanarchitecturestudy.view.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.cleanarchitecturestudy.utils.NetworkManager
import com.example.domain.model.Movie
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * MovieSearchActivity 에 사용되는 VM
 *
 * 해당 Activity 에서 사용되는 UseCase 를 모두 파라미터로 받는다.
 */
@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getPagingMoviesUseCase: GetPagingMoviesUseCase,
    private val getLocalMoviesUseCase: GetLocalMoviesUseCase,
    private val networkManager: NetworkManager,
) : BaseViewModel() {

    private var currentQuery: String = "" // 현재 검색어
    val query = MutableLiveData<String>() // 검색어(EditText two-way binding)

    // 영화 리스트가 저장되는 변수 - StateFlow로 변경
    private val _movieListState = MutableStateFlow<List<Movie>>(emptyList())
    val movieListState: StateFlow<List<Movie>> = _movieListState.asStateFlow()

    // 기존 LiveData 호환성 유지 (필요시 제거 가능)
    private val _movieList = MutableLiveData<ArrayList<Movie>>()
    val movieList: LiveData<ArrayList<Movie>> get() = _movieList

    // 검색 결과에 따른 toast 메세지 - StateFlow로 변경
    private val _toastMsgState = MutableStateFlow<MessageSet?>(null)
    val toastMsgState: StateFlow<MessageSet?> = _toastMsgState.asStateFlow()

    // 기존 LiveData 호환성 유지 (필요시 제거 가능)
    private val _toastMsg = MutableLiveData<MessageSet>()
    val toastMsg: LiveData<MessageSet> get() = _toastMsg

    /**
     * 2023.10.31
     *
     * 해당 API를 통해 가져오는 데이터가 항상 비어있습니다.
     *
     * 정상 동작을 하는 것을 확인하였고, 문제가 없기 때문에
     * 다른 Sample API를 사용하여 Item List를 보여주면 됩니다.
     */
    // 영화 검색 - Flow 사용 버전
    fun requestMovie() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            updateToastMessage(MessageSet.EMPTY_QUERY)
            return
        }
        if (!checkNetworkState()) return // 네트워크 연결 유무

        // Flow를 사용하는 코드
        getMoviesUseCase.getFlowData(currentQuery).launchSafely(
            onError = {
                Log.d("dataCheck", "Error: $it")
                updateToastMessage(MessageSet.ERROR)
            },
            onSuccess = { movies ->
                if (movies.isEmpty()) {
                    updateToastMessage(MessageSet.NO_RESULT)
                } else {
                    updateMovieList(movies)
                    updateToastMessage(MessageSet.SUCCESS)
                }
            }
        )
    }

    // RxJava 버전 요청 함수 (레거시 지원용)
    // 이 메서드는 RxJava를 완전히 제거하기 전까지 유지됩니다
    fun requestMovieRx() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            updateToastMessage(MessageSet.EMPTY_QUERY)
            return
        }
        if (!checkNetworkState()) return

        compositeDisposable.add(
            getMoviesUseCase(currentQuery)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    Log.d("apiResponse", "res : $movies")
                    if (movies.isEmpty()) {
                        updateToastMessage(MessageSet.NO_RESULT)
                    } else {
                        updateToastMessage(MessageSet.SUCCESS)
                        updateMovieList(movies)
                    }
                }, {
                    updateToastMessage(MessageSet.ERROR)
                })
        )
    }

    // 검색한 영화 더 불러오기 
    // Flow 버전으로 구현
    fun requestPagingMovie(offset: Int) {
        if (!checkNetworkState()) return // 네트워크 연결 유무

        // Flow API 사용 (기본)
        getPagingMoviesUseCase.getFlowPagingData(currentQuery, offset).launchSafely(
            onError = { throwable ->
                when (throwable.message) {
                    "LAST_PAGE" -> updateToastMessage(MessageSet.LAST_PAGE)
                    else -> updateToastMessage(MessageSet.ERROR)
                }
            },
            onSuccess = { movies ->
                val currentMovies = _movieListState.value.toMutableList()
                currentMovies.addAll(movies)
                updateMovieList(currentMovies)
                updateToastMessage(MessageSet.SUCCESS)
            }
        )

        // 레거시 RxJava 버전 (더 이상 사용하지 않음)
        /*
        compositeDisposable.add(
            getPagingMoviesUseCase(currentQuery, offset)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { showProgress() }
                .subscribe({ movies ->
                    val currentMovies = _movieListState.value.toMutableList()
                    currentMovies.addAll(movies)
                    _movieListState.value = currentMovies
                    updateMovieList(currentMovies)
                    updateToastMessage(MessageSet.SUCCESS)
                }, {
                    when (it.message) {
                        "LAST_PAGE" -> updateToastMessage(MessageSet.LAST_PAGE)
                        else -> updateToastMessage(MessageSet.ERROR)
                    }
                })
        )
        */
    }

    private fun checkNetworkState(): Boolean {
        return if (networkManager.checkNetworkState()) {
            true
        } else {
            requestLocalMovies()
            false
        }
    }

    private fun requestLocalMovies() {
        // Flow API 사용 
        getLocalMoviesUseCase.getFlowLocalMovies(currentQuery).launchSafely(
            onError = {
                updateToastMessage(MessageSet.NETWORK_NOT_CONNECTED)
            },
            onSuccess = { movies ->
                if (movies.isEmpty()) {
                    updateToastMessage(MessageSet.NETWORK_NOT_CONNECTED)
                } else {
                    updateMovieList(movies)
                    updateToastMessage(MessageSet.LOCAL_SUCCESS)
                }
            }
        )

        // 레거시 RxJava 버전 (더 이상 사용하지 않음)
        /*
        getLocalMoviesUseCase(currentQuery)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { showProgress() }
            .doAfterTerminate { hideProgress() }
            .subscribe({ movies ->
                if (movies.isEmpty()) {
                    updateToastMessage(MessageSet.NETWORK_NOT_CONNECTED)
                } else {
                    updateMovieList(movies)
                    updateToastMessage(MessageSet.LOCAL_SUCCESS)
                }
            }, {
                updateToastMessage(MessageSet.NETWORK_NOT_CONNECTED)
            })
            .let { compositeDisposable.add(it) }
        */
    }

    // StateFlow와 LiveData를 동시에 업데이트하는 헬퍼 메서드
    private fun updateMovieList(movies: List<Movie>) {
        _movieListState.value = movies
        _movieList.value = ArrayList(movies)
    }

    // 토스트 메시지 업데이트 헬퍼 메서드
    private fun updateToastMessage(message: MessageSet) {
        _toastMsgState.value = message
        _toastMsg.value = message
    }

    enum class MessageSet {
        LAST_PAGE,
        EMPTY_QUERY,
        NETWORK_NOT_CONNECTED,
        ERROR,
        SUCCESS,
        NO_RESULT,
        LOCAL_SUCCESS
    }
}

