package com.example.cleanarchitecturestudy.base;

import java.lang.System;

/**
 * WebView의 event를 받는 부분을 Custom할 때 사용.
 *
 * JsAlert과 같이 webView에서 Dialog를 띄우는 등의 이벤트를 받기 위해서는 해당 부분을 커스텀하여 사용한다.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J0\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J0\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/cleanarchitecturestudy/base/BaseWebChromeClient;", "Landroid/webkit/WebChromeClient;", "vm", "Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;", "(Lcom/example/cleanarchitecturestudy/view/web/WebViewModel;)V", "viewModel", "onCloseWindow", "", "window", "Landroid/webkit/WebView;", "onCreateWindow", "", "view", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onJsAlert", "url", "", "message", "result", "Landroid/webkit/JsResult;", "onJsConfirm", "onProgressChanged", "newProgress", "", "presentaion_debug"})
public final class BaseWebChromeClient extends android.webkit.WebChromeClient {
    private com.example.cleanarchitecturestudy.view.web.WebViewModel viewModel;
    
    public BaseWebChromeClient(@org.jetbrains.annotations.NotNull()
    com.example.cleanarchitecturestudy.view.web.WebViewModel vm) {
        super();
    }
    
    @java.lang.Override()
    public boolean onCreateWindow(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, boolean isDialog, boolean isUserGesture, @org.jetbrains.annotations.Nullable()
    android.os.Message resultMsg) {
        return false;
    }
    
    @java.lang.Override()
    public void onCloseWindow(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView window) {
    }
    
    @java.lang.Override()
    public void onProgressChanged(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, int newProgress) {
    }
    
    @java.lang.Override()
    public boolean onJsAlert(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    android.webkit.JsResult result) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onJsConfirm(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    android.webkit.JsResult result) {
        return false;
    }
}