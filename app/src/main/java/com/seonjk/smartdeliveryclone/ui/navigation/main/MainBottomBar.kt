package com.seonjk.smartdeliveryclone.ui.navigation.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.seonjk.smartdeliveryclone.ui.navigation.Screen
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

    NavigationBar(
        containerColor = SmartDeliveryCloneTheme.colors.onBackground,
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationScreen.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SmartDeliveryCloneTheme.colors.primary,
                    selectedTextColor = SmartDeliveryCloneTheme.colors.primary,
                    unselectedIconColor = SmartDeliveryCloneTheme.colors.descriptionColor,
                    unselectedTextColor = SmartDeliveryCloneTheme.colors.descriptionColor,
                    indicatorColor = SmartDeliveryCloneTheme.colors.onBackground
                ),
                label = {
                    Text(
                        text = stringResource(screen.title!!),
//                        color = if (currentRoute == screen.route) SmartDeliveryCloneTheme.colors.primary
//                                else SmartDeliveryCloneTheme.colors.descriptionColor
                    )
                },
                icon = {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = "",
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