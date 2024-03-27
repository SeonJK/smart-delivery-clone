package com.seonjk.smartdeliveryclone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToLanding: () -> Unit,
    navigateToMain: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = SmartDeliveryCloneTheme.colors.background
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SplashScreen")

            // TODO: LaunchedEffect 사용법 익히기
//            LaunchedEffect {
//                delay(2000L)
//
//            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SmartDeliveryCloneTheme {
        SplashScreen(
            navigateToLanding = {},
            navigateToMain = {}
        )
    }
}