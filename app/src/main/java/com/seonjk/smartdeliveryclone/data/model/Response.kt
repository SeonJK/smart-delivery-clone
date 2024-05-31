package com.seonjk.smartdeliveryclone.data.model

sealed class Response() {
    object Unspecified: Response()
    object Loading: Response()
    data class Success<T>(val data: T? = null): Response()
    data class Error<T>(val data: T? = null, val message: String): Response()
}