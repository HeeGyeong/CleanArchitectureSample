package com.example.cleanarchitecturestudy.view.web;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/web/WebViewActivity;", "Lcom/example/cleanarchitecturestudy/base/BaseActivity;", "Lcom/example/cleanarchitecturestudy/databinding/ActivityWebBinding;", "()V", "viewModel", "Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "getViewModel", "()Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "webView", "Landroid/webkit/WebView;", "initWebView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "presentaion_debug"})
public final class WebViewActivity extends com.example.cleanarchitecturestudy.base.BaseActivity<com.example.cleanarchitecturestudy.databinding.ActivityWebBinding> {
    private android.webkit.WebView webView;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public WebViewActivity() {
        super(0);
    }
    
    private final com.example.cleanarchitecturestudy.view.web.WebViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initWebView() {
    }
    
    /**
     * 뒤로가기 버튼 커스텀.
     * webView에서 제공하는 goBack을 사용하지 않으면, 뒤로가기 시 webView가 종료된다.
     */
    @java.lang.Override()
    public void onBackPressed() {
    }
}