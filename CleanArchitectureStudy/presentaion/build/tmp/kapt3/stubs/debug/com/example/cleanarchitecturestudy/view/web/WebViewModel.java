package com.example.cleanarchitecturestudy.view.web;

import java.lang.System;

/**
 * WebViewModel
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "Lcom/example/cleanarchitecturestudy/base/BaseViewModel;", "Lcom/example/data/web/JavaScriptRepository;", "()V", "javaScriptInterface", "Lcom/example/data/web/JavaScriptInterface;", "webView", "Landroid/webkit/WebView;", "initWebView", "", "web", "openSampleWebView", "otherUrl", "arg", "", "showText", "presentaion_debug"})
public final class WebViewModel extends com.example.cleanarchitecturestudy.base.BaseViewModel implements com.example.data.web.JavaScriptRepository {
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private android.webkit.WebView webView;
    private com.example.data.web.JavaScriptInterface javaScriptInterface;
    
    public WebViewModel() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    public final void initWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView web) {
    }
    
    public final void openSampleWebView() {
    }
    
    @java.lang.Override()
    public void showText(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
    
    @java.lang.Override()
    public void otherUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
}