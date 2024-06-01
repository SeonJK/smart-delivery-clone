@file:OptIn(ExperimentalMaterial3Api::class)

package com.seonjk.smartdeliveryclone.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationContents
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun DashBoardScreen(
    deliveryListViewModel: DeliveryListViewModel = koinViewModel(),
    diaryVewModel: DiaryViewModel = koinViewModel(),
    emoneyViewModel: EmoneyViewModel = koinViewModel(),
    reservationViewModel: ReservationViewModel = koinViewModel(),
    navigateToDiary: () -> Unit,
    navigateToDeliveryList: () -> Unit,
    navigateToReservation: () -> Unit,
    navigateToEmoney: () -> Unit,
) {
    Scaffold(
        containerColor = SmartDeliveryCloneTheme.colors.background,
        topBar = {
            Header(title = stringResource(R.string.nav_dashboard))
        },
    ) {
        DashBoardContents(
            padding = it,
            deliveryListViewModel = deliveryListViewModel,
            diaryVewModel = diaryVewModel,
            emoneyViewModel = emoneyViewModel,
            reservationViewModel = reservationViewModel,
            navigateToDiary= navigateToDiary,
            navigateToDeliveryList = navigateToDeliveryList,
            navigateToReservation = navigateToReservation,
            navigateToEmoney = navigateToEmoney,
        )
    }
}

@Composable
private fun DashBoardContents(
    padding: PaddingValues,
    deliveryListViewModel: DeliveryListViewModel,
    diaryVewModel: DiaryViewModel,
    emoneyViewModel: EmoneyViewModel,
    reservationViewModel: ReservationViewModel,
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
            .padding(paddingValues = padding)
            .padding(16.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.height(16.dp))

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
    SmartDeliveryCloneTheme {
        DashBoardScreen(
            deliveryListViewModel= koinViewModel(),
            diaryVewModel = koinViewModel(),
            emoneyViewModel = koinViewModel(),
            reservationViewModel = koinViewModel(),
            {}, {}, {}, {}
        )
    }
}