package com.example.cleanarchitecturestudy.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * 코루틴 스코프 관리를 위한 유틸리티 함수들
 */

/**
 * Flow를 라이프사이클 주기에 맞게 수집하기 위한 확장 함수
 *
 * @param lifecycleState 컬렉션을 시작할 라이프사이클 상태
 * @param collector Flow 컬렉터 람다
 */
inline fun <T> Flow<T>.collectLatestInLifecycle(
    lifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collector: suspend (T) -> Unit
): Job = lifecycleOwner.lifecycleScope.launch {
    lifecycleOwner.repeatOnLifecycle(lifecycleState) {
        collectLatest { collector(it) }
    }
}

/**
 * 여러 Flow를 한번에 수집하기 위한 확장 함수
 *
 * @param lifecycleState 컬렉션을 시작할 라이프사이클 상태
 * @param flows 수집할 Flow들
 */
fun LifecycleOwner.launchFlows(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    vararg flows: suspend CoroutineScope.() -> Unit
): Job = lifecycleScope.launch {
    repeatOnLifecycle(lifecycleState) {
        flows.forEach { flowLauncher ->
            launch { flowLauncher() }
        }
    }
}

/**
 * Flow 실행을 위한 헬퍼 함수
 * - 로딩 상태 자동 처리
 * - 백그라운드 스레드에서 실행
 * - 에러 처리
 *
 * @param showLoading 로딩 표시 여부
 * @param dispatcher 코루틴 디스패처
 * @param onLoading 로딩 시작 콜백
 * @param onComplete 로딩 완료 콜백
 * @param onError 에러 처리 콜백
 * @param onSuccess 성공 시 콜백
 */
inline fun <T> Flow<T>.executeFlow(
    scope: CoroutineScope,
    showLoading: Boolean = true,
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    crossinline onLoading: () -> Unit = {},
    crossinline onComplete: () -> Unit = {},
    crossinline onError: (Throwable) -> Unit,
    crossinline onSuccess: (T) -> Unit
): Job {
    return scope.launch {
        this@executeFlow
            .flowOn(dispatcher)
            .onStart { if (showLoading) onLoading() }
            .onCompletion { onComplete() }
            .catch { onError(it) }
            .collectLatest { onSuccess(it) }
    }
} 