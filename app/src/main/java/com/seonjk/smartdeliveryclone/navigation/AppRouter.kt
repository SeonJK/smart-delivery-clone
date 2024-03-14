package com.seonjk.smartdeliveryclone.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.icon.DeliveryListIconSelected
import com.seonjk.smartdeliveryclone.ui.icon.DeliveryListIconUnselected
import com.seonjk.smartdeliveryclone.ui.icon.DiaryIconSelected
import com.seonjk.smartdeliveryclone.ui.icon.DiaryIconUnselected
import com.seonjk.smartdeliveryclone.ui.icon.EMoneyIconSelected
import com.seonjk.smartdeliveryclone.ui.icon.EMoneyIconUnselected
import com.seonjk.smartdeliveryclone.ui.icon.HomeIconSelected
import com.seonjk.smartdeliveryclone.ui.icon.HomeIconUnselected
import com.seonjk.smartdeliveryclone.ui.icon.ReservationIconSelected
import com.seonjk.smartdeliveryclone.ui.icon.ReservationIconUnselected

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
    object Splash: Screen(Route.SPLASH)
    // LANDING Group
    object Landing: Screen(Route.LANDING) {
        // 이용약관
        object ServiceAgreement: Screen(Route.SERVICE_AGREEMENT)
        // 번호인증
        object PhoneAuthentication: Screen(Route.PHONE_AUTHENTICATION)
    }
    // MAIN Group
    object Main: MainGroupDestination(Route.MAIN) {
        // 대시보드
        object DashBoard: MainGroupDestination(
            route = Route.DASHBOARD,
            title = R.string.nav_dashboard,
            selectedIcon = HomeIconSelected(),
            unSelectedIcon = HomeIconUnselected()
        )
        // 배송목록
        object DeliveryList: MainGroupDestination(
            route = Route.LIST_DELIVERY,
            title = R.string.nav_list_delivery,
            selectedIcon = DeliveryListIconSelected(),
            unSelectedIcon = DeliveryListIconUnselected(),
        )
        // 다이어리
        object Diary: MainGroupDestination(
            route = Route.DIARY,
            title = R.string.nav_diary,
            selectedIcon = DiaryIconSelected(),
            unSelectedIcon = DiaryIconUnselected(),
        )
        // 택배예약
        object Reservation: MainGroupDestination(
            route = Route.RESERVATION,
            title = R.string.nav_reservation,
            selectedIcon = ReservationIconSelected(),
            unSelectedIcon = ReservationIconUnselected(),
        )
        // e머니
        object EMoney: MainGroupDestination(
            route = Route.E_MONEY,
            title = R.string.nav_e_money,
            selectedIcon = EMoneyIconSelected(),
            unSelectedIcon = EMoneyIconUnselected(),
        )
    }
}

sealed class MainGroupDestination(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unSelectedIcon: ImageVector? = null,
    val navArgument: List<NamedNavArgument> = emptyList()
)