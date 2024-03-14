package com.seonjk.smartdeliveryclone.ui.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun PhoneAuthenticationScreen(
    navigateToMain: () -> Unit
) {

}

@Preview
@Composable
fun PhoneAuthenticationPreview() {
    SmartDeliveryCloneTheme {
        PhoneAuthenticationScreen {  }
    }
}