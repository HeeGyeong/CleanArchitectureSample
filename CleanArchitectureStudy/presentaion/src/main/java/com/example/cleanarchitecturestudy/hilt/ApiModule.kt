package com.example.cleanarchitecturestudy.hilt

import android.annotation.SuppressLint
import com.example.cleanarchitecturestudy.BuildConfig
import com.example.data.api.ApiClient
import com.example.data.api.ApiInterface
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ApiModule {

    /*@Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }*/

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @SuppressLint("Lint-LogDetector")
    @Singleton
    @Provides
    // return 값 없다고 오류 떠서 추가.
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .run {
                // Interceptor
                addInterceptor(Interceptor { chain ->
                    with(chain) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Naver-Client-Id", "33chRuAiqlSn5hn8tIme")
                            .addHeader("X-Naver-Client-Secret", "fyfwt9PCUN")
                            .build()
                        proceed(newRequest)
                    }
                })

                connectTimeout(60, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)

                // Logging Interceptor
                addInterceptor(HttpLoggingInterceptor { message ->
                    Logger.d(message)
                }.let {
                    if (BuildConfig.DEBUG) {
                        Logger.addLogAdapter(AndroidLogAdapter())
                        it.setLevel(HttpLoggingInterceptor.Level.BODY)
                    } else {
                        it.setLevel(HttpLoggingInterceptor.Level.NONE)
                    }
                })
                build()
            }
    }
}