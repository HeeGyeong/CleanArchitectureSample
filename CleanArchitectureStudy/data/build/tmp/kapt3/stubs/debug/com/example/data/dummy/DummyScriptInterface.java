package com.example.data.dummy;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/data/dummy/DummyScriptInterface;", "", "()V", "repository", "Lcom/example/data/dummy/DummyRepository;", "getRepository", "()Lcom/example/data/dummy/DummyRepository;", "setRepository", "(Lcom/example/data/dummy/DummyRepository;)V", "dummyText", "", "arg", "", "dummyUrl", "data_debug"})
public final class DummyScriptInterface {
    @org.jetbrains.annotations.Nullable()
    private com.example.data.dummy.DummyRepository repository;
    
    public DummyScriptInterface() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dummy.DummyRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.Nullable()
    com.example.data.dummy.DummyRepository p0) {
    }
    
    @android.webkit.JavascriptInterface()
    public final void dummyText(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
    
    @android.webkit.JavascriptInterface()
    public final void dummyUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String arg) {
    }
}