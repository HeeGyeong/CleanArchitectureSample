package com.example.cleanarchitecturestudy.module

import android.util.Log
import com.example.data.api.ApiClient
import com.example.data.api.ApiInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Api 사용에 관련 된 Module.
 *
 * Retrofit 에 관련된 선언을 이곳에서 처리한다.
 *
 * singe : SingleTon 객체 생성
 * factory : 요청 시 마다 새로운 객체를 생성
 * get() : 컴포넌트 내에서 알맞은 의존성을 주입.
 */
val apiModule: Module = module {

    // ApiInterface 는 Api 호출 시 사용하는 부분.
    // ApiInterface 를 single(Singleton) 으로 Retrofit 컴포넌트를 주입한다.
    single<ApiInterface> { get<Retrofit>().create(ApiInterface::class.java) }

    // Retrofit setting
    single<Retrofit> {
        Log.d("useCase" , "call single<Retrofit>")
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }
    
    single<GsonConverterFactory> { GsonConverterFactory.create() }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .run {
                Log.d("useCase" , "call single<OkHttpClient>")
                addInterceptor(get<Interceptor>()) // 하단에 선언한 Intercepter 를 주입
                
                // 통신 시 시간 관련 option 추가
                connectTimeout(60, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
                
                build()
            }
    }

    single<Interceptor> {
        Interceptor { chain ->
            with(chain) {
                Log.d("useCase" , "call single<Interceptor>")

                // Api 통신 시, Header 에 추가할 값들.
                val newRequest = request().newBuilder()
                    .addHeader("X-Naver-Client-Id", "33chRuAiqlSn5hn8tIme")
                    .addHeader("X-Naver-Client-Secret", "fyfwt9PCUN")
                    .build()
                proceed(newRequest)
            }
        }
    }
}