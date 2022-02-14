package com.example.cleanarchitecturestudy.di

import android.app.Application
import com.example.cleanarchitecturestudy.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Koin 을 사용하기 위한 Class
 * context 와 module 을 선언하여 주입시킨다.
 *
 * 해당 class 는 Manifest 에 선언하여 사용하기 때문에 별다른 호출부는 존재하지 않는다.
 */
class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)

            /*// vararg 로 넣어서 선언 가능.
            modules(
                apiModule,
                networkModule,
                rankingDataModule,
                repositoryModule,
                selectDataModule,
                viewModelModule
            )*/

            // 개별로 선언 가능
            modules(apiModule)
            modules(localDataModule)
            modules(networkModule)
            modules(remoteDataModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(useCaseModule)
        }
    }
}