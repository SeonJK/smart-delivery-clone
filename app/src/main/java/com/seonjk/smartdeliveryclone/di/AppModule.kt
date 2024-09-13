package com.seonjk.smartdeliveryclone.di

import org.koin.dsl.module


val appModule = module {
    includes(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        databaseModule,
        networkModule
    )
}
