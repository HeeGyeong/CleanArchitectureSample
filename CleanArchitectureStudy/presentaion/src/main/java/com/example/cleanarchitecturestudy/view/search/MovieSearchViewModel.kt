package com.example.cleanarchitecturestudy.view.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.cleanarchitecturestudy.utils.NetworkManager
import com.example.domain.model.Movie
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
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

    // 영화 리스트가 저장되는 변수. 해당 변수는 xml 에서 binding 되어 실제로 데이터를 뿌려주게 된다.
    private val _movieList = MutableLiveData<ArrayList<Movie>>()
    val movieList: LiveData<ArrayList<Movie>> get() = _movieList

    // 검색 결과에 따른 toast 메세지.
    private val _toastMsg = MutableLiveData<MessageSet>()
    val toastMsg: LiveData<MessageSet> get() = _toastMsg


    /**
     * 2023. 10. 31
     * 해당 API를 통해 가져오는 데이터가 항상 비어있습니다.
     *
     * 정상 동작을 하는 것을 확인하였고, 문제가 없기 때문에
     * 다른 Sample API를 사용하여 Item List를 보여주면 됩니다.
     */
    // 영화 검색
    fun requestMovie() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            _toastMsg.value = MessageSet.EMPTY_QUERY
            return
        }
        if (!checkNetworkState()) return // 네트워크 연결 유무
        compositeDisposable.add(
            // API 변경 필요.
            getMoviesUseCase(currentQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies -> // currentQuery 를 사용하여 검색한 결과 값이 movie 에 들어있다.
                    Log.d("apiResponse", "res : $movies")
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NO_RESULT
                    } else {
                        _toastMsg.value = MessageSet.SUCCESS

                        // API에 따른 Response 값 변경 필요.
                        _movieList.value = movies as ArrayList<Movie>
                    }
                }, {
                    _toastMsg.value = MessageSet.ERROR
                })
        )
    }

    fun requestMovieFlow() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            _toastMsg.value = MessageSet.EMPTY_QUERY
            return
        }
        if (!checkNetworkState()) return

        // Kotlin Flow는 Coroutine에서 동작.
        viewModelScope.launch {
            getMoviesUseCase.getFlowData(currentQuery)
                .onStart { showProgress() }
                .onCompletion { hideProgress() }
                .catch {
                    Log.d("dataCheck", "Error ? $it")
                    _toastMsg.value = MessageSet.ERROR
                }
                .collect { movies ->
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NO_RESULT
                    } else {
                        _movieList.value = movies as ArrayList<Movie>
                        _toastMsg.value = MessageSet.SUCCESS
                    }
                }
        }
    }

    // 검색한 영화 더 불러오기
    fun requestPagingMovie(offset: Int) {
        if (!checkNetworkState()) return // 네트워크 연결 유무
        compositeDisposable.add(
            getPagingMoviesUseCase(currentQuery, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    val pagingMovieList = _movieList.value
                    pagingMovieList?.addAll(movies)
                    _movieList.value = pagingMovieList
                    _toastMsg.value = MessageSet.SUCCESS
                }, {
                    when (it.message) {
                        "LAST_PAGE" -> _toastMsg.value = MessageSet.LAST_PAGE
                        else -> _toastMsg.value = MessageSet.ERROR
                    }
                })
        )
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
        compositeDisposable.add(
            // getLocalMoviesUseCase.execute(currentQuery)
            getLocalMoviesUseCase(currentQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NETWORK_NOT_CONNECTED
                    } else {
                        _movieList.value = movies as ArrayList<Movie>
                        _toastMsg.value = MessageSet.LOCAL_SUCCESS
                    }
                }, {
                    _toastMsg.value = MessageSet.NETWORK_NOT_CONNECTED
                })
        )
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

