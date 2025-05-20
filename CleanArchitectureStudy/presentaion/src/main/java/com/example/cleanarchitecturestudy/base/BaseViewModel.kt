package com.example.cleanarchitecturestudy.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

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

    // 코루틴 에러 핸들러
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    // 코루틴 스코프 (에러 핸들러 포함)
    protected val safeScope: CoroutineScope = viewModelScope + coroutineExceptionHandler

    // 에러 처리를 위한 콜백 함수 - 필요시 서브클래스에서 오버라이드
    protected open fun onError(throwable: Throwable) {
        // 기본 에러 처리 로직
        hideProgress()
    }

    fun showProgress() {
        _isLoading.postValue(true)
    }

    fun hideProgress() {
        _isLoading.postValue(false)
    }

    fun progressPercent(load: String) {
        _percent.postValue(load)
    }

    /**
     * Flow를 안전하게 수집하기 위한 확장 함수
     * - 로딩 상태 자동 처리
     * - 에러 처리
     * - 백그라운드 스레드에서 실행
     */
    protected fun <T> Flow<T>.launchSafely(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        showLoading: Boolean = true,
        onError: (Throwable) -> Unit = { this@BaseViewModel.onError(it) },
        onSuccess: (T) -> Unit
    ): Job {
        return safeScope.launch {
            this@launchSafely
                .flowOn(dispatcher)
                .onStart { if (showLoading) showProgress() }
                .onCompletion { hideProgress() }
                .catch { onError(it) }
                .collect { onSuccess(it) }
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}