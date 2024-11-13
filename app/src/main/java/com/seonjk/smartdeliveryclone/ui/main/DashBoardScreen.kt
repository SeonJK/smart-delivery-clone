@file:OptIn(ExperimentalMaterial3Api::class)

package com.seonjk.smartdeliveryclone.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.navigation.Screen
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun DashBoardScreen(
    deliveryListViewModel: DeliveryListViewModel = koinViewModel(),
    diaryVewModel: DiaryViewModel = koinViewModel(),
    emoneyViewModel: EmoneyViewModel = koinViewModel(),
    reservationViewModel: ReservationViewModel = koinViewModel(),
    navigateToNoti: () -> Unit,
    showAddItemDialog: () -> Unit,
    navigateToSetting: () -> Unit,
    navigateToDiary: () -> Unit,
    navigateToDeliveryList: () -> Unit,
    navigateToReservation: () -> Unit,
    navigateToEmoney: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(SmartDeliveryCloneTheme.colors.background)
            .padding(16.dp, 0.dp)
    ) {
        Header(
            title = Screen.Main.DashBoard.title!!,
            actionButtons = {
                Button(onClick = navigateToNoti) {
                    Icon(
                        contentDescription = "알림함 버튼",
                        painter = painterResource(R.drawable.ic_read_all)
                    )
                }
                Button(onClick = showAddItemDialog) {
                    Icon(
                        contentDescription = "쇼핑몰 추가 버튼",
                        painter = painterResource(R.drawable.ic_read_all)
                    )
                }
                Button(onClick = navigateToSetting) {
                    Icon(
                        contentDescription = "더보기 버튼",
                        painter = painterResource(R.drawable.ic_read_all)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        val lastMonth = LocalDate.now().minusMonths(1).monthValue
        Text(
            text = "${lastMonth}월의 쇼핑",
            color = SmartDeliveryCloneTheme.colors.titleColor,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // TODO: goDiary
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = navigateToDiary,
            colors = ButtonDefaults.buttonColors(
                SmartDeliveryCloneTheme.colors.onBackground
            )
        ) {
            Text(
                text = "dummy",
                color = SmartDeliveryCloneTheme.colors.titleColor,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
fun DashBoardPreview() {
    val dummyDeliveryListViewModel = DeliveryListViewModel()
    val dummyDiaryViewModel = DiaryViewModel()
    val dummyEmoneyViewModel = EmoneyViewModel()
    val dummyReservationViewModel = ReservationViewModel()

    SmartDeliveryCloneTheme {
        DashBoardScreen(
            deliveryListViewModel= dummyDeliveryListViewModel,
            diaryVewModel = dummyDiaryViewModel,
            emoneyViewModel = dummyEmoneyViewModel,
            reservationViewModel = dummyReservationViewModel,
            {}, {}, {}, {}, {}, {}, {}
        )
    }
}