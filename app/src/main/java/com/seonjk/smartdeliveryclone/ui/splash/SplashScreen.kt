package com.seonjk.smartdeliveryclone.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.dialog.DialogType
import com.seonjk.smartdeliveryclone.ui.components.dialog.SDCDialog
import com.seonjk.smartdeliveryclone.ui.components.dialog.SDCPermissionDialog
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    navigateToLanding: () -> Unit,
    navigateToMain: () -> Unit,
    goAlarmSetting: () -> Unit
) {
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.POST_NOTIFICATIONS
    )

    var dialogType by remember {
        mutableStateOf<DialogType?>(value = null)
    }
    dialogType?.let { type ->
        when (type) {
            DialogType.PERMISSION_FIRST -> {
                SDCPermissionDialog(onClickPositive = { }) {
                    dialogType = DialogType.PERMISSION_SECOND
                }
            }

            DialogType.PERMISSION_SECOND -> {
                SDCDialog(
                    modifier = Modifier,
                    positiveText = "닫기",
                    onDismissRequest = { dialogType = null },
                    onClickPositive = goAlarmSetting
                )
            }

            DialogType.PERMISSION_RATIONALE -> {
                SDCDialog(
                    modifier = Modifier,
                    positiveText = "닫기",
                    onDismissRequest = { dialogType = null },
                    onClickPositive = { dialogType = null }
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SmartDeliveryCloneTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        // TODO: Remove this --------------------------------
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SplashScreen")

            Button(onClick = navigateToLanding) {
                Text(
                    text = "이용약관으로 이동",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = navigateToMain) {
                Text(
                    text = "메인으로 이동",
                    color = Color.White
                )
            }
            // TODO: ----------------------------------------------

            Image(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.splash_image),
                contentDescription = "splashImage",
                contentScale = ContentScale.Crop
            )
        }


    }

    LaunchedEffect(permissionState) {
        delay(2000L)

        // 퍼미션 체크
        if (!permissionState.status.isGranted) {
            dialogType = if (permissionState.status.shouldShowRationale) {
                // 다시 재촉하는 다이얼로그
                DialogType.PERMISSION_RATIONALE
            } else {
                // 최초 다이얼로그
                DialogType.PERMISSION_FIRST
            }
        }

        // dataStore을 받아올 때 라이프사이클 고려해야 함
        // => LaunchedEffect로 하게 되면 LaunchedEffect가 코루틴이기 때문에 cancel작업을 따로 하지 않아도 됨
        if (viewModel.agreedService.value && viewModel.phoneAuthenticated.value) {
            // 홈 화면 이동
            kotlin.run { navigateToMain }
        } else {
            // 랜딩 화면 이동
            kotlin.run { navigateToLanding }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SmartDeliveryCloneTheme {
        SplashScreen(
            viewModel = koinViewModel<SplashViewModel>(),
            navigateToLanding = {},
            navigateToMain = {},
            goAlarmSetting = {}
        )
    }
}