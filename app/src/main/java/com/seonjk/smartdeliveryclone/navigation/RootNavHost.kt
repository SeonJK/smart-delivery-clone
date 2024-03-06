package com.seonjk.smartdeliveryclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seonjk.smartdeliveryclone.HomeScreen
import com.seonjk.smartdeliveryclone.ui.landing.ServiceAgreementScreen
import com.seonjk.smartdeliveryclone.ui.main.DashBoardScreen

// RootNavHost.kt

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Landing.route) {
            ServiceAgreementScreen()
        }
        composable(Screen.Main.route) {
            DashBoardScreen()
        }
    }
}