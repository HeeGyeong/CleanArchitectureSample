// Generated by Dagger (https://dagger.dev).
package com.example.cleanarchitecturestudy.hilt;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.ktor.client.HttpClient;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideHttpClientFactory implements Factory<HttpClient> {
  @Override
  public HttpClient get() {
    return provideHttpClient();
  }

  public static ApiModule_ProvideHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpClient provideHttpClient() {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideHttpClient());
  }

  private static final class InstanceHolder {
    private static final ApiModule_ProvideHttpClientFactory INSTANCE = new ApiModule_ProvideHttpClientFactory();
  }
}
