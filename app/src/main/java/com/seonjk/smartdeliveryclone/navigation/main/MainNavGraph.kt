package com.seonjk.smartdeliveryclone.navigation.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.navigation.Screen
import com.seonjk.smartdeliveryclone.ui.main.DashBoardScreen
import com.seonjk.smartdeliveryclone.ui.main.DeliveryListScreen
import com.seonjk.smartdeliveryclone.ui.main.DiaryScreen
import com.seonjk.smartdeliveryclone.ui.main.EmoneyScreen
import com.seonjk.smartdeliveryclone.ui.main.ReservationScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
) {
    navigation(
        route = Screen.Main.route,
        startDestination = Screen.Main.DashBoard.route
    ) {
        composable(route = Screen.Main.DashBoard.route) {
            DashBoardScreen()
        }

        composable(route = Screen.Main.DeliveryList.route) {
            DeliveryListScreen()
        }

        composable(route = Screen.Main.Diary.route) {
            DiaryScreen()
        }

        composable(route = Screen.Main.Reservation.route) {
            ReservationScreen()
        }

        composable(route = Screen.Main.EMoney.route) {
            EmoneyScreen()
        }

    }
}