package com.example.data.web

import android.util.Log
import android.webkit.JavascriptInterface

class JavaScriptInterface {
    var repository: JavaScriptRepository? = null

    @JavascriptInterface
    fun showText(arg: String) {
        Log.d("interfaceTest", "showShareView text ? $arg")
        repository?.showText(arg)
    }

    @JavascriptInterface
    fun otherUrl(arg: String) {
        Log.d("interfaceTest", "otherUrl text ? $arg")
        repository?.otherUrl(arg)
    }

    @JavascriptInterface
    fun goUrl(arg: String) {
        Log.d("interfaceTest", "goUrl text ? $arg")
        repository?.goUrl(arg)
    }
}