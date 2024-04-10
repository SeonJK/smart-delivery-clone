package com.seonjk.smartdeliveryclone.ui.landing.serviceagreement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPrivateInfoUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementAllUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetServiceAgreementUseCase
import kotlinx.coroutines.launch

class ServiceAgreementViewModel(
    private val setServiceAgreementAllUseCase: SetServiceAgreementAllUseCase,
    private val setServiceAgreementUseCase: SetServiceAgreementUseCase,
    private val setPrivateInfoUseCase: SetPrivateInfoUseCase
) : ViewModel() {

    private var _serviceAgreementAll = MutableLiveData<Boolean>()
    val serviceAgreementAll = _serviceAgreementAll

    private var _serviceAgreement = MutableLiveData<Boolean>()
    val serviceAgreement = _serviceAgreement

    private var _privateInfo = MutableLiveData<Boolean>()
    val privateInfo = _privateInfo

    fun setServiceAgreementAll(value: Boolean) = viewModelScope.launch {
        _serviceAgreementAll.postValue(value)
        _serviceAgreement.postValue(value)
        _privateInfo.postValue(value)
        setServiceAgreementAllUseCase(value)
        setServiceAgreementUseCase(value)
        setPrivateInfoUseCase(value)
    }

    fun setServiceAgreement(value: Boolean) = viewModelScope.launch {
        _serviceAgreement.postValue(value)
        if (privateInfo.value == true && value) {
            _serviceAgreementAll.postValue(value)
            setServiceAgreementAllUseCase(value)
        } else {
            setServiceAgreementUseCase(value)
        }
    }

    fun setPrivateInfo(value: Boolean) = viewModelScope.launch {
        _privateInfo.postValue(value)
        if (serviceAgreement.value == true && value) {
            _serviceAgreementAll.postValue(value)
            setServiceAgreementAllUseCase(value)
        } else {
            setPrivateInfoUseCase(value)
        }
    }
}