package com.example.cleanarchitecturestudy.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.view.rank.RankActivity
import com.example.cleanarchitecturestudy.view.search.MovieSearchActivity
import com.example.cleanarchitecturestudy.view.select.SelectActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        when(view.id) {
            R.id.firstBtn -> {
                startActivity(Intent(this, RankActivity::class.java))
            }
            R.id.secondBtn -> {
                startActivity(Intent(this, SelectActivity::class.java))
            }
            R.id.thirdBtn -> {
                startActivity(Intent(this, MovieSearchActivity::class.java))
            }
        }
    }
}