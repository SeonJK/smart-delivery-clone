package com.seonjk.smartdeliveryclone.domain.usecase.landing

import com.seonjk.smartdeliveryclone.data.repository.LandingRepository
import com.seonjk.smartdeliveryclone.domain.UseCase
import kotlinx.coroutines.flow.Flow

class GetPhoneAuthenticationUseCase(
    private val repository: LandingRepository
) : UseCase {

    suspend operator fun invoke(): Flow<Boolean> = repository.getPhoneAuthenticationPreferences()
}