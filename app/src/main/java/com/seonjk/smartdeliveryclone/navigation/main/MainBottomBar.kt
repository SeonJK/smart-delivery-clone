package com.seonjk.smartdeliveryclone.navigation.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.seonjk.smartdeliveryclone.navigation.Screen
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun MainBottomBar(
    navController: NavController
) {
    val navigationScreen = listOf(
        Screen.Main.DashBoard,
        Screen.Main.DeliveryList,
        Screen.Main.Diary,
        Screen.Main.Reservation,
        Screen.Main.EMoney
    )

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationScreen.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                icon = {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = "",
                        tint = if (currentRoute == screen.route) SmartDeliveryCloneTheme.colors.primary
                        else SmartDeliveryCloneTheme.colors.descriptionColor
                    )
                },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}