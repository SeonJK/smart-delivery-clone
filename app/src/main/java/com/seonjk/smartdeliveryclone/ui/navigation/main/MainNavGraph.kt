package com.seonjk.smartdeliveryclone.ui.navigation.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.ui.main.DashBoardScreen
import com.seonjk.smartdeliveryclone.ui.main.DeliveryListScreen
import com.seonjk.smartdeliveryclone.ui.main.DiaryScreen
import com.seonjk.smartdeliveryclone.ui.main.EmoneyScreen
import com.seonjk.smartdeliveryclone.ui.main.ReservationScreen
import com.seonjk.smartdeliveryclone.ui.navigation.Screen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
) {
    navigation(
        route = Screen.Main.route,
        startDestination = Screen.Main.DashBoard.route
    ) {
        composable(route = Screen.Main.DashBoard.route) {
            DashBoardScreen(
                navigateToNoti = {},
                showAddItemDialog = {},
                navigateToSetting = {},
                navigateToDeliveryList = { navController.navigate(Screen.Main.DeliveryList.route) },
                navigateToDiary = { navController.navigate(Screen.Main.Diary.route) },
                navigateToEmoney = { navController.navigate(Screen.Main.EMoney.route) },
                navigateToReservation = { navController.navigate(Screen.Main.Reservation.route) }
            )
        }

        composable(route = Screen.Main.DeliveryList.route) {
            DeliveryListScreen(
                showReadAllDialog = {},
                showAddItemDialog = {},
                navigateToSearch = {}
            )
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