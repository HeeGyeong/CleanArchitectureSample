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


    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView = binding.web

        webView!!.webViewClient = BaseWebViewClient(viewModel) // 클릭시 새창 안뜨게
        webView!!.webChromeClient = WebChromeClient() // Chrome 사용 가능 하도록 설정
        webView!!.settings.run { //세부 세팅 등록
            javaScriptEnabled = true // 웹 페이지 JS 호출 허용
            javaScriptCanOpenWindowsAutomatically = false // JS 새창 띄우기 허용 여부
            setSupportMultipleWindows(false) // 멀티 윈도우 사용 여부
            loadWithOverviewMode = true // 메타 태그 허용 여부
            useWideViewPort = true // 화면 사이즈 맞추기 허용 여부
            setSupportZoom(false) // 줌 허용 여부
            builtInZoomControls = false // 화면 확대 축소 허용 여부
            cacheMode = WebSettings.LOAD_NO_CACHE // 브라우저 캐시 허용 여부
        }
        webView!!.loadUrl("https://heegs.tistory.com") // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
    }

    override fun onBackPressed() {
        if (webView != null && webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            finish()
        }
    }
}