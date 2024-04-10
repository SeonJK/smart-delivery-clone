package com.seonjk.smartdeliveryclone.domain.usecase.landing

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.domain.UseCase

class SetServiceAgreementUseCase(
    private val repository: LandingRepository
) : UseCase {

    suspend operator fun invoke(serviceAgreement: Boolean) =
        repository.setServiceAgreement(serviceAgreement)
}