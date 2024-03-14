package com.seonjk.smartdeliveryclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

// RootNavHost.kt

@Composable
fun RootNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        landingNavGraph(navController)
        mainNavGraph(navController)
    }
}