package com.seonjk.smartdeliveryclone.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class LandingRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
) : LandingRepository {

    private val TAG: String = "LandingRepositoryImpl"

    object LandingPreferenceKeys {
        val SERVICE_AGREEMENT_ALL = booleanPreferencesKey("service_agreement_all")
        val SERVICE_AGREEMENT = booleanPreferencesKey("service_agreement")
        val PRIVATE_INFO_AGREEMENT = booleanPreferencesKey("private_info_agreement")
        val PHONE_AUTHENTICATED = booleanPreferencesKey("phone_authenticated")
    }

    private val agreementPreferencesFlow: Flow<AgreementPreferences> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            mapAgreementPreferences(preferences)
        }

    private val phoneAuthenticationFlow: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val reuslt =preferences[LandingPreferenceKeys.PHONE_AUTHENTICATED] ?: false
            reuslt
        }

    override suspend fun getPhoneAuthenticationPreferences(): Flow<Boolean> =
       phoneAuthenticationFlow

    override suspend fun setPhoneAuthentication(authenticated: Boolean) {
        dataStore.edit { preference ->
            preference[LandingPreferenceKeys.PHONE_AUTHENTICATED] = authenticated
        }
    }

    override suspend fun getAgreementPreferences(): Flow<AgreementPreferences> =
        agreementPreferencesFlow

    override suspend fun fetchInitialPreferences() =
        mapAgreementPreferences(dataStore.data.first().toPreferences())

    override suspend fun setServiceAgreementAll(serviceAgreementAll: Boolean) {
        dataStore.edit { preferences ->
            preferences[LandingPreferenceKeys.SERVICE_AGREEMENT_ALL] = serviceAgreementAll
        }
    }

    override suspend fun setServiceAgreement(serviceAgreement: Boolean) {
        dataStore.edit { preferences ->
            preferences[LandingPreferenceKeys.SERVICE_AGREEMENT] = serviceAgreement
        }
    }

    override suspend fun setPrivateInfo(privateInfo: Boolean) {
        dataStore.edit { preferences ->
            preferences[LandingPreferenceKeys.PRIVATE_INFO_AGREEMENT] = privateInfo
        }
    }

    private fun mapAgreementPreferences(preferences: Preferences): AgreementPreferences {
        val serviceAgreementAll = preferences[LandingPreferenceKeys.SERVICE_AGREEMENT_ALL] ?: false
        val serviceAgreement = preferences[LandingPreferenceKeys.SERVICE_AGREEMENT] ?: false
        val privateInfo = preferences[LandingPreferenceKeys.PRIVATE_INFO_AGREEMENT] ?: false
        return AgreementPreferences(serviceAgreementAll, serviceAgreement, privateInfo)
    }
}