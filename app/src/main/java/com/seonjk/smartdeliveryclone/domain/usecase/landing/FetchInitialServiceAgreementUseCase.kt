package com.seonjk.smartdeliveryclone.domain.usecase.landing

import com.seonjk.smartdeliveryclone.data.repository.AgreementPreferences
import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.domain.UseCase

class FetchInitialServiceAgreementUseCase(
    private val repository: LandingRepository
) : UseCase {

    suspend operator fun invoke(): AgreementPreferences = repository.fetchInitialPreferences()
}