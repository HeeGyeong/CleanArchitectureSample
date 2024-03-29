// Generated by Dagger (https://dagger.dev).
package com.example.cleanarchitecturestudy.hilt;

import com.example.data.api.ApiInterface;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideApiInterfaceFactory implements Factory<ApiInterface> {
  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideApiInterfaceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiInterface get() {
    return provideApiInterface(retrofitProvider.get());
  }

  public static ApiModule_ProvideApiInterfaceFactory create(Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideApiInterfaceFactory(retrofitProvider);
  }

  public static ApiInterface provideApiInterface(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideApiInterface(retrofit));
  }
}
