package com.seonjk.smartdeliveryclone.data.repository

import com.seonjk.smartdeliveryclone.data.db.TrackingItemDao
import com.seonjk.smartdeliveryclone.data.entity.TrackingInfo
import com.seonjk.smartdeliveryclone.data.entity.TrackingItem
import com.seonjk.smartdeliveryclone.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class TrackingItemRepositoryImpl(
    private val apiService: ApiService,
    private val trackingItemDao: TrackingItemDao,
    private val dispatcher: CoroutineDispatcher
) : TrackingItemRepository {
    override val trackingItems: Flow<List<TrackingItem>>
        = trackingItemDao.allTrackingItem()
        .distinctUntilChanged()
        .flowOn(dispatcher)

    override suspend fun getTrackingItemInfo(): List<Pair<TrackingItem, TrackingInfo>> {
        return trackingItemDao.getAll()
            .mapNotNull { trackingItem ->
                val relatedTrackingInfo = apiService.getTrackingInformation(
                    trackingItem.company.code,
                    trackingItem.invoice
                ).body()

                if (relatedTrackingInfo?.invoiceNo.isNullOrBlank()) {
                    null
                } else {
                    trackingItem to relatedTrackingInfo!!
                }
            }
            .sortedWith(
                compareBy(
                    { it.second.level },
                    { -(it.second.lastDetail?.time ?: Long.MAX_VALUE) }
                )
            )
    }

    override suspend fun getTrackingInfo(companyCode: String, invoice: String): TrackingInfo? {
        TODO("Not yet implemented")
    }

    override suspend fun saveTrackingItem(trackingItem: TrackingItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTrackingItem(trackingItem: TrackingItem) {
        TODO("Not yet implemented")
    }

}