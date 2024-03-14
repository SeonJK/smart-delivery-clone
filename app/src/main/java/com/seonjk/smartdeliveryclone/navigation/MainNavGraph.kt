package com.seonjk.smartdeliveryclone.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.ui.main.DashBoardScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
) {
    navigation(
        route = Screen.Main.route,
        startDestination = Screen.Main.DashBoard.route
    ) {
        composable(route = Screen.Main.DashBoard.route) {
            DashBoardScreen(navController)
        }
    }
}