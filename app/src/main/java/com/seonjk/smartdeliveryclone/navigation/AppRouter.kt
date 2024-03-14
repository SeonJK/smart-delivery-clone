package com.seonjk.smartdeliveryclone.navigation

// AppRouter.kt

private object Route {
    const val SPLASH = "splash"

    // LANDING Group
    const val LANDING = "landing"
    const val SERVICE_AGREEMENT = "service_agreement"
    const val PHONE_AUTHENTICATION = "phone_authentication"

    const val MAIN = "main"
}

sealed class Screen(val route: String) {
    object Main: Screen(Route.MAIN)
}    // LANDING Group
    object Splash: Screen(Route.SPLASH)
    // LANDING Group
    object Landing: Screen(Route.LANDING) {
        // 이용약관
        object ServiceAgreement: Screen(Route.SERVICE_AGREEMENT)
        // 번호인증
        object PhoneAuthentication: Screen(Route.PHONE_AUTHENTICATION)
    }
    // MAIN Group
