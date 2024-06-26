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
    appFinish: () -> Unit
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
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                navigateToLanding = {
                    navController.navigate(
                        route =
                        if (viewModel.agreedService.value && !viewModel.phoneAuthenticated.value) {
                            Screen.Landing.PhoneAuthentication.route
                        } else Screen.Landing.route
                    ) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                appFinish = appFinish
            )
        }
        landingNavGraph(navController)
        mainNavGraph(navController)
    }
}