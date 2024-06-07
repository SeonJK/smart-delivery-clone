package com.seonjk.smartdeliveryclone.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
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
    object Landing : Destination(Route.LANDING) {
        // 이용약관
        object ServiceAgreement : Destination(
            route = Route.SERVICE_AGREEMENT,
            title = R.string.service_agreement
        )

        // 번호인증
        object PhoneAuthentication : Destination(
            route = Route.PHONE_AUTHENTICATION,
            title = R.string.phone_authentication
        )
    }

    // MAIN Group
    object Main : Destination(Route.MAIN) {
        // 대시보드
        object DashBoard : Destination(
            route = Route.DASHBOARD,
            title = R.string.nav_dashboard,
            icon = Icons.Outlined.Home,
        )

        // 배송목록
        object DeliveryList : Destination(
            route = Route.LIST_DELIVERY,
            title = R.string.nav_list_delivery,
            icon = Icons.Outlined.List,
        )

        // 다이어리
        object Diary : Destination(
            route = Route.DIARY,
            title = R.string.nav_diary,
            icon = Icons.Outlined.DateRange,
        )

        // 택배예약
        object Reservation : Destination(
            route = Route.RESERVATION,
            title = R.string.nav_reservation,
            icon = Icons.Outlined.Email,
        )

        // e머니
        object EMoney : Destination(
            route = Route.E_MONEY,
            title = R.string.nav_e_money,
            icon = Icons.Outlined.ShoppingCart,
        )
    }
}

sealed class Destination(
    val route: String,
    val title: Int? = null,
    val icon: ImageVector? = null,
    val navArgument: List<NamedNavArgument> = emptyList()
)