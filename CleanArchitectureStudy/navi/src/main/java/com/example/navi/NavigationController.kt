package com.example.navi

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.cleanarchitecturestudy.view.MainActivity
import com.example.core.base.navi.NavigationInterface
import com.example.moviesearch.search.MovieSearchActivity

// 일단 App Module 로 이동시켜둠.
class NavigationController: NavigationInterface {
    override fun changeActivity(context: Context, toActivity: String) {
        Log.d("StartLogCheck" , "NavigationController $context , $toActivity")
        when(toActivity) {
            "0" -> {
                context.startActivity(Intent(context, MainActivity::class.java))
            }
            "1" -> {
                context.startActivity(Intent(context, MovieSearchActivity::class.java))
            }
            else -> {

            }
        }
    }
}