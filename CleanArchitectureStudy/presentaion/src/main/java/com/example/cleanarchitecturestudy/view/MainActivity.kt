package com.example.cleanarchitecturestudy.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.view.qr.QrCodeActivity
//import com.example.cleanarchitecturestudy.view.qr.QrCodeActivity
import com.example.cleanarchitecturestudy.view.search.MovieSearchActivity
import com.example.cleanarchitecturestudy.view.search.RecyclerActivity
import com.example.cleanarchitecturestudy.view.web.WebViewActivity

//import com.example.cleanarchitecturestudy.view.web.WebViewActivity

/**
 * MainActivity.
 *
 * 해당 프로젝트에서는 사실 필요성이 없지만, 테스트를 위해 이것 저것 추가해보기 위해 만들어 두었음.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier.fillMaxSize()
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
            R.id.thirdBtn -> {
                startActivity(Intent(this, MovieSearchActivity::class.java))
            }
            R.id.qr_btn -> {
                startActivity(Intent(this, QrCodeActivity::class.java))
            }
            R.id.web_btn -> {
                startActivity(Intent(this, WebViewActivity::class.java))
            }
            R.id.example_btn -> {
                startActivity(Intent(this, RecyclerActivity::class.java))
            }
            else -> {
                Unit
            }
        }
    }
}

@Composable
fun ComposeTextComponent(text: String) {
    Text(
        text = text
    )
}