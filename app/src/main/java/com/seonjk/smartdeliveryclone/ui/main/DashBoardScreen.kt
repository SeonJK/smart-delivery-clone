package com.seonjk.smartdeliveryclone.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun DashBoardScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = SmartDeliveryCloneTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "DashBoardScreen")
        }
    }
}

@Preview
@Composable
fun DashBoardPreview() {
    SmartDeliveryCloneTheme {
        DashBoardScreen()
    }
}