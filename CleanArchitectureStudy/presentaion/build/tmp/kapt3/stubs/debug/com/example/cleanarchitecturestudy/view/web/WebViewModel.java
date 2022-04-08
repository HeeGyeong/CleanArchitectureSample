package com.example.cleanarchitecturestudy.view.web;

import java.lang.System;

/**
 * WebViewModel
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0014H\u0007J\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "Lcom/example/cleanarchitecturestudy/base/BaseViewModel;", "Lcom/example/data/web/JavaScriptRepository;", "Lcom/example/data/web/dummy/DummyRepository;", "()V", "dummyInterface", "Lcom/example/data/web/dummy/DummyScriptInterface;", "interfaceList", "Ljava/util/ArrayList;", "", "getInterfaceList", "()Ljava/util/ArrayList;", "javaScriptInterface", "Lcom/example/data/web/JavaScriptInterface;", "nowInterface", "getNowInterface", "()Ljava/lang/String;", "setNowInterface", "(Ljava/lang/String;)V", "webView", "Landroid/webkit/WebView;", "addInterfaceList", "", "dummyText", "arg", "dummyUrl", "goUrl", "initJavaScriptInterface", "jsInterface", "initWebView", "web", "openSampleWebView", "otherUrl", "showText", "presentaion_debug"})
public final class WebViewModel extends com.example.cleanarchitecturestudy.base.BaseViewModel implements com.example.data.web.JavaScriptRepository, com.example.data.web.dummy.DummyRepository {
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private android.webkit.WebView webView;
    private com.example.data.web.JavaScriptInterface javaScriptInterface;
    private com.example.data.web.dummy.DummyScriptInterface dummyInterface;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String nowInterface;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> interfaceList = null;
    
    public WebViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNowInterface() {
        return null;
    }
    
    public final void setNowInterface(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getInterfaceList() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    public final void initWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView web) {
    }
    
    public final void initJavaScriptInterface(@org.jetbrains.annotations.NotNull()
    java.lang.String jsInterface) {
    }
    
    public final void addInterfaceList() {
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