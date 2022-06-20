package com.example.cleanarchitecturestudy.view.intro;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/intro/IntroActivity;", "Lcom/example/cleanarchitecturestudy/base/BaseActivity;", "Lcom/example/cleanarchitecturestudy/databinding/ActivityIntroBinding;", "()V", "isReady", "", "()Z", "setReady", "(Z)V", "isStart", "setStart", "errorGuard", "", "initData", "initSplashScreen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startMainActivity", "presentaion_debug"})
public final class IntroActivity extends com.example.cleanarchitecturestudy.base.BaseActivity<com.example.cleanarchitecturestudy.databinding.ActivityIntroBinding> {
    private boolean isReady = false;
    private boolean isStart = false;
    
    public IntroActivity() {
        super(0);
    }
    
    public final boolean isReady() {
        return false;
    }
    
    public final void setReady(boolean p0) {
    }
    
    public final boolean isStart() {
        return false;
    }
    
    public final void setStart(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initSplashScreen() {
    }
    
    private final void initData() {
    }
    
    /**
     * 최초 빌드 시, setOnExitAnimationListener 가 호출이 안됨.
     * 따라서 해당 경우에 MainActivity로 넘어가기 위하여 코드 추가.
     */
    private final void errorGuard() {
    }
    
    private final void startMainActivity() {
    }
}