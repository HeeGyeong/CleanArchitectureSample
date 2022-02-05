package com.example.cleanarchitecturestudy.module

import com.example.cleanarchitecturestudy.view.search.MovieSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * viewModel 에 관련 된 Module.
 *
 * viewModel 을 주입할 때는 viewModel 키워드를 사용하여 주입.
 * viewModel 의 경우 koin 이 viewModel 을 viewModelFactory 에 등록하고 바인딩 한다.
 */
val viewModelModule: Module = module {
    viewModel { MovieSearchViewModel(get(), get(), get(), get()) }
}