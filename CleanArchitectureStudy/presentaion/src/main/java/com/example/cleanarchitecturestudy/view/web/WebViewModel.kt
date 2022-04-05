package com.example.cleanarchitecturestudy.view.web

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.cleanarchitecturestudy.base.BaseWebViewClient
import com.example.data.web.JavaScriptInterface
import com.example.data.web.JavaScriptRepository
import kotlinx.coroutines.launch

/**
 * WebViewModel
 */
class WebViewModel : BaseViewModel(), JavaScriptRepository {

    @SuppressLint("StaticFieldLeak")
    private var webView: WebView? = null
    private var javaScriptInterface: JavaScriptInterface? = null

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(web: WebView) {
        webView = web
        webView?.run { // WebView 설정
            webViewClient = BaseWebViewClient(this@WebViewModel)
            webChromeClient = WebChromeClient() // Chrome 사용 가능 하도록 설정
            javaScriptInterface = JavaScriptInterface()
            javaScriptInterface!!.repository = this@WebViewModel
            addJavascriptInterface(
                javaScriptInterface!!,
                "JavaScriptInterface"
            ) // 해당 webView에서 호출 가능한 JSInterface 설정
            setLayerType(View.LAYER_TYPE_HARDWARE, null)

            settings.run { // 세부 세팅 등록
                javaScriptEnabled = true // 웹 페이지 JS 호출 허용
                javaScriptCanOpenWindowsAutomatically = false // JS 새창 띄우기 허용 여부
                setSupportMultipleWindows(false) // 멀티 윈도우 사용 여부
                loadWithOverviewMode = true // 메타 태그 허용 여부
                useWideViewPort = true // 화면 사이즈 맞추기 허용 여부
                setSupportZoom(false) // 줌 허용 여부
                builtInZoomControls = false // 화면 확대 축소 허용 여부
                cacheMode = WebSettings.LOAD_NO_CACHE // 브라우저 캐시 허용 여부
            }
        }
    }

    fun openSampleWebView() {
        webView!!.loadUrl("file:///android_asset/sample_web.html")
    }

    override fun showText(arg: String) {
        Log.d("javaScript", "insert JavaScript showText\n$arg")
    }

    override fun otherUrl(arg: String) {
        Log.d("javaScript", "insert JavaScript otherText\n$arg")
        viewModelScope.launch {
            webView!!.loadUrl(arg)
        }
    }
}