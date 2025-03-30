package com.example.cleanarchitecturestudy.view.web

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.cleanarchitecturestudy.base.BaseWebChromeClient
import com.example.cleanarchitecturestudy.base.BaseWebViewClient
import com.example.data.web.JavaScriptInterface
import com.example.data.web.JavaScriptRepository
import com.example.data.web.dummy.DummyRepository
import com.example.data.web.dummy.DummyScriptInterface
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
//import javax.inject.Inject

/**
 * WebViewModel
 */
@SuppressLint("Lint-LogDetector")
//@HiltViewModel
class WebViewModel /*@Inject*/ constructor() : BaseViewModel(), JavaScriptRepository, DummyRepository {

    @SuppressLint("StaticFieldLeak")
    private var webView: WebView? = null

    // JavaScript Interface List
    private var javaScriptInterface: JavaScriptInterface? = null
    private var dummyInterface: DummyScriptInterface? = null

    // webView BackStack
    var nowInterface: String? = null
    val interfaceList = ArrayList<String>()

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(web: WebView) {
        webView = web
        webView?.run { // WebView 설정
            webViewClient = BaseWebViewClient(this@WebViewModel)
            webChromeClient = BaseWebChromeClient(this@WebViewModel) // Chrome 사용 가능 하도록 설정
            nowInterface = "JavaScriptInterface"
            addInterfaceList()
            initJavaScriptInterface(nowInterface!!)
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
                domStorageEnabled = true // Dom Storage API 사용 여부
            }
        }
    }

    fun initJavaScriptInterface(jsInterface: String) {
        if (nowInterface != null) {
            webView!!.removeJavascriptInterface(nowInterface!!)
        }

        // JavaScriptInterface가 추가될 때 마다 조건 추가 필요.
        when (jsInterface) {
            "JavaScriptInterface" -> {
                webView!!.run {
                    javaScriptInterface = JavaScriptInterface()
                    javaScriptInterface!!.repository = this@WebViewModel
                    addJavascriptInterface(javaScriptInterface!!, nowInterface!!)
                }
            }
            "DummyScriptInterface" -> {
                webView!!.run {
                    dummyInterface = DummyScriptInterface()
                    dummyInterface!!.repository = this@WebViewModel
                    addJavascriptInterface(dummyInterface!!, nowInterface!!)
                }
            }
            else -> {
                Log.d("javaScript", "initJavaScriptInterface not found")
            }
        }
    }

    fun addInterfaceList() {
        interfaceList.add(nowInterface!!)
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
            addInterfaceList()
            webView!!.loadUrl(arg)
        }
    }

    override fun goUrl(arg: String) {
        Log.d("javaScript", "insert JavaScript goUrl\n$arg")
        viewModelScope.launch {
            addInterfaceList()
            nowInterface = "DummyScriptInterface"
            initJavaScriptInterface(nowInterface!!)
            webView!!.loadUrl(arg)
        }
    }

    override fun dummyText(arg: String) {
        Log.d("javaScript", "insert JavaScript showText\n$arg")
    }

    override fun dummyUrl(arg: String) {
        Log.d("javaScript", "insert JavaScript otherText\n$arg")
        viewModelScope.launch {
            addInterfaceList()
            nowInterface = "JavaScriptInterface"
            initJavaScriptInterface(nowInterface!!)
            webView!!.loadUrl(arg)
        }
    }
}