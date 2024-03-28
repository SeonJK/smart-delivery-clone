package com.seonjk.smartdeliveryclone.ui.landing.serviceagreement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.seonjk.smartdeliveryclone.repository.ServiceAgreementRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiceAgreementViewModel @Inject constructor(
    private val repository: ServiceAgreementRepository
) : ViewModel() {

    val initialServiceAgreement = liveData {
        emit(repository.fetchInitialPreferences())
    }

    private val agreementPreferencesFlow = repository.getAgreementPreferences()
    val agreementPreferencesLiveData = agreementPreferencesFlow.asLiveData()
}