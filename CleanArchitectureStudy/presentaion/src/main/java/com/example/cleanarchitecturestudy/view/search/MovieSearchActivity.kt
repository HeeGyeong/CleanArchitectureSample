package com.example.cleanarchitecturestudy.view.search

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityMovieSearchBinding
import com.example.cleanarchitecturestudy.utils.ItemMoveCallback
import com.example.cleanarchitecturestudy.utils.collectLatestInLifecycle
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
        initViewModelCallback() // 레거시 LiveData 호환성 유지
        initAdapter()
        setupFlowCollectors()
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

    // Flow 수집을 위한 새로운 방법 (유틸리티 함수 사용)
    private fun setupFlowCollectors() {
        // 방법 1: collectLatestInLifecycle 확장 함수 사용
        viewModel.movieListState.collectLatestInLifecycle(this) { movies ->
            movieAdapter.setMovieList(ArrayList(movies))
        }

        viewModel.toastMsgState.collectLatestInLifecycle(this) { messageSet ->
            messageSet?.let { showToastMessage(it) }
        }

        // 방법 2: launchFlows 확장 함수 사용 (주석 처리된 대체 방법)
        /*
        launchFlows(
            // 영화 리스트 Flow 수집
            {
                viewModel.movieListState.collectLatest { movies ->
                    movieAdapter.setMovieList(ArrayList(movies))
                }
            },
            // 토스트 메시지 Flow 수집
            {
                viewModel.toastMsgState.collectLatest { messageSet ->
                    messageSet?.let { showToastMessage(it) }
                }
            }
        )
        */
    }

    // 기존 LiveData 옵저버 - 레거시 지원용으로 유지
    private fun initViewModelCallback() {
        with(viewModel) {
            // toastMsg 가 변경 시, 변경된 text 로 toast 를 띄워 준다.
            toastMsg.observe(this@MovieSearchActivity, Observer { messageSet ->
                messageSet?.let { showToastMessage(it) }
            })
        }
    }

    // 토스트 메시지 표시 로직 분리
    private fun showToastMessage(messageSet: MovieSearchViewModel.MessageSet) {
        val message = when (messageSet) {
            MovieSearchViewModel.MessageSet.LAST_PAGE -> getString(R.string.last_page_msg)
            MovieSearchViewModel.MessageSet.EMPTY_QUERY -> getString(R.string.search_input_query_msg)
            MovieSearchViewModel.MessageSet.NETWORK_NOT_CONNECTED -> getString(R.string.network_error_msg)
            MovieSearchViewModel.MessageSet.SUCCESS -> getString(R.string.load_movie_success_msg)
            MovieSearchViewModel.MessageSet.NO_RESULT -> getString(R.string.no_movie_error_msg)
            MovieSearchViewModel.MessageSet.ERROR -> getString(R.string.error_msg)
            MovieSearchViewModel.MessageSet.LOCAL_SUCCESS -> getString(R.string.local_db_msg)
        }
        showToast(message)
    }
}