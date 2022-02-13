package com.example.cleanarchitecturestudy.module

import com.example.cleanarchitecturestudy.navigation.NavigationController
import com.example.core.base.navi.Navigation
import com.example.core.base.navi.NavigationInterface
import org.koin.core.module.Module
import org.koin.dsl.module

val navigationModule: Module = module {
    single { Navigation(get()) }

    single<NavigationInterface> { NavigationController() }
}