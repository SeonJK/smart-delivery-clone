package com.seonjk.smartdeliveryclone.di

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.data.repository.LandingRepositoryImpl
import com.seonjk.smartdeliveryclone.data.repository.ShippingCompanyRepository
import com.seonjk.smartdeliveryclone.data.repository.ShippingCompanyRepositoryImpl
import com.seonjk.smartdeliveryclone.data.repository.TrackingItemRepository
import com.seonjk.smartdeliveryclone.data.repository.TrackingItemRepositoryImpl
import com.seonjk.smartdeliveryclone.local.db.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<LandingRepository> { LandingRepositoryImpl(dataStore = androidContext().dataStore) }
    single<ShippingCompanyRepository> { ShippingCompanyRepositoryImpl(apiService = get()) }
    single<TrackingItemRepository> { TrackingItemRepositoryImpl(get(), get(), get()) }

}