package com.seonjk.smartdeliveryclone.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seonjk.smartdeliveryclone.ui.splash.SplashScreen
import com.seonjk.smartdeliveryclone.navigation.main.mainNavGraph
import com.seonjk.smartdeliveryclone.ui.splash.SplashViewModel

// RootNavHost.kt

@Composable
fun RootNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
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
                }
            )
        }
        landingNavGraph(navController)
        mainNavGraph(navController)
    }
}