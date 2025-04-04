package com.example.cleanarchitecturestudy.view.search

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityMovieSearchBinding
import com.example.cleanarchitecturestudy.utils.ItemMoveCallback
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieSearchActivity :
    BaseActivity<ActivityMovieSearchBinding>(R.layout.activity_movie_search) {
    private lateinit var movieAdapter: MovieAdapter

    // Koin 사용 시
    // import org.koin.androidx.viewmodel.ext.android.viewModel
//    private val viewModel: MovieSearchViewModel by viewModel()

    // Hilt 사용 시
    // import androidx.activity.viewModels
    private val viewModel: MovieSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initViewModelCallback()
        initObserver()
        initAdapter()
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter { movie ->
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
        viewModel.movieList.observe(this@MovieSearchActivity, Observer {
            movieAdapter.setMovieList(it)
        })
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            // toastMsg 가 변경 시, 변경된 text 로 toast 를 띄워 준다.
            toastMsg.observe(this@MovieSearchActivity, Observer {
                when (toastMsg.value) {
                    MovieSearchViewModel.MessageSet.LAST_PAGE -> showToast(getString(R.string.last_page_msg))
                    MovieSearchViewModel.MessageSet.EMPTY_QUERY -> showToast(getString(R.string.search_input_query_msg))
                    MovieSearchViewModel.MessageSet.NETWORK_NOT_CONNECTED -> showToast(getString(R.string.network_error_msg))
                    MovieSearchViewModel.MessageSet.SUCCESS -> showToast(getString(R.string.load_movie_success_msg))
                    MovieSearchViewModel.MessageSet.NO_RESULT -> showToast(getString(R.string.no_movie_error_msg))
                    MovieSearchViewModel.MessageSet.ERROR -> showToast(getString(R.string.error_msg))
                    MovieSearchViewModel.MessageSet.LOCAL_SUCCESS -> showToast(getString(R.string.local_db_msg))
                    else -> { Unit }
                }
            })
        }
    }
}