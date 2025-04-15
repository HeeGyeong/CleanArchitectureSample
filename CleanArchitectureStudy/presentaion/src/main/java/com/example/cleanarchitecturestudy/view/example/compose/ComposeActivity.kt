package com.example.cleanarchitecturestudy.view.example.compose

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
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
                    .height(300.dp)
            ) {
                ComposeTextComponent("Hello Compose")

                Row {
                    ComposeTextComponent("Hello Compose")

                    Spacer(modifier = Modifier.width(10.dp))

                    ComposeTextComponent("Hello Compose")
                }
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