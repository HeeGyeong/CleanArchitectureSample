package com.example.cleanarchitecturestudy.view.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u001b\u001cB\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010\u001a\u001a\u00020\u00072\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/search/MovieAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/domain/model/Movie;", "Lcom/example/cleanarchitecturestudy/view/search/MovieAdapter$ViewHolder;", "Lcom/example/cleanarchitecturestudy/utils/ItemMoveCallback$ItemTouchInterface;", "itemClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "movieList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onRowClear", "itemViewHolder", "onRowMoved", "fromPosition", "toPosition", "onRowSelected", "setMovieList", "Companion", "ViewHolder", "presentaion_debug"})
public final class MovieAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.domain.model.Movie, com.example.cleanarchitecturestudy.view.search.MovieAdapter.ViewHolder> implements com.example.cleanarchitecturestudy.utils.ItemMoveCallback.ItemTouchInterface {
    private final kotlin.jvm.functions.Function1<com.example.domain.model.Movie, kotlin.Unit> itemClick = null;
    private java.util.ArrayList<com.example.domain.model.Movie> movieList;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cleanarchitecturestudy.view.search.MovieAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.domain.model.Movie> diffUtil = null;
    
    public MovieAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.domain.model.Movie, kotlin.Unit> itemClick) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.cleanarchitecturestudy.view.search.MovieAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.cleanarchitecturestudy.view.search.MovieAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onRowMoved(int fromPosition, int toPosition) {
    }
    
    @java.lang.Override()
    public void onRowSelected(@org.jetbrains.annotations.Nullable()
    com.example.cleanarchitecturestudy.view.search.MovieAdapter.ViewHolder itemViewHolder) {
    }
    
    @java.lang.Override()
    public void onRowClear(@org.jetbrains.annotations.Nullable()
    com.example.cleanarchitecturestudy.view.search.MovieAdapter.ViewHolder itemViewHolder) {
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.domain.model.Movie> movieList) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/search/MovieAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cleanarchitecturestudy/databinding/ItemMovieBinding;", "(Lcom/example/cleanarchitecturestudy/databinding/ItemMovieBinding;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "rowView", "Landroid/view/View;", "getRowView", "()Landroid/view/View;", "setRowView", "(Landroid/view/View;)V", "bind", "", "movie", "Lcom/example/domain/model/Movie;", "presentaion_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.cleanarchitecturestudy.databinding.ItemMovieBinding binding = null;
        @org.jetbrains.annotations.Nullable()
        private android.content.Context context;
        @org.jetbrains.annotations.Nullable()
        private android.view.View rowView;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.cleanarchitecturestudy.databinding.ItemMovieBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.Nullable()
        android.content.Context p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.view.View getRowView() {
            return null;
        }
        
        public final void setRowView(@org.jetbrains.annotations.Nullable()
        android.view.View p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.domain.model.Movie movie) {
        }
    }
    
    /**
     * diff object
     *
     * 서로 같은 아이템인지 판단하기 위한 조건을 직접 추가한다.
     * title 을 사용하여 같은 아이템인지 여부를 판단하도록 하였다.
     */
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/cleanarchitecturestudy/view/search/MovieAdapter$Companion;", "", "()V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/domain/model/Movie;", "getDiffUtil", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "presentaion_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.domain.model.Movie> getDiffUtil() {
            return null;
        }
    }
}