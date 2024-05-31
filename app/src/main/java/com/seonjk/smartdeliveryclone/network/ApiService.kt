package com.seonjk.smartdeliveryclone.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT = ""
    }

    suspend fun get() = client.get(END_POINT)
}