package com.seonjk.smartdeliveryclone

import android.os.Bundle
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
                        appFinish = { finish() }
                    )
                }
            }
        }
    }


}