package com.example.cleanarchitecturestudy.view.example.recycler

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
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecyclerViewModel @Inject constructor(
    private val networkManager: NetworkManager,
) : BaseViewModel() {

    val query = MutableLiveData<String>() // 검색어(EditText two-way binding)

    // 영화 리스트가 저장되는 변수. 해당 변수는 xml 에서 binding 되어 실제로 데이터를 뿌려주게 된다.
    private val _movieList = MutableLiveData<ArrayList<Movie>>()
    val movieList: LiveData<ArrayList<Movie>> get() = _movieList


    private fun checkNetworkState(): Boolean {
        return if (networkManager.checkNetworkState()) {
            true
        } else {
            false
        }
    }

    fun generateDummyMovies() {
        val dummyMovies = ArrayList<Movie>()
        for (i in 1..100) {
            dummyMovies.add(Movie(title = "Movie $i", link = "http://example.com/movie$i"))
        }
        _movieList.postValue(dummyMovies)
    }
}

