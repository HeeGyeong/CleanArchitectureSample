package com.example.cleanarchitecturestudy.databinding;
import com.example.cleanarchitecturestudy.R;
import com.example.cleanarchitecturestudy.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMovieSearchBindingImpl extends ActivityMovieSearchBinding implements com.example.cleanarchitecturestudy.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etInputandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.query.getValue()
            //         is vm.query.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etInput);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel vm = mVm;
            // vm.query != null
            boolean vmQueryJavaLangObjectNull = false;
            // vm.query.getValue()
            java.lang.String vmQueryGetValue = null;
            // vm.query
            androidx.lifecycle.MutableLiveData<java.lang.String> vmQuery = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmQuery = vm.getQuery();

                vmQueryJavaLangObjectNull = (vmQuery) != (null);
                if (vmQueryJavaLangObjectNull) {




                    vmQuery.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityMovieSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityMovieSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (android.widget.ProgressBar) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            );
        this.btnSearch.setTag(null);
        this.btnSearchFlow.setTag(null);
        this.etInput.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.pbLoading.setTag(null);
        this.rvMovies.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.cleanarchitecturestudy.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.cleanarchitecturestudy.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.vm == variableId) {
            setVm((com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmMovieList((androidx.lifecycle.LiveData<java.util.List<com.example.domain.model.Movie>>) object, fieldId);
            case 1 :
                return onChangeVmIsLoading((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeVmQuery((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmMovieList(androidx.lifecycle.LiveData<java.util.List<com.example.domain.model.Movie>> VmMovieList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmIsLoading(androidx.lifecycle.LiveData<java.lang.Boolean> VmIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmQuery(androidx.lifecycle.MutableLiveData<java.lang.String> VmQuery, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
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
        int vmIsLoadingViewVISIBLEViewGONE = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue = false;
        java.lang.String vmQueryGetValue = null;
        com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel vm = mVm;
        androidx.lifecycle.LiveData<java.util.List<com.example.domain.model.Movie>> vmMovieList = null;
        java.lang.Boolean vmIsLoadingGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> vmIsLoading = null;
        java.util.List<com.example.domain.model.Movie> vmMovieListGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmQuery = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.movieList
                        vmMovieList = vm.getMovieList();
                    }
                    updateLiveDataRegistration(0, vmMovieList);


                    if (vmMovieList != null) {
                        // read vm.movieList.getValue()
                        vmMovieListGetValue = vmMovieList.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (vm != null) {
                        // read vm.isLoading()
                        vmIsLoading = vm.isLoading();
                    }
                    updateLiveDataRegistration(1, vmIsLoading);


                    if (vmIsLoading != null) {
                        // read vm.isLoading().getValue()
                        vmIsLoadingGetValue = vmIsLoading.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue())
                    androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue = androidx.databinding.ViewDataBinding.safeUnbox(vmIsLoadingGetValue);
                if((dirtyFlags & 0x1aL) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
                    vmIsLoadingViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (vm != null) {
                        // read vm.query
                        vmQuery = vm.getQuery();
                    }
                    updateLiveDataRegistration(2, vmQuery);


                    if (vmQuery != null) {
                        // read vm.query.getValue()
                        vmQueryGetValue = vmQuery.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnSearch.setOnClickListener(mCallback1);
            this.btnSearchFlow.setOnClickListener(mCallback2);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etInput, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etInputandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etInput, vmQueryGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.pbLoading.setVisibility(vmIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.example.cleanarchitecturestudy.ViewDataBindingAdaptersKt.setEndlessScroll(this.rvMovies, vm);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            com.example.cleanarchitecturestudy.ViewDataBindingAdaptersKt.setAdapterItems(this.rvMovies, vmMovieListGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {


                    vm.requestMovie();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {


                    vm.requestMovieFlow();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.movieList
        flag 1 (0x2L): vm.isLoading()
        flag 2 (0x3L): vm.query
        flag 3 (0x4L): vm
        flag 4 (0x5L): null
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}