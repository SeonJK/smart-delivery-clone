package com.seonjk.smartdeliveryclone.ui.main

import androidx.lifecycle.ViewModel
import com.seonjk.smartdeliveryclone.data.api.Response
import com.seonjk.smartdeliveryclone.data.api.TrackingInfo
import com.seonjk.smartdeliveryclone.data.entity.TrackingItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DeliveryListViewModel(

) : ViewModel() {

    private var _listState = MutableStateFlow<Response>(Response.Unspecified)
    val listState: StateFlow<Response> = _listState.asStateFlow()

    fun showTrackingItemInfo(trackingItemInfo: List<Pair<TrackingItem, TrackingInfo>>) {

    }


}