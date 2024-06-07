package com.seonjk.smartdeliveryclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.navigation.RootNavHost
import com.seonjk.smartdeliveryclone.ui.navigation.Screen
import com.seonjk.smartdeliveryclone.ui.navigation.main.MainBottomBar
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            SmartDeliveryCloneTheme {
                navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val topBarState = rememberSaveable{ mutableStateOf(true) }
                val bottomBarState = rememberSaveable{ mutableStateOf(true) }
                val resId = rememberSaveable{ mutableIntStateOf(-1) }
                when (navBackStackEntry?.destination?.route) {
                    Screen.Main.DashBoard.route -> {
                        topBarState.value = true
                        bottomBarState.value = true
                        resId.intValue = Screen.Main.DashBoard.title!!
                    }
                    Screen.Main.DeliveryList.route -> {
                        topBarState.value = true
                        bottomBarState.value = true
                        resId.intValue = Screen.Main.DeliveryList.title!!
                    }
                    Screen.Main.Diary.route -> {
                        topBarState.value = true
                        bottomBarState.value = true
                        resId.intValue = Screen.Main.Diary.title!!
                    }
                    Screen.Main.Reservation.route -> {
                        topBarState.value = true
                        bottomBarState.value = true
                        resId.intValue = Screen.Main.Reservation.title!!
                    }
                    Screen.Main.EMoney.route -> {
                        topBarState.value = true
                        bottomBarState.value = true
                        resId.intValue = Screen.Main.EMoney.title!!
                    }
                    Screen.Landing.ServiceAgreement.route -> {
                        topBarState.value = true
                        bottomBarState.value = false
                        resId.intValue = Screen.Landing.ServiceAgreement.title!!
                    }
                    Screen.Landing.PhoneAuthentication.route -> {
                        topBarState.value = true
                        bottomBarState.value = false
                        resId.intValue = Screen.Landing.PhoneAuthentication.title!!
                    }
                    else -> {
                        topBarState.value = false
                        bottomBarState.value = false
                    }
                }
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    containerColor = SmartDeliveryCloneTheme.colors.background,
                    topBar = { if (topBarState.value) Header(stringResource(resId.intValue)) },
                    bottomBar = { if (bottomBarState.value) MainBottomBar(navController) }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        RootNavHost(
                            navController = navController,
                            appFinish = { finish() }
                        )
                    }
                }
            }
        }
    }


}