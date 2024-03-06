package com.seonjk.smartdeliveryclone

import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import com.seonjk.smartdeliveryclone.viewmodels.MainViewModel
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryColors
import com.seonjk.smartdeliveryclone.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
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

        // 스플래시 화면
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.loading.value
            }
        }

        setContent {
            SmartDeliveryCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartDeliveryCloneTheme {
        Greeting("Android")
    }
}