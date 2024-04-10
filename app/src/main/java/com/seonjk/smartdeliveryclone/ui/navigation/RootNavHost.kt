package com.seonjk.smartdeliveryclone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seonjk.smartdeliveryclone.ui.navigation.main.mainNavGraph
import com.seonjk.smartdeliveryclone.ui.splash.SplashScreen
import com.seonjk.smartdeliveryclone.ui.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

// RootNavHost.kt

@Composable
fun RootNavHost(
    navController: NavHostController,
    goAlarmSetting: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            val viewModel = koinViewModel<SplashViewModel>()
            SplashScreen(
                viewModel = viewModel,
                navigateToMain = {
                    navController.navigate(route = Screen.Main.route) {
                        popUpTo(Screen.Splash.route) { inclusive = false }
                    }
                },
                navigateToLanding = {
                    navController.navigate(route = Screen.Landing.route) {
                        popUpTo(Screen.Splash.route) { inclusive = false }
                    }
                },
                goAlarmSetting = goAlarmSetting
            )
        }
        landingNavGraph(navController)
        mainNavGraph(navController)
    }
}