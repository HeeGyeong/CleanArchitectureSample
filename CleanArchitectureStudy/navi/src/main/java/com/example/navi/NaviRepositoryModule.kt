package com.example.navi

import com.example.core.base.navi.NavigationInterface
import org.koin.core.module.Module
import org.koin.dsl.module

// 해당 모듈을 어디서 inject 만 시켜주면 사용 가능하다.
val naviRepositoryModule: Module = module {
   // single<NavigationInterface> { NavigationController() }
}