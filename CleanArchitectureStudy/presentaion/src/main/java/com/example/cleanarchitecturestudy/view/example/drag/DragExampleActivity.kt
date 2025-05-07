package com.example.cleanarchitecturestudy.view.example.drag

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.Observer
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityDragExampleBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * 드래그 예제 액티비티
 * - Paging3 라이브러리를 사용하여 스크롤 시 추가 아이템 로드
 * - 버튼을 통해 추가 페이징 활성화/비활성화 가능
 *
 * 페이징 활성화/비활성화 변경 시 refresh를 사용하지 않고 동작하게 하려 했으나,
 * refresh를 하지 않으면 정상 동작하지 않는다는 것을 확인할 수 있는 예제.
 */
class DragExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragExampleBinding
    private val viewModel: DragExampleViewModel by viewModels()
    private val adapter = DragExampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.drag_example_title)
        
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.pagingDataFlow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
        
        viewModel.isPagingEnabled.observe(this, Observer { isEnabled ->
            val message = if (isEnabled) {
                "페이징이 활성화되었습니다. 스크롤하면 새 아이템을 로드합니다."
            } else {
                "페이징이 비활성화되었습니다. 현재 로드된 아이템만 표시됩니다."
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }
} 