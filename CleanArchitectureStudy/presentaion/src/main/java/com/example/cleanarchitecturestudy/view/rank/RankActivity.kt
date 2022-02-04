package com.example.cleanarchitecturestudy.view.rank

import android.os.Bundle
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityRankBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankActivity : BaseActivity<ActivityRankBinding>(R.layout.activity_rank) {
    private lateinit var rankingAdapter: RankingAdapter
    private val viewModel: RankViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel
        initAdapter()
    }

    private fun initAdapter() {
        rankingAdapter = RankingAdapter()
        viewModel.requestRank()
        binding.rankingRecyclerView.adapter = rankingAdapter
    }
}