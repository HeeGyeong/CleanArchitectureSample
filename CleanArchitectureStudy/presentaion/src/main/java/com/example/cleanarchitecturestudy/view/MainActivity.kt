package com.example.cleanarchitecturestudy.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.view.search.MovieSearchActivity

/**
 * MainActivity.
 *
 * 해당 프로젝트에서는 사실 필요성이 없지만, 테스트를 위해 이것 저것 추가해보기 위해 만들어 두었음.
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        when(view.id) {
            R.id.thirdBtn -> {
                startActivity(Intent(this, MovieSearchActivity::class.java))
            }
        }
    }
}