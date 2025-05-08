package com.example.cleanarchitecturestudy.view.example.compose

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity :
    BaseActivity<ActivityComposeBinding>(R.layout.activity_compose),
    FirstFragment.FragmentSwitchListener,
    SecondFragment.FragmentSwitchListener {
    
    private val viewModel: ComposeViewModel by viewModels()
    private val firstFragment = FirstFragment.newInstance()
    private val secondFragment = SecondFragment.newInstance()
    private var fragmentContainerId = View.generateViewId()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        // Set up fragment switch listeners
        firstFragment.setFragmentSwitchListener(this)
        secondFragment.setFragmentSwitchListener(this)

        findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                // MainComponent()
                
                // Fragment를 호출
                AndroidView(
                    factory = { context ->
                        FrameLayout(context).apply {
                            id = fragmentContainerId
                            layoutParams = FrameLayout.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.MATCH_PARENT
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 300.dp),
                    update = { view ->
                        // 초기 Fragment 설정
                        if (supportFragmentManager.findFragmentById(view.id) == null) {
                            supportFragmentManager.beginTransaction()
                                .replace(view.id, firstFragment)
                                .commit()
                        }
                    }
                )
            }
        }
    }

    // FirstFragment의 인터페이스 구현
    override fun switchToSecondFragment() {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerId, secondFragment)
            .commit()
    }

    // SecondFragment의 인터페이스 구현
    override fun switchToFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerId, firstFragment)
            .commit()
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.dummy_btn -> {
                Log.d("ComposeEventLog", "Dummy Btn Click")
                viewModel.onButtonClickEvent()
            }

            else -> {
                Log.d("ComposeEventLog", "Else - btnClick Event")
            }
        }
    }
}