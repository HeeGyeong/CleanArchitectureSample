package com.example.cleanarchitecturestudy.view

//import com.example.cleanarchitecturestudy.view.qr.QrCodeActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.view.example.blur.BlurSampleActivity
import com.example.cleanarchitecturestudy.view.example.compose.ComposeActivity
import com.example.cleanarchitecturestudy.view.example.drag.DragExampleActivity
import com.example.cleanarchitecturestudy.view.example.image.ImageViewActivity
import com.example.cleanarchitecturestudy.view.example.recycler.DraggableWrapperActivity
import com.example.cleanarchitecturestudy.view.qr.QrCodeActivity
import com.example.cleanarchitecturestudy.view.search.MovieSearchActivity
import com.example.cleanarchitecturestudy.view.web.WebViewActivity

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

            R.id.compose_btn -> {
                startActivity(Intent(this, ComposeActivity::class.java))
            }

            R.id.recycler_btn -> {
                startActivity(Intent(this, DraggableWrapperActivity::class.java))
            }
            
            R.id.image_btn -> {
                startActivity(Intent(this, ImageViewActivity::class.java))
            }
            
            R.id.blur_btn -> {
                startActivity(Intent(this, BlurSampleActivity::class.java))
            }
            
            R.id.drag_btn -> {
                startActivity(Intent(this, DragExampleActivity::class.java))
            }

            else -> {
                Unit
            }
        }
    }
}