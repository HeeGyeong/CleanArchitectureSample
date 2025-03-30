package com.example.cleanarchitecturestudy.view.web

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.activity.viewModels
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityWebBinding
//import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel


//@AndroidEntryPoint
class WebViewActivity : BaseActivity<ActivityWebBinding>(R.layout.activity_web) {
    private var webView: WebView? = null

    //    private val viewModel: WebViewModel by viewModel()
    private val viewModel: WebViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding.vm = viewModel
        webView = binding.web
        initWebView()
    }

    private fun initWebView() {
        viewModel.initWebView(binding.web)
        viewModel.openSampleWebView()
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.back_button -> {
                onBackPressed()
            }
        }
    }

    /**
     * 뒤로가기 버튼 커스텀.
     * webView에서 제공하는 goBack을 사용하지 않으면, 뒤로가기 시 webView가 종료된다.
     */
    override fun onBackPressed() {
        if (webView != null && webView!!.canGoBack()) {
            val size = viewModel.interfaceList.size
            val value = viewModel.interfaceList[size - 1]

            viewModel.interfaceList.removeLast()
            viewModel.initJavaScriptInterface(value)
            webView!!.goBack()
        } else {
            finish()
        }
    }
}