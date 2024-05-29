package com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import com.seonjk.smartdeliveryclone.data.Response
import com.seonjk.smartdeliveryclone.domain.usecase.landing.SetPhoneAuthenticationUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class PhoneAuthenticationViewModel(
    private val setPhoneAuthenticationUseCase: SetPhoneAuthenticationUseCase
) : ViewModel() {
    companion object {
        private const val KOREAN_CODE = "+82"
    }

    private val auth: FirebaseAuth = Firebase.auth
    private var mVerificationId: String = ""

    private var _sendMessageState = MutableStateFlow<Response>(Response.Unspecified)
    val sendMessageState: Flow<Response> = _sendMessageState

    private var _verificationState = MutableStateFlow<Response>(Response.Unspecified)
    val verificationState: Flow<Response> = _verificationState

    fun sendAuthMessage(phoneNum: String, activity: Activity) {
        _sendMessageState.value = Response.Loading

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.e(
                    "PhoneAuthViewModel",
                    "sendAuthMessage()::onVerificationCompleted() : code=${credential.zzb()} + phoneNum=${credential.zzc()}"
                )
                verifyAuthCode(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.e(
                    "PhoneAuthViewModel",
                    "sendAuthMessage()::onVerificationFailed() : ${e.message}"
                )

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                    // reCAPTCHA verification attempted with null Activity
                }

                _sendMessageState.value = Response.Error(
                    data = false,
                    message = e.message ?: "empty message"
                )
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.e("PhoneAuthViewModel", "sendAuthMessage()::onCodeSent()")
                _sendMessageState.value = Response.Success(data = true)
                mVerificationId = verificationId
            }

            override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
                Log.e("PhoneAuthViewModel", "sendAuthMessage()::onCodeAutoRetrievalTimeOut()")
                _sendMessageState.value = Response.Unspecified
                mVerificationId = ""
            }
        }

        auth.useAppLanguage()

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(KOREAN_CODE + phoneNum)
            .setTimeout(30L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun verifyAuthCode(authNum: String) {
        val credential = PhoneAuthProvider.getCredential(mVerificationId, authNum)
        verifyAuthCode(credential)
    }

    private fun verifyAuthCode(credential: PhoneAuthCredential) {
        _verificationState.value = Response.Loading

        viewModelScope.launch {
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.e(
                            "PhoneAuthViewModel",
                            "verifyAuthCode()::signInWithCredential() : success"
                        )
                        viewModelScope.launch {
                            setPhoneAuthenticationUseCase(true)
                            _verificationState.value = Response.Success(data = true)
                        }
                    } else {
                        Log.e(
                            "PhoneAuthViewModel",
                            "verifyAuthCode()::signInWithCredential() : exception=${task.exception}"
                        )
                        _verificationState.value = Response.Error(
                            data = null,
                            message = task.exception?.message ?: "empty message"
                        )
                        _sendMessageState.value = Response.Unspecified
                        _verificationState.value = Response.Unspecified
                    }
                }
        }
    }
}