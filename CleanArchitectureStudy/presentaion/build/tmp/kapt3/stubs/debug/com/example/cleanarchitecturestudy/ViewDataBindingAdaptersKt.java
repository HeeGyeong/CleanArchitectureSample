package com.example.cleanarchitecturestudy;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0007\u00a8\u0006\u0013"}, d2 = {"setAdapterItems", "", "Landroidx/recyclerview/widget/RecyclerView;", "items", "", "Lcom/example/domain/model/Movie;", "setEndlessScroll", "viewModel", "Lcom/example/cleanarchitecturestudy/view/search/MovieSearchViewModel;", "setHtmlText", "Landroid/widget/TextView;", "html", "", "setMovieRating", "Landroid/widget/RatingBar;", "score", "setUrlImage", "Landroid/widget/ImageView;", "url", "presentaion_debug"})
public final class ViewDataBindingAdaptersKt {
    
    /**
     * DataBinding
     */
    @androidx.databinding.BindingAdapter(value = {"setItems"})
    public static final void setAdapterItems(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$setAdapterItems, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.domain.model.Movie> items) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"movieRating"})
    public static final void setMovieRating(@org.jetbrains.annotations.NotNull()
    android.widget.RatingBar $this$setMovieRating, @org.jetbrains.annotations.NotNull()
    java.lang.String score) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"urlImage"})
    public static final void setUrlImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$setUrlImage, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"htmlText"})
    public static final void setHtmlText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setHtmlText, @org.jetbrains.annotations.NotNull()
    java.lang.String html) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"endlessScroll"})
    public static final void setEndlessScroll(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$setEndlessScroll, @org.jetbrains.annotations.NotNull()
    com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel viewModel) {
    }
}