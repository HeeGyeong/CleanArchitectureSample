package com.example.cleanarchitecturestudy.view.example.compose

import android.view.LayoutInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.cleanarchitecturestudy.R

@Composable
fun MainComponent() {
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