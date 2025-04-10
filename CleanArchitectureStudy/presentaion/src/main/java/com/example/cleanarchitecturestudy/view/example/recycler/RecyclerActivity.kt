package com.example.cleanarchitecturestudy.view.search

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityMovieSearchBinding
import com.example.cleanarchitecturestudy.utils.ItemMoveCallback
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.databinding.ActivityRecyclerExampleBinding
import com.example.cleanarchitecturestudy.view.example.recycler.RecyclerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.max


@AndroidEntryPoint
class RecyclerActivity :
    BaseActivity<ActivityRecyclerExampleBinding>(R.layout.activity_recycler_example) {
    private lateinit var movieAdapter: RecyclerAdapter

    // Koin 사용 시
    // import org.koin.androidx.viewmodel.ext.android.viewModel
//    private val viewModel: MovieSearchViewModel by viewModel()

    // Hilt 사용 시
    // import androidx.activity.viewModels
    private val viewModel: RecyclerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initObserver()
        initAdapter()
        initGrabber()
        viewModel.generateDummyMovies()
    }

    private fun initAdapter() {
        movieAdapter = RecyclerAdapter { movie ->
            Intent(Intent.ACTION_VIEW, Uri.parse(movie.link)).takeIf {
                it.resolveActivity(packageManager) != null
            }?.run(this::startActivity)
        }

        val callback: ItemTouchHelper.Callback = ItemMoveCallback(movieAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(binding.rvMovies)

        binding.rvMovies.adapter = movieAdapter
    }

    private fun initObserver() {
        viewModel.movieList.observe(this@RecyclerActivity, Observer {
            movieAdapter.setMovieList(it)
        })
    }

    private fun initGrabber() {
        val grabber = findViewById<View>(R.id.grabber)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_movies)

        grabber.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    val params = recyclerView.layoutParams
                    params.height = max(10, recyclerView.height + event.y.toInt())
                    recyclerView.layoutParams = params
                }
            }
            true
        }
    }
}