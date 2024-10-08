package com.seonjk.smartdeliveryclone.di

import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationViewModel
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementViewModel
import com.seonjk.smartdeliveryclone.ui.main.DeliveryListViewModel
import com.seonjk.smartdeliveryclone.ui.main.DiaryViewModel
import com.seonjk.smartdeliveryclone.ui.main.EmoneyViewModel
import com.seonjk.smartdeliveryclone.ui.main.ReservationViewModel
import com.seonjk.smartdeliveryclone.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel(get(), get()) }
    viewModel { ServiceAgreementViewModel(get(), get(), get()) }
    viewModel { PhoneAuthenticationViewModel(get()) }
    viewModel { DeliveryListViewModel() }
    viewModel { DiaryViewModel() }
    viewModel { EmoneyViewModel() }
    viewModel { ReservationViewModel() }
}