package com.example.cleanarchitecturestudy.di;

import java.lang.System;

/**
 * Koin 을 사용하기 위한 Class
 * context 와 module 을 선언하여 주입시킨다.
 *
 * 해당 class 는 Manifest 에 선언하여 사용하기 때문에 별다른 호출부는 존재하지 않는다.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/example/cleanarchitecturestudy/di/KoinApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "presentaion_debug"})
public final class KoinApplication extends android.app.Application {
    
    public KoinApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}