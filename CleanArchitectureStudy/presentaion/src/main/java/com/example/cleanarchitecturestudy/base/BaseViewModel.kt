package com.example.cleanarchitecturestudy.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * BaseViewModel
 */
abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()

    // LiveData 를 사용하여 ProgressBar 를 On/Off 시킨다. 해당 변수를 사용하는 곳은 movie_search.xml
    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _percent = MutableLiveData<String>("0")
    val percent: LiveData<String> get() = _percent

    fun showProgress() {
        _isLoading.postValue(true)
    }

    fun hideProgress() {
        _isLoading.postValue(false)
    }

    fun progressPercent(load: String) {
        _percent.postValue(load)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}