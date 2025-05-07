package com.example.cleanarchitecturestudy.view.example.drag

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

/**
 * 드래그 예제의 페이징 소스
 * 총 200개의 아이템을 페이지당 20개씩 로드
 */
class DragExamplePagingSource : PagingSource<Int, DragExampleItem>() {
    var isPagingEnabled = true
    private var lastLoadedPage = STARTING_KEY

    companion object {
        private const val STARTING_KEY = 1
        private const val LOAD_DELAY_MS = 1000L  // 네트워크 지연 시뮬레이션
        private const val PAGE_SIZE = 20
        private const val MAX_ITEMS = 200
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DragExampleItem> {
        // 현재 페이지 키를 가져오거나 기본값 사용
        val page = params.key ?: STARTING_KEY
        val startItemId = (page - 1) * PAGE_SIZE + 1

        // 페이징이 비활성화된 경우, 마지막으로 로드된 페이지까지만 로드
        if (!isPagingEnabled && page > lastLoadedPage) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = if (page == STARTING_KEY) null else page - 1,
                nextKey = null
            )
        }

        // 네트워크 지연 시뮬레이션
        delay(LOAD_DELAY_MS)

        // 아이템 생성
        val endItemId = minOf(startItemId + PAGE_SIZE - 1, MAX_ITEMS)
        val items = (startItemId..endItemId).map { id ->
            DragExampleItem(
                id = id,
                title = "아이템 $id",
                description = "아이템 $id 에 대한 설명입니다. 여기에는 아이템의 상세 내용이 표시됩니다."
            )
        }

        // 페이지가 성공적으로 로드되면 마지막 로드된 페이지 업데이트
        if (page > lastLoadedPage) {
            lastLoadedPage = page
        }

        // 다음 페이지 키 계산
        val nextKey = if (endItemId >= MAX_ITEMS) {
            null
        } else {
            page + 1
        }

        return LoadResult.Page(
            data = items,
            prevKey = if (page == STARTING_KEY) null else page - 1,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, DragExampleItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
} 