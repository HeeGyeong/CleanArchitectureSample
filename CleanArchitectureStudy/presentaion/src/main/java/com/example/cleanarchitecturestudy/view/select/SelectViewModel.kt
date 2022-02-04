package com.example.cleanarchitecturestudy.view.select

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturestudy.base.BaseViewModel

class SelectViewModel(): BaseViewModel() {

    val sampleText = MutableLiveData<String>()

    val defaultText ="default Text"

    fun getSampleFunction() {
        Log.d("sample" , sampleText.value.toString().trim())
    }

    fun getTextDefault(): String {
        return "default Text2"
    }
}