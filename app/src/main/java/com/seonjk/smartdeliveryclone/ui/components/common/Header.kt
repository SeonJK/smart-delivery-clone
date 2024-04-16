package com.seonjk.smartdeliveryclone.ui.components.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = SmartDeliveryCloneTheme.colors.titleColor,
                style = MaterialTheme.typography.titleLarge
            )
        },
    )
//    Row(
//        modifier = Modifier
//            .background(SmartDeliveryCloneTheme.colors.background)
//            .statusBarsPadding()
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.Start,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = stringResource(R.string.service_agreement),
//            color = SmartDeliveryCloneTheme.colors.titleColor,
//            style = MaterialTheme.typography.titleLarge
//        )
//    }
}