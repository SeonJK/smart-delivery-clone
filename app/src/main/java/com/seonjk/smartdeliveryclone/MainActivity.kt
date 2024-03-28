package com.seonjk.smartdeliveryclone

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seonjk.smartdeliveryclone.navigation.RootNavHost
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

private const val USER_PREFERENCES_NAME = "user_preferences"
private val Context.dataStore by preferencesDataStore(name = USER_PREFERENCES_NAME)

@HiltAndroidApp
class SdcApplication : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val permissions: Array<String> = arrayOf(Manifest.permission.POST_NOTIFICATIONS)

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (!permissions.entries.all { it.value }) {
                goAlarmSetting()
            }
        }

    private fun goAlarmSetting() {
        Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS, Uri.parse("package:$packageName")).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SmartDeliveryCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SmartDeliveryCloneTheme.colors.background
                ) {
                    navController = rememberNavController()
                    RootNavHost(navController)

                    // TODO: dataStore을 받아올 때 라이프사이클 고려해야 함 => LaunchedEffect로 하게 되면 LaunchedEffect가 코루틴이기 때문에 cancel작업을 따로 하지 않아도 됨
//                    if (serviceAgreementViewModel.initialServiceAgreement.value?.serviceAgreementAll == true) {
//                        // 홈 화면 이동
//
//                    } else {
//                        // 이용약관 동의 및 번호 인증 페이지 이동
//
//                    }
                }
            }
        }
    }
}