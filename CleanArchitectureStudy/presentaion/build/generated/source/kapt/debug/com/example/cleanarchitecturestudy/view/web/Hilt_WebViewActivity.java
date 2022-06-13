package com.example.cleanarchitecturestudy.view.web;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import com.example.cleanarchitecturestudy.base.BaseActivity;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import java.lang.Object;
import java.lang.Override;

/**
 * A generated base class to be extended by the @dagger.hilt.android.AndroidEntryPoint annotated class. If using the Gradle plugin, this is swapped as the base class via bytecode transformation.
 */
public abstract class Hilt_WebViewActivity<B extends ViewDataBinding> extends BaseActivity<B> implements GeneratedComponentManagerHolder {
  private volatile ActivityComponentManager componentManager;

  private final Object componentManagerLock = new Object();

  Hilt_WebViewActivity(int layoutId) {
    super(layoutId);
  }

  @CallSuper
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    inject();
    super.onCreate(savedInstanceState);
  }

  @Override
  public final Object generatedComponent() {
    return this.componentManager().generatedComponent();
  }

  protected ActivityComponentManager createComponentManager() {
    return new ActivityComponentManager(this);
  }

  @Override
  public final ActivityComponentManager componentManager() {
    if (componentManager == null) {
      synchronized (componentManagerLock) {
        if (componentManager == null) {
          componentManager = createComponentManager();
        }
      }
    }
    return componentManager;
  }

  protected void inject() {
    ((WebViewActivity_GeneratedInjector) this.generatedComponent()).injectWebViewActivity(UnsafeCasts.<WebViewActivity>unsafeCast(this));
  }

  @Override
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
    ViewModelProvider.Factory factory = DefaultViewModelFactories.getActivityFactory(this);
    if (factory != null) {
      return factory;
    }
    return super.getDefaultViewModelProviderFactory();
  }
}
