package com.seonjk.smartdeliveryclone.data.repository

import com.seonjk.smartdeliveryclone.data.entity.TrackingItem
import com.seonjk.smartdeliveryclone.data.api.TrackingInfo
import kotlinx.coroutines.flow.Flow

interface TrackingItemRepository {

    suspend fun getTrackingItemInfo(): List<Pair<TrackingItem, TrackingInfo>>

    suspend fun getTrackingInfo(companyCode: String, invoice: String): TrackingInfo?

    suspend fun saveTrackingItem(trackingItem: TrackingItem)

    suspend fun deleteTrackingItem(trackingItem: TrackingItem)
}