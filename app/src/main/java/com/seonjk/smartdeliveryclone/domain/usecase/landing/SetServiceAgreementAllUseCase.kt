package com.seonjk.smartdeliveryclone.domain.usecase.landing

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.domain.UseCase

class SetServiceAgreementAllUseCase(
    private val repository: LandingRepository
) : UseCase {

    suspend operator fun invoke(serviceAgreementAll: Boolean) =
        repository.setServiceAgreementAll(serviceAgreementAll)
}