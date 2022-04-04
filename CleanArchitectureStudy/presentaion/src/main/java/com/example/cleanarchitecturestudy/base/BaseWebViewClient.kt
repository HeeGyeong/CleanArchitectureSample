package com.example.cleanarchitecturestudy.base

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class BaseWebViewClient(vm: BaseViewModel) : WebViewClient() {
    private var viewModel: BaseViewModel? = null

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
        return super.shouldOverrideUrlLoading(view, request)
    }
}