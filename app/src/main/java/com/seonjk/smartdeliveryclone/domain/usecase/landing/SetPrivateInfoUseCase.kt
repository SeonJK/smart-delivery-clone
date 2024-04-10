package com.seonjk.smartdeliveryclone.domain.usecase.landing

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.domain.UseCase

class SetPrivateInfoUseCase(
    private val repository: LandingRepository
) : UseCase {

    suspend operator fun invoke(privateInfo: Boolean) = repository.setPrivateInfo(privateInfo)
}