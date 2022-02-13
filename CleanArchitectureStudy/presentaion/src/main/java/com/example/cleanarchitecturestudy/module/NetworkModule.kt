package com.example.cleanarchitecturestudy.module

import com.example.core.base.util.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}