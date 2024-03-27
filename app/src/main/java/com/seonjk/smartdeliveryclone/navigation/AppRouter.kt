package com.seonjk.smartdeliveryclone.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import com.seonjk.smartdeliveryclone.R

// AppRouter.kt

private object Route {
    const val SPLASH = "splash"

    // LANDING Group
    const val LANDING = "landing"
    const val SERVICE_AGREEMENT = "service_agreement"
    const val PHONE_AUTHENTICATION = "phone_authentication"

    // MAIN Group
    const val MAIN = "main"
    const val DASHBOARD = "dashboard"
    const val LIST_DELIVERY = "list"
    const val DIARY = "diary"
    const val RESERVATION = "reservation"
    const val E_MONEY = "e-money"
}

sealed class Screen(val route: String) {
    object Splash : Screen(Route.SPLASH)

    // LANDING Group
    object Landing : Screen(Route.LANDING) {
        // 이용약관
        object ServiceAgreement : Screen(Route.SERVICE_AGREEMENT)

        // 번호인증
        object PhoneAuthentication : Screen(Route.PHONE_AUTHENTICATION)
    }

    // MAIN Group
    object Main : MainGroupDestination(Route.MAIN) {
        // 대시보드
        object DashBoard : MainGroupDestination(
            route = Route.DASHBOARD,
            title = R.string.nav_dashboard,
            icon = Icons.Outlined.Home,
        )

        // 배송목록
        object DeliveryList : MainGroupDestination(
            route = Route.LIST_DELIVERY,
            title = R.string.nav_list_delivery,
            icon = Icons.Outlined.List,
        )

        // 다이어리
        object Diary : MainGroupDestination(
            route = Route.DIARY,
            title = R.string.nav_diary,
            icon = Icons.Outlined.DateRange,
        )

        // 택배예약
        object Reservation : MainGroupDestination(
            route = Route.RESERVATION,
            title = R.string.nav_reservation,
            icon = Icons.Outlined.Email,
        )

        // e머니
        object EMoney : MainGroupDestination(
            route = Route.E_MONEY,
            title = R.string.nav_e_money,
            icon = Icons.Outlined.ShoppingCart,
        )
    }
}

sealed class MainGroupDestination(
    val route: String,
    val title: Int? = null,
    val icon: ImageVector? = null,
    val navArgument: List<NamedNavArgument> = emptyList()
)