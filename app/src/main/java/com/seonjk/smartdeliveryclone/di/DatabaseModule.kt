package com.seonjk.smartdeliveryclone.di

import com.seonjk.smartdeliveryclone.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single { AppDatabase.build(androidApplication()) }
    single { get<AppDatabase>().trackingItemDao() }

}