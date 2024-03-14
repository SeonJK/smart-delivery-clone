package com.seonjk.smartdeliveryclone.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.ui.landing.PhoneAuthenticationScreen
import com.seonjk.smartdeliveryclone.ui.landing.ServiceAgreementScreen

fun NavGraphBuilder.landingNavGraph(
    navController: NavController
) {
    navigation (
        route = Screen.Landing.route,
        startDestination = Screen.Landing.ServiceAgreement.route
    ) {
        composable(route = Screen.Landing.ServiceAgreement.route) {
            ServiceAgreementScreen(navigateToPhoneAuthentication = {
                    navController.navigate(Screen.Landing.PhoneAuthentication.route)
                }
            )
        }
        composable(route = Screen.Landing.PhoneAuthentication.route) {
            PhoneAuthenticationScreen(navigateToMain = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Landing.route) { inclusive = true }
                    }
                }
            )
        }
    }
}