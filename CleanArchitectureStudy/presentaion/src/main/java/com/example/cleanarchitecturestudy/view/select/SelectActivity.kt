package com.example.cleanarchitecturestudy.view.select

import android.os.Bundle
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivitySelectBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectActivity : BaseActivity<ActivitySelectBinding>(R.layout.activity_select) {
    private lateinit var selectItemAdapter: SelectItemAdapter
    private val viewModel: SelectViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel
    }
}