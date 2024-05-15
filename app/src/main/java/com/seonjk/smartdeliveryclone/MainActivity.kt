package com.seonjk.smartdeliveryclone

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seonjk.smartdeliveryclone.ui.navigation.RootNavHost
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

internal fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("no Activity")
}

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            SmartDeliveryCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SmartDeliveryCloneTheme.colors.background
                ) {
                    navController = rememberNavController()
                    RootNavHost(
                        navController = navController,
                        goAlarmSetting = {
                            Intent(
                                Settings.ACTION_APP_NOTIFICATION_SETTINGS,
                                Uri.parse("package:$packageName")
                            ).apply {
                                addCategory(Intent.CATEGORY_DEFAULT)
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(this)
                            }
                        }
                    )
                }
            }
        }
    }
}