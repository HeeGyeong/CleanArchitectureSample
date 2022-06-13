package com.example.cleanarchitecturestudy.databinding;
import com.example.cleanarchitecturestudy.R;
import com.example.cleanarchitecturestudy.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWebBindingImpl extends ActivityWebBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 3);
        sViewsWithIds.put(R.id.web, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWebBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityWebBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.view.View) bindings[3]
            , (android.webkit.WebView) bindings[4]
            , (android.widget.ProgressBar) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.webProgress.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setVm((com.example.cleanarchitecturestudy.view.web.WebViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.example.cleanarchitecturestudy.view.web.WebViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmPercent((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeVmIsLoading((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmPercent(androidx.lifecycle.LiveData<java.lang.String> VmPercent, int fieldId) {
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

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int vmIsLoadingViewVISIBLEViewGONE = 0;
        androidx.lifecycle.LiveData<java.lang.String> vmPercent = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue = false;
        com.example.cleanarchitecturestudy.view.web.WebViewModel vm = mVm;
        java.lang.Boolean vmIsLoadingGetValue = null;
        java.lang.String vmPercentGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> vmIsLoading = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (vm != null) {
                        // read vm.percent
                        vmPercent = vm.getPercent();
                    }
                    updateLiveDataRegistration(0, vmPercent);


                    if (vmPercent != null) {
                        // read vm.percent.getValue()
                        vmPercentGetValue = vmPercent.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

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
                if((dirtyFlags & 0xeL) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
                    vmIsLoadingViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxVmIsLoadingGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, vmPercentGetValue);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.mboundView2.setVisibility(vmIsLoadingViewVISIBLEViewGONE);
            this.webProgress.setVisibility(vmIsLoadingViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.percent
        flag 1 (0x2L): vm.isLoading()
        flag 2 (0x3L): vm
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(vm.isLoading().getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}