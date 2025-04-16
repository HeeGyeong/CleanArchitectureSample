package com.example.cleanarchitecturestudy.view.example.compose

import android.view.LayoutInflater
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.cleanarchitecturestudy.R

@Composable
fun ComposeTextComponent(text: String) {
    Text(
        text = text
    )
}


@Composable
fun XmlInComposeExample() {
    // AndroidView를 사용하여 XML 레이아웃을 Compose에 통합
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        factory = { ctx ->
            val inflater = LayoutInflater.from(ctx)
            val view = inflater.inflate(R.layout.activity_main, null, false)
            view.tag = "activity_main"

            view
        }
    )
}