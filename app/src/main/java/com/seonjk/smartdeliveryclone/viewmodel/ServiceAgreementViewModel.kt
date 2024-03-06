package com.seonjk.smartdeliveryclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.seonjk.smartdeliveryclone.repository.ServiceAgreementRepository

class ServiceAgreementViewModel(
    private val repository: ServiceAgreementRepository
) : ViewModel() {

    val initialServiceAgreement = liveData {
        emit(repository.fetchInitialPreferences())
    }

    private val agreementPreferencesFlow = repository.getAgreementPreferences()
    val agreementPreferencesLiveData = agreementPreferencesFlow.asLiveData()
}

class ServiceAgreementViewModelFactory(
    private val repository: ServiceAgreementRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ServiceAgreementViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ServiceAgreementViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}