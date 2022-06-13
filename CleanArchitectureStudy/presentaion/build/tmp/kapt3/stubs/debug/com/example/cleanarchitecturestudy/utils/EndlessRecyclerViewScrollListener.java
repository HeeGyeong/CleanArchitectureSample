package com.example.cleanarchitecturestudy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J \u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0016J\u0006\u0010\"\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/cleanarchitecturestudy/utils/EndlessRecyclerViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Landroidx/recyclerview/widget/GridLayoutManager;", "(Landroidx/recyclerview/widget/GridLayoutManager;)V", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "(Landroidx/recyclerview/widget/StaggeredGridLayoutManager;)V", "currentPage", "", "loading", "", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "previousTotalItemCount", "startingPageIndex", "visibleThreshold", "getLastVisibleItem", "lastVisibleItemPositions", "", "onLoadMore", "", "page", "totalItemsCount", "view", "Landroidx/recyclerview/widget/RecyclerView;", "onScrolled", "dx", "dy", "resetState", "presentaion_debug"})
public abstract class EndlessRecyclerViewScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotalItemCount = 0;
    private boolean loading = true;
    private final int startingPageIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private androidx.recyclerview.widget.RecyclerView.LayoutManager mLayoutManager;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getMLayoutManager() {
        return null;
    }
    
    public final void setMLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    public EndlessRecyclerViewScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
        super();
    }
    
    public EndlessRecyclerViewScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.GridLayoutManager layoutManager) {
        super();
    }
    
    public EndlessRecyclerViewScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.StaggeredGridLayoutManager layoutManager) {
        super();
    }
    
    private final int getLastVisibleItem(int[] lastVisibleItemPositions) {
        return 0;
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView view, int dx, int dy) {
    }
    
    public final void resetState() {
    }
    
    public abstract void onLoadMore(int page, int totalItemsCount, @org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView view);
}