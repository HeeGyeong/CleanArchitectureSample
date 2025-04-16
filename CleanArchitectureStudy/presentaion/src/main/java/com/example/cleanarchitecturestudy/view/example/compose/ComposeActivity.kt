package com.example.cleanarchitecturestudy.view.example.compose

import android.os.Bundle
import android.util.Log
import android.view.View
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
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity :
    BaseActivity<ActivityComposeBinding>(R.layout.activity_compose) {
    private val viewModel: ComposeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                ComposeTextComponent("Hello Compose")

                Row {
                    ComposeTextComponent("Hello Compose")

                    Spacer(modifier = Modifier.width(10.dp))

                    ComposeTextComponent("Hello Compose")
                }

                Divider(
                    color = Color.Black,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                        .background(color = Color.Yellow)
                ) {
                    items(100) {
                        ComposeTextComponent("Hello Compose")
                    }
                }

                Divider(
                    color = Color.Black,
                    thickness = 4.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // AndroidView를 사용하여 XML 레이아웃 통합
                XmlInComposeExample()
            }
        }
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