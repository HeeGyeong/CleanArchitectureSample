package com.example.cleanarchitecturestudy.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"apiModule", "Lorg/koin/core/module/Module;", "getApiModule", "()Lorg/koin/core/module/Module;", "presentaion_debug"})
public final class ApiModuleKt {
    
    /**
     * Api 사용에 관련 된 Module.
     *
     * Retrofit 에 관련된 선언을 이곳에서 처리한다.
     *
     * singe : SingleTon 객체 생성
     * factory : 요청 시 마다 새로운 객체를 생성
     * get() : 컴포넌트 내에서 알맞은 의존성을 주입.
     */
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module apiModule = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getApiModule() {
        return null;
    }
}