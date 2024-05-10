package com.seonjk.smartdeliveryclone.ui.landing.serviceagreement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPrivateInfoUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementAllUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ServiceAgreementViewModel(
    private val setServiceAgreementAllUseCase: SetServiceAgreementAllUseCase,
    private val setServiceAgreementUseCase: SetServiceAgreementUseCase,
    private val setPrivateInfoUseCase: SetPrivateInfoUseCase
) : ViewModel() {

    init {

    }

    private var _serviceAgreementAll = MutableStateFlow(false)
    val serviceAgreementAll = _serviceAgreementAll.asStateFlow()

    private var _serviceAgreement = MutableStateFlow(false)
    val serviceAgreement = _serviceAgreement.asStateFlow()

    private var _privateInfo = MutableStateFlow(false)
    val privateInfo = _privateInfo.asStateFlow()

    fun setServiceAgreementAll(value: Boolean) = viewModelScope.launch {
        _serviceAgreementAll.emit(value)
        _serviceAgreement.emit(value)
        _privateInfo.emit(value)
        setServiceAgreementAllUseCase(value)
        setServiceAgreementUseCase(value)
        setPrivateInfoUseCase(value)
    }

    fun setServiceAgreement(value: Boolean) = viewModelScope.launch {
        _serviceAgreement.emit(value)
        if (privateInfo.value && value) {
            _serviceAgreementAll.emit(value)
            setServiceAgreementAllUseCase(value)
        } else {
            setServiceAgreementUseCase(value)
        }
    }

    fun setPrivateInfo(value: Boolean) = viewModelScope.launch {
        _privateInfo.emit(value)
        if (serviceAgreement.value && value) {
            _serviceAgreementAll.emit(value)
            setServiceAgreementAllUseCase(value)
        } else {
            setPrivateInfoUseCase(value)
        }
    }
}