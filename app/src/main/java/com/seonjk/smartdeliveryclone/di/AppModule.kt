package com.seonjk.smartdeliveryclone.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.data.repository.LandingRepositoryImpl
import com.seonjk.smartdeliveryclone.domain.usecase.landing.FetchInitialServiceAgreementUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.GetPhoneAuthenticationUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPrivateInfoUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementAllUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementUseCase
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementViewModel
import com.seonjk.smartdeliveryclone.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    // ViewModel
    viewModel { SplashViewModel(get(), get()) }
    viewModel { ServiceAgreementViewModel(get(), get(), get()) }

    // UseCase
        // Landing
        factory { FetchInitialServiceAgreementUseCase(get()) }
        factory { SetServiceAgreementAllUseCase(get()) }
        factory { SetServiceAgreementUseCase(get()) }
        factory { SetPrivateInfoUseCase(get()) }
        factory { GetPhoneAuthenticationUseCase(get()) }

    // Repository
    single<LandingRepository> { LandingRepositoryImpl(dataStore = androidContext().dataStore) }

    //
}

private const val USER_PREFERENCES_NAME = "user_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_NAME)