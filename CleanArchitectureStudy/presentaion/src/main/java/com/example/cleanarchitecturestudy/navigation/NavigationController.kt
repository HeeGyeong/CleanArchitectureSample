package com.example.cleanarchitecturestudy.navigation

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.cleanarchitecturestudy.view.MainActivity
import com.example.core.base.navi.NavigationInterface
import com.example.moviesearch.search.MovieSearchActivity

class NavigationController: NavigationInterface {
    override fun changeActivity(context: Context, fromActivity: String) {
        Log.d("StartLogCheck" , "NavigationController $context -> $fromActivity")
        when(fromActivity) {
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