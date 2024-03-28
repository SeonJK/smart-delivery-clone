package com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun PhoneAuthenticationScreen(
    viewModel: PhoneAuthenticationViewModel = viewModel(),
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