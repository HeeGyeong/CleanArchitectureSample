package com.example.data.web.dummy

import android.util.Log
import android.webkit.JavascriptInterface

class DummyScriptInterface {
    var repository: DummyRepository? = null

    @JavascriptInterface
    fun dummyText(arg: String) {
        Log.d("interfaceTest", "dummyText text ? $arg")
        repository?.dummyText(arg)
    }

    @JavascriptInterface
    fun dummyUrl(arg: String) {
        Log.d("interfaceTest", "dummyUrl text ? $arg")
        repository?.dummyUrl(arg)
    }
}