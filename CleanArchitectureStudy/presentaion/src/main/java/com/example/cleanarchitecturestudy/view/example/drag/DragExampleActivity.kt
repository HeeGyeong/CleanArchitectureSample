package com.example.cleanarchitecturestudy.view.example.drag

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityDragExampleBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * 드래그 예제 액티비티
 * - RecyclerView와 Paging3 라이브러리를 사용하여 스크롤 시 추가 아이템 로드
 * - 버튼을 통해 추가 페이징 활성화/비활성화 가능
 */
class DragExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragExampleBinding
    private val viewModel: DragExampleViewModel by viewModels()
    private val adapter = DragExampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 데이터 바인딩 초기화
        binding = ActivityDragExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 툴바 설정
        supportActionBar?.title = getString(R.string.drag_example_title)
        
        // 뷰모델 바인딩
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // 리사이클러뷰 설정
        binding.recyclerView.adapter = adapter

        // 페이징 데이터 구독
        lifecycleScope.launch {
            viewModel.pagingDataFlow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
} 