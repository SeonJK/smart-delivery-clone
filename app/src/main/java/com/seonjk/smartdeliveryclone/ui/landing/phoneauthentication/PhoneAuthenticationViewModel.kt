package com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import com.seonjk.smartdeliveryclone.data.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class PhoneAuthenticationViewModel(

) : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    private var _sendMessageState = MutableStateFlow<Response>(Response.Unspecified)
    val sendMessageState: Flow<Response> = _sendMessageState

    private var _countTimer = MutableStateFlow(30)
    val countTimer: Flow<Int> = _countTimer

    fun sendAuthMessage(phoneNum: String, activity: Activity) {
        _sendMessageState.value = Response.Loading

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credentail: PhoneAuthCredential) {}

            override fun onVerificationFailed(e: FirebaseException) {
                Log.e("PhoneAuthViewModel", "sendAuthMessage()::onVerificationFailed() : ${e.message}")
                _sendMessageState.value = Response.Error(
                    data = false,
                    message = e.message ?: "empty message"
                )
            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                _sendMessageState.value = Response.Success(data = true)
                _countTimer.value = 30

                viewModelScope.launch {
                    while (_countTimer.value > 0) {
                        delay(1000L)
                        _countTimer.value -= 1
                    }
                    _countTimer.value = 0
                    _sendMessageState.value = Response.Unspecified
                }
            }

            override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
                _sendMessageState.value = Response.Unspecified
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNum)
            .setTimeout(30L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}