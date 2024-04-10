package com.seonjk.smartdeliveryclone.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationScreen
import com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication.PhoneAuthenticationViewModel
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementScreen
import com.seonjk.smartdeliveryclone.ui.landing.serviceagreement.ServiceAgreementViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.landingNavGraph(
    navController: NavController
) {
    navigation(
        route = Screen.Landing.route,
        startDestination = Screen.Landing.ServiceAgreement.route
    ) {
        composable(route = Screen.Landing.ServiceAgreement.route) {
            val viewModel = koinViewModel<ServiceAgreementViewModel>()
            ServiceAgreementScreen(
                viewModel = viewModel,
                navigateToPhoneAuthentication = {
                    navController.navigate(Screen.Landing.PhoneAuthentication.route)
                }
            )
        }
        composable(route = Screen.Landing.PhoneAuthentication.route) {
            val viewModel = koinViewModel<PhoneAuthenticationViewModel>()
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