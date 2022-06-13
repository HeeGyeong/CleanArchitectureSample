package com.example.cleanarchitecturestudy.base

import android.os.Message
import android.util.Log
import android.webkit.GeolocationPermissions
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.example.cleanarchitecturestudy.view.web.WebViewModel
import javax.inject.Inject

/**
 * WebView의 event를 받는 부분을 Custom할 때 사용.
 *
 * JsAlert과 같이 webView에서 Dialog를 띄우는 등의 이벤트를 받기 위해서는 해당 부분을 커스텀하여 사용한다.
 */
class BaseWebChromeClient @Inject constructor(vm: WebViewModel) : WebChromeClient() {
    private var viewModel: WebViewModel? = null

    init {
        viewModel = vm
    }

    // WebView에서 Location을 사용해야할 때 필요한 권한.
    override fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        callback: GeolocationPermissions.Callback?
    ) {
        super.onGeolocationPermissionsShowPrompt(origin, callback)
        callback?.invoke(origin, true, false)
    }

    override fun onCreateWindow(
        view: WebView?,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?
    ): Boolean {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    override fun onCloseWindow(window: WebView?) {
        super.onCloseWindow(window)
    }

    // WebView Loading Check newProgress : 0 to 100
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        Log.d("newProgressCheck" , "now ? $newProgress")
        viewModel!!.progressPercent(newProgress.toString())
    }

    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsAlert(view, url, message, result)
    }

    override fun onJsConfirm(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }
}