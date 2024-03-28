package com.seonjk.smartdeliveryclone.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
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

            Button(onClick = navigateToLanding) {
                Text(text="이용약관으로 이동")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = navigateToMain) {
                Text(text="메인으로 이동")
            }

            // TODO: LaunchedEffect 사용법 익히기
//            LaunchedEffect {
//                delay(2000L)
//          // TODO: dataStore을 받아올 때 라이프사이클 고려해야 함 => LaunchedEffect로 하게 되면 LaunchedEffect가 코루틴이기 때문에 cancel작업을 따로 하지 않아도 됨
//                    if (serviceAgreementViewModel.initialServiceAgreement.value?.serviceAgreementAll == true) {
//                        // 홈 화면 이동
//
//                    } else {
//                        // 이용약관 동의 및 번호 인증 페이지 이동
//
//                    }
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