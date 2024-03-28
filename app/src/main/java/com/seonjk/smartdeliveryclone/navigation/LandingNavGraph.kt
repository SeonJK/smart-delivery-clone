package com.seonjk.smartdeliveryclone.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationScreen
import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationViewModel
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementScreen
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementViewModel

fun NavGraphBuilder.landingNavGraph(
    navController: NavController
) {
    navigation (
        route = Screen.Landing.route,
        startDestination = Screen.Landing.ServiceAgreement.route
    ) {
        composable(route = Screen.Landing.ServiceAgreement.route) {
            val viewModel = hiltViewModel<ServiceAgreementViewModel>()
            ServiceAgreementScreen(
                viewModel = viewModel,
                navigateToPhoneAuthentication = {
                    navController.navigate(Screen.Landing.PhoneAuthentication.route)
                }
            )
        }
        composable(route = Screen.Landing.PhoneAuthentication.route) {
            val viewModel = hiltViewModel<PhoneAuthenticationViewModel>()
            PhoneAuthenticationScreen(
                viewModel = viewModel,
                navigateToMain = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Landing.route) { inclusive = true }
                    }
                }
            )
        }
    }
}