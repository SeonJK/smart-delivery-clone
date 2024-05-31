package com.seonjk.smartdeliveryclone.di

import com.seonjk.smartdeliveryclone.domain.usecase.landing.FetchInitialServiceAgreementUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.GetPhoneAuthenticationUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPhoneAuthenticationUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPrivateInfoUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementAllUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementUseCase
import org.koin.dsl.module

val useCaseModule = module {

    // Landing
    factory { FetchInitialServiceAgreementUseCase(get()) }
    factory { SetServiceAgreementAllUseCase(get()) }
    factory { SetServiceAgreementUseCase(get()) }
    factory { SetPrivateInfoUseCase(get()) }
    factory { GetPhoneAuthenticationUseCase(get()) }
    factory { SetPhoneAuthenticationUseCase(get()) }

}