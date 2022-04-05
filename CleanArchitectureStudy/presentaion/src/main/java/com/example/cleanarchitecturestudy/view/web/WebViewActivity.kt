package com.example.cleanarchitecturestudy.view.web

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.*
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.base.BaseWebViewClient
import com.example.cleanarchitecturestudy.databinding.ActivityWebBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class WebViewActivity : BaseActivity<ActivityWebBinding>(R.layout.activity_web) {
    private var webView: WebView? = null
    private val viewModel: WebViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initWebView()
    }

    private fun initWebView() {
        viewModel.initWebView(binding.web)
        viewModel.openSampleWebView()
    }

    /**
     * 뒤로가기 버튼 커스텀.
     * webView에서 제공하는 goBack을 사용하지 않으면, 뒤로가기 시 webView가 종료된다.
     */
    override fun onBackPressed() {
        if (webView != null && webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            finish()
        }
    }
}