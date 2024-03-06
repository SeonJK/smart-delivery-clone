package com.seonjk.smartdeliveryclone.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

data class AgreementPreferences(
    val serviceAgreementAll: Boolean,
    val serviceAgreement: Boolean,
    val privateInfo: Boolean,
)


interface ServiceAgreementRepository {

    fun getAgreementPreferences(): Flow<AgreementPreferences>

    suspend fun fetchInitialPreferences(): AgreementPreferences

    suspend fun setServiceAgreementAll(serviceAgreementAll: Boolean)

    suspend fun setServiceAgreement(serviceAgreement: Boolean)

    suspend fun setPrivateInfo(privateInfo: Boolean)
}
