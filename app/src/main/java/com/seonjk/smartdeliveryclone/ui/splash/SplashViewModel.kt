package com.seonjk.smartdeliveryclone.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seonjk.smartdeliveryclone.domain.usecase.landing.FetchInitialServiceAgreementUseCase
import com.seonjk.smartdeliveryclone.domain.usecase.landing.GetPhoneAuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel(
    private val fetchInitialServiceAgreementUseCase: FetchInitialServiceAgreementUseCase,
    private val getPhoneAuthenticationUseCase: GetPhoneAuthenticationUseCase
) : ViewModel() {

    init {
        fetchAgreementAll()
        fetchPhoneAuthenticated()
    }

    private var _agreedService = MutableStateFlow(false)
    val agreedService = _agreedService.asStateFlow()

    private var _phoneAuthenticated = MutableStateFlow(false)
    val phoneAuthenticated = _phoneAuthenticated.asStateFlow()

    fun fetchAgreementAll(): Job = viewModelScope.launch(Dispatchers.IO) {
        _agreedService.emit(fetchInitialServiceAgreementUseCase().serviceAgreementAll)
    }

    fun fetchPhoneAuthenticated(): Job = viewModelScope.launch(Dispatchers.IO) {
        getPhoneAuthenticationUseCase().collectLatest {
            _phoneAuthenticated.emit(it)
        }
    }


}