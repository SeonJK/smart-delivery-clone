package com.seonjk.smartdeliveryclone.ui.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    appFinish: () -> Unit
) {
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.POST_NOTIFICATIONS
    ) { isGranted ->
        if (isGranted) {
            navigate(viewModel, navigateToLanding, navigateToMain)
        } else {
            appFinish()
        }
    }

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
                    onClickPositive = { permissionState.launchPermissionRequest() },
                    description = stringResource(id = R.string.permission_desc_2nd)
                        + stringResource(id = R.string.permission_desc_2nd_accent)
                        + stringResource(id = R.string.permission_desc_2nd_rest)
                )
            }

            DialogType.PERMISSION_RATIONALE -> {
                SDCDialog(
                    modifier = Modifier,
                    positiveText = "닫기",
                    onDismissRequest = { dialogType = null },
                    onClickPositive = { navigate(viewModel, navigateToLanding, navigateToMain) }
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        Log.d("Splash", "LaunchedEffect")
        delay(2000L)

        // 퍼미션 체크
        if (!permissionState.status.isGranted) {
            Log.d("Splash", "request permission")
            dialogType = if (permissionState.status.shouldShowRationale) {
                // 다시 재촉하는 다이얼로그
                DialogType.PERMISSION_RATIONALE
            } else {
                // 최초 다이얼로그
                DialogType.PERMISSION_FIRST
            }
            return@LaunchedEffect
        }

        kotlin.run { navigate(viewModel, navigateToLanding, navigateToMain) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SmartDeliveryCloneTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.splash_image),
            contentDescription = "splashImage",
            contentScale = ContentScale.Crop
        )
    }

    fun navigate() {
        if (viewModel.agreedService.value && viewModel.phoneAuthenticated.value) {
            Log.d("Splash", "navigate to main")
            // 홈 화면 이동
            run { navigateToMain() }
        } else {
            Log.d(
                "Splash",
                "agreedService: ${viewModel.agreedService.value}, phoneAuthenticated: ${viewModel.phoneAuthenticated.value}"
            )
            // 랜딩 화면 이동
            run { navigateToLanding() }
        }
    }
}

private fun navigate(viewModel: SplashViewModel, navigateToLanding: () -> Unit, navigateToMain: () -> Unit) {
    if (viewModel.agreedService.value && viewModel.phoneAuthenticated.value) {
        Log.d("Splash", "navigate to main")
        // 홈 화면 이동
        run { navigateToMain() }
    } else {
        Log.d(
            "Splash",
            "agreedService: ${viewModel.agreedService.value}, phoneAuthenticated: ${viewModel.phoneAuthenticated.value}"
        )
        // 랜딩 화면 이동
        run { navigateToLanding() }
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
            appFinish = {}
        )
    }
}