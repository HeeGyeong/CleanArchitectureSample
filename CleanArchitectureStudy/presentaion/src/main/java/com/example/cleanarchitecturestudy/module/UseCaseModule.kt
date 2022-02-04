package com.example.cleanarchitecturestudy.module

import com.example.domain.usecase.movie.GetLocalMoviesUseCase
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.domain.usecase.movie.GetPagingMoviesUseCase
import com.example.domain.usecase.rank.ChangeCategoryUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * useCase 에 관련 된 Module.
 */
val useCaseModule: Module = module {
    single<ChangeCategoryUseCase> { ChangeCategoryUseCase(get()) }

    single<GetMoviesUseCase> { GetMoviesUseCase(get()) }
    single<GetPagingMoviesUseCase> { GetPagingMoviesUseCase(get()) }
    single<GetLocalMoviesUseCase> { GetLocalMoviesUseCase(get()) }
}