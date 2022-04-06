package com.example.cleanarchitecturestudy.view.web;

import java.lang.System;

/**
 * WebViewModel
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "Lcom/example/cleanarchitecturestudy/base/BaseViewModel;", "Lcom/example/data/web/JavaScriptRepository;", "Lcom/example/data/dummy/DummyRepository;", "()V", "dummyInterface", "Lcom/example/data/dummy/DummyScriptInterface;", "javaScriptInterface", "Lcom/example/data/web/JavaScriptInterface;", "webView", "Landroid/webkit/WebView;", "dummyText", "", "arg", "", "dummyUrl", "goUrl", "initWebView", "web", "openSampleWebView", "otherUrl", "showText", "presentaion_debug"})
public final class WebViewModel extends com.example.cleanarchitecturestudy.base.BaseViewModel implements com.example.data.web.JavaScriptRepository, com.example.data.dummy.DummyRepository {
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private android.webkit.WebView webView;
    private com.example.data.web.JavaScriptInterface javaScriptInterface;
    private com.example.data.dummy.DummyScriptInterface dummyInterface;
    
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
    
    @java.lang.Override()
    public void goUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
    
    @java.lang.Override()
    public void dummyText(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
    
    @java.lang.Override()
    public void dummyUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
}