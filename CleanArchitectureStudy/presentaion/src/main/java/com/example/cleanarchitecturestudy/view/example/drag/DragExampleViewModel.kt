package com.example.cleanarchitecturestudy.view.example.drag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

/**
 * 드래그 예제 화면의 ViewModel
 */
class DragExampleViewModel : ViewModel() {
    private val pagingSource = DragExamplePagingSource()
    
    // Pager 설정
    private val pager = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            prefetchDistance = 5
        ),
        pagingSourceFactory = { pagingSource }
    )

    private val _isPagingEnabled = MutableLiveData(true)
    val isPagingEnabled: LiveData<Boolean> = _isPagingEnabled

    private val _refreshTrigger = MutableStateFlow(0)

    val pagingDataFlow: Flow<PagingData<DragExampleItem>> = _refreshTrigger
        .flatMapLatest {
            pager.flow
        }
        .cachedIn(viewModelScope)

    /**
     * 페이징 활성화/비활성화 토글
     */
    fun togglePaging() {
        val newState = !(_isPagingEnabled.value ?: true)
        _isPagingEnabled.value = newState
        pagingSource.isPagingEnabled = newState

        // 페이징 상태가 변경되면 PagingSource를 갱신
        refreshPagingSource()
    }

    /**
     * 페이징 소스 갱신 - PagingSource는 그대로 유지하고 Flow만 갱신
     */
    private fun refreshPagingSource() {
        viewModelScope.launch {
            _refreshTrigger.value += 1
        }
    }
} 