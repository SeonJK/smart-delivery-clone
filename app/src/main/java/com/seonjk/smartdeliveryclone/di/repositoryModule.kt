package com.seonjk.smartdeliveryclone.di

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.data.repository.LandingRepositoryImpl
import com.seonjk.smartdeliveryclone.local.db.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<LandingRepository> { LandingRepositoryImpl(dataStore = androidContext().dataStore) }

}