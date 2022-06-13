package com.example.cleanarchitecturestudy.databinding;
import com.example.cleanarchitecturestudy.R;
import com.example.cleanarchitecturestudy.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemMovieBindingImpl extends ItemMovieBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemMovieBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ItemMovieBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.RatingBar) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.ivPoster.setTag(null);
        this.mboundView0 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[0];
        this.mboundView0.setTag(null);
        this.rbRating.setTag(null);
        this.tvActor.setTag(null);
        this.tvDirector.setTag(null);
        this.tvReleaseDate.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.movie == variableId) {
            setMovie((com.example.domain.model.Movie) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovie(@Nullable com.example.domain.model.Movie Movie) {
        this.mMovie = Movie;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.movie);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String movieTitle = null;
        java.lang.String moviePubDate = null;
        com.example.domain.model.Movie movie = mMovie;
        java.lang.String movieUserRating = null;
        java.lang.String movieActor = null;
        java.lang.String movieImage = null;
        java.lang.String movieDirector = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movie != null) {
                    // read movie.title
                    movieTitle = movie.getTitle();
                    // read movie.pubDate
                    moviePubDate = movie.getPubDate();
                    // read movie.userRating
                    movieUserRating = movie.getUserRating();
                    // read movie.actor
                    movieActor = movie.getActor();
                    // read movie.image
                    movieImage = movie.getImage();
                    // read movie.director
                    movieDirector = movie.getDirector();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.cleanarchitecturestudy.ViewDataBindingAdaptersKt.setUrlImage(this.ivPoster, movieImage);
            com.example.cleanarchitecturestudy.ViewDataBindingAdaptersKt.setMovieRating(this.rbRating, movieUserRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvActor, movieActor);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDirector, movieDirector);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvReleaseDate, moviePubDate);
            com.example.cleanarchitecturestudy.ViewDataBindingAdaptersKt.setHtmlText(this.tvTitle, movieTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movie
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}