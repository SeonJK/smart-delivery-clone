package com.seonjk.smartdeliveryclone.data.repository

import kotlinx.coroutines.flow.Flow

data class AgreementPreferences(
    val serviceAgreementAll: Boolean,
    val serviceAgreement: Boolean,
    val privateInfo: Boolean,
)


interface LandingRepository {

    suspend fun getPhoneAuthenticationPreferences(): Flow<Boolean>

    suspend fun setPhoneAuthentication(authenticated: Boolean)

    suspend fun getAgreementPreferences(): Flow<AgreementPreferences>

    suspend fun fetchInitialPreferences(): AgreementPreferences

    suspend fun setServiceAgreementAll(serviceAgreementAll: Boolean)

    suspend fun setServiceAgreement(serviceAgreement: Boolean)

    suspend fun setPrivateInfo(privateInfo: Boolean)
}
