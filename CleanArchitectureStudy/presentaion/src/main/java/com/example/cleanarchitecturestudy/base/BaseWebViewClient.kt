package com.example.cleanarchitecturestudy.base

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.cleanarchitecturestudy.view.web.WebViewModel
import javax.inject.Inject

/**
 * WebViewClient를 Custom하기 위해 클래스로 만들어서 사용.
 * BaseViewModel을 인자로 받아서 show, hide Progress 함수를 사용한다.
 *
 * 필요시 Base가 아닌 WebViewModel을 인자로 받아 사용해도 될 것으로 보인다.
 */
@SuppressLint("Lint-LogDetector")
class BaseWebViewClient @Inject constructor(vm: WebViewModel) : WebViewClient() {
    private var viewModel: WebViewModel? = null

    init {
        viewModel = vm
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        viewModel!!.showProgress()
        Log.d("webViewLog" , "onPageStarted data Check\n$view\n$url\n$favicon")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        viewModel!!.hideProgress()
        Log.d("webViewLog" , "onPageFinished data Check\n$view\n$url")

    }

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        Log.d("webViewLog" , "shouldOverrideUrlLoading data Check\n$view\n$request")
        viewModel!!.addInterfaceList()
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        // custom exceptionThrow. Check ERROR_*
        when (error?.errorCode) {
            ERROR_BAD_URL -> { }
            ERROR_CONNECT -> { }
            ERROR_UNKNOWN -> { }
            else -> { }
        }
        super.onReceivedError(view, request, error)
    }
}