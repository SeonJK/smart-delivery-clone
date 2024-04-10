package com.seonjk.smartdeliveryclone.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.seonjk.smartdeliveryclone.domain.usecase.landing.FetchInitialServiceAgreementUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.GetPhoneAuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel(
    private val fetchInitialServiceAgreementUseCase: FetchInitialServiceAgreementUseCase,
    private val getPhoneAuthenticationUseCase: GetPhoneAuthenticationUseCase
) : ViewModel() {

    private var _agreedService = MutableLiveData<Boolean>()
    val agreedService: LiveData<Boolean> = _agreedService

    private var _phoneAuthenticated = MutableStateFlow(false)
    val phoneAuthenticated: LiveData<Boolean> = _phoneAuthenticated.asLiveData()

    fun fetchAgreementAll(): Job = viewModelScope.launch {
        _agreedService.postValue(fetchInitialServiceAgreementUseCase().serviceAgreementAll)
    }

    fun fetchPhoneAuthenticated(): Job = viewModelScope.launch {
        val authenticated = getPhoneAuthenticationUseCase()
    }


}