package com.example.cleanarchitecturestudy.di.koin

import com.example.cleanarchitecturestudy.utils.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}