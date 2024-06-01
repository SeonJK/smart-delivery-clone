package com.seonjk.smartdeliveryclone.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiaryViewModel(

) : ViewModel() {

    // TODO: 년월에 총 지출액을 가져온다.
    private var _totalLastMonthExpense: MutableStateFlow<Int> = MutableStateFlow(0)
    val totalLastMonthExpense = _totalLastMonthExpense.asStateFlow()

    //
}