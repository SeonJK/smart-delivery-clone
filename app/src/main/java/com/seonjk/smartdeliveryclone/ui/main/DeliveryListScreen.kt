package com.seonjk.smartdeliveryclone.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.navigation.Screen
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeliveryListScreen(
    deliveryListViewModel: DeliveryListViewModel = koinViewModel(),
    showReadAllDialog: () -> Unit,
    showAddItemDialog: () -> Unit,
    navigateToSearch: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SmartDeliveryCloneTheme.colors.background)
            .padding(16.dp, 0.dp)
    ) {

        Header(
            title = Screen.Main.DeliveryList.title!!,
            actionButtons = {
                Button(onClick = showReadAllDialog) {
                    Icon(
                        contentDescription = "모두 읽음 처리 버튼",
                        painter = painterResource(R.drawable.ic_read_all)
                    )
                }
                Button(onClick = navigateToSearch) {
                    Icon(
                        contentDescription = "검색 버튼",
                        painter = painterResource(R.drawable.ic_search)
                    )
                }
                Button(onClick = showAddItemDialog) {
                    Icon(
                        contentDescription = "쇼핑몰 추가 버튼",
                        painter = painterResource(R.drawable.ic_plus)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        // TODO: HorizontalPager 구현

    }

}