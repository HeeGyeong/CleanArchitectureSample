package com.example.cleanarchitecturestudy.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.cleanarchitecturestudy.utils.NetworkManager
import com.example.domain.model.Movie
import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieSearchViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getPagingMoviesUseCase: GetPagingMoviesUseCase,
    private val getLocalMoviesUseCase: GetLocalMoviesUseCase,
    private val networkManager: NetworkManager
) : BaseViewModel() {

    private var currentQuery: String = "" // 현재 검색어
    val query = MutableLiveData<String>() // 검색어(EditText two-way binding)

    private val _movieList = MutableLiveData<MutableList<Movie>>() // 영화리스트
    val movieList: LiveData<MutableList<Movie>> get() = _movieList

    private val _toastMsg = MutableLiveData<MessageSet>() //검색결과 토스트 메시지
    val toastMsg: LiveData<MessageSet> get() = _toastMsg


    // 영화검색 (15개)
    fun requestMovie() {
        currentQuery = query.value.toString().trim()
        if (currentQuery.isEmpty()) {
            _toastMsg.value = MessageSet.EMPTY_QUERY
            return
        }
        if (!checkNetworkState()) return //네트워크연결 유무
        compositeDisposable.add(
            getMoviesUseCase.execute(currentQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe({ movies ->
                    if (movies.isEmpty()) {
                        _toastMsg.value = MessageSet.NO_RESULT
                    } else {
                        _movieList.value = movies as ArrayList<Movie>
                        _toastMsg.value = MessageSet.SUCCESS
                    }
                }, {
                    _toastMsg.value = MessageSet.ERROR
                })
        )
    }

    // 검색한 영화 더 불러오기(페이징, 무한스크롤)
    fun requestPagingMovie(offset: Int) {
        if (!checkNetworkState()) return //네트워크연결 유무
        compositeDisposable.add(
            getPagingMoviesUseCase.execute(currentQuery, offset)
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
            getLocalMoviesUseCase.execute(currentQuery)
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

