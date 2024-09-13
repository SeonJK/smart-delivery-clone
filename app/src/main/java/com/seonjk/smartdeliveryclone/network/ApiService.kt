package com.seonjk.smartdeliveryclone.network

import com.seonjk.smartdeliveryclone.BuildConfig
import com.seonjk.smartdeliveryclone.data.entity.ShippingCompanies
import com.seonjk.smartdeliveryclone.data.entity.TrackingInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/trackingInfo?t_key=${BuildConfig.SMART_TRACKER_API_KEY}")
    suspend fun getTrackingInformation(
        @Query("t_code") companyCode: String,
        @Query("t_invoice") invoice: String
    ): Response<TrackingInfo>

    @GET("api/v1/companylist?t_key=${BuildConfig.SMART_TRACKER_API_KEY}")
    suspend fun getShippingCompanies(): Response<ShippingCompanies>

    @GET("api/v1/recommend?t_key=${BuildConfig.SMART_TRACKER_API_KEY}")
    suspend fun getRecommendShippingCompanies(
        @Query("t_invoice") invoice: String
    ): Response<ShippingCompanies>
}