package com.example.cleanarchitecturestudy.di;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = DIApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface DIApplication_GeneratedInjector {
  void injectDIApplication(DIApplication dIApplication);
}
