package com.example.cleanarchitecturestudy.view.example.compose

import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturestudy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComposeViewModel @Inject constructor() : BaseViewModel() {
    val topTextViewText = MutableLiveData("No Compose UI - Top")
    val bottomTextViewText = MutableLiveData("No Compose UI - Bottom")

    val xmlBtnText = MutableLiveData("Dummy - Check Log")
    private val counter = MutableLiveData(0)

    fun onButtonClickEvent() {
        counter.value = (counter.value ?: 0) + 1
        xmlBtnText.value = "Dummy - Change Data ${counter.value}"
    }
}