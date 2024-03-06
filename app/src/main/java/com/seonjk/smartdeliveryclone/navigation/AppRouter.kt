package com.seonjk.smartdeliveryclone.navigation

// AppRouter.kt

private object Route {
    const val HOME = "home"
    const val LANDING = "landing"
    const val MAIN = "main"
}

sealed class Screen(val route: String) {
    object Home: Screen(Route.HOME)
    object Landing: Screen(Route.LANDING)
    object Main: Screen(Route.MAIN)
}