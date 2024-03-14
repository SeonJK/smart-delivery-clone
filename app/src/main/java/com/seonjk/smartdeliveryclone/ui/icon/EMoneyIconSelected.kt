package com.seonjk.smartdeliveryclone.ui.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun EMoneyIconSelected(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "e_money_selected",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(SmartDeliveryCloneTheme.colors.primary),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(70.666f, -480f)
                quadToRelative(0f, 73.167f, 37.834f, 133.334f)
                quadToRelative(37.833f, 60.166f, 99.167f, 91f)
                quadTo(218.666f, -250f, 223.416f, -238.5f)
                reflectiveQuadToRelative(-0.083f, 23.167f)
                quadToRelative(-4.833f, 12f, -16.583f, 17.25f)
                quadToRelative(-11.75f, 5.25f, -22.917f, -0.417f)
                quadToRelative(-82.666f, -40.333f, -129.583f, -116.417f)
                quadTo(7.333f, -391f, 7.333f, -480f)
                quadToRelative(0f, -88f, 45.834f, -163.667f)
                quadTo(99f, -719.333f, 179.832f, -760f)
                quadToRelative(12.167f, -6f, 24.417f, -1.583f)
                quadToRelative(12.25f, 4.416f, 17.75f, 16.749f)
                quadToRelative(5f, 11.834f, -0.334f, 23.5f)
                quadToRelative(-5.333f, 11.667f, -16.833f, 17.834f)
                quadToRelative(-61f, 31.166f, -97.583f, 91.166f)
                quadTo(70.666f, -552.333f, 70.666f, -480f)
                close()
                moveToRelative(488.667f, 314f)
                quadTo(430f, -166f, 337.667f, -258.333f)
                quadTo(245.333f, -350.667f, 245.333f, -480f)
                reflectiveQuadToRelative(92.334f, -221.667f)
                quadTo(430f, -794f, 559.333f, -794f)
                quadToRelative(46.667f, 0f, 93.417f, 14.333f)
                quadToRelative(46.75f, 14.334f, 86.917f, 43.167f)
                quadToRelative(10.333f, 8f, 10.999f, 20.916f)
                quadToRelative(0.667f, 12.917f, -8.166f, 21.75f)
                quadToRelative(-9f, 9.667f, -22f, 10.25f)
                quadToRelative(-13f, 0.584f, -24.5f, -6.75f)
                quadToRelative(-30.667f, -20f, -66.25f, -30.166f)
                quadToRelative(-35.583f, -10.167f, -70.417f, -10.167f)
                quadToRelative(-103.833f, 0f, -177.25f, 73.417f)
                reflectiveQuadTo(308.666f, -480f)
                quadToRelative(0f, 103.833f, 73.417f, 177.25f)
                reflectiveQuadToRelative(177.25f, 73.417f)
                quadToRelative(34.834f, 0f, 70.417f, -10.167f)
                quadTo(665.333f, -249.666f, 696f, -269f)
                quadToRelative(11.5f, -7.333f, 24.5f, -6.416f)
                quadToRelative(13f, 0.917f, 22f, 9.583f)
                quadToRelative(8.833f, 9.167f, 8.166f, 21.917f)
                quadToRelative(-0.666f, 12.75f, -10.999f, 20.083f)
                quadToRelative(-40.167f, 29.167f, -86.917f, 43.5f)
                quadTo(606f, -166f, 559.333f, -166f)
                close()
                moveToRelative(273.334f, -286f)
                horizontalLineTo(551.333f)
                quadToRelative(-12.166f, 0f, -20.75f, -8.584f)
                quadTo(522f, -469.167f, 522f, -481.333f)
                quadToRelative(0f, -12.167f, 8.583f, -20.75f)
                quadToRelative(8.584f, -8.583f, 20.75f, -8.583f)
                horizontalLineToRelative(281.334f)
                lineToRelative(-54.833f, -55.168f)
                quadToRelative(-9.667f, -9.333f, -9.667f, -22.166f)
                reflectiveQuadToRelative(9.667f, -22.5f)
                quadToRelative(9.333f, -9.333f, 22.499f, -9.333f)
                quadToRelative(13.167f, 0f, 22.834f, 9.333f)
                lineTo(930.5f, -503.833f)
                quadToRelative(9.5f, 9.833f, 9.5f, 22.5f)
                quadToRelative(0f, 12.666f, -9.5f, 22.166f)
                lineTo(823.167f, -351.833f)
                quadToRelative(-9.667f, 9.666f, -22.5f, 9.333f)
                quadToRelative(-12.833f, -0.333f, -22.167f, -10f)
                quadToRelative(-9.666f, -9.333f, -9.666f, -22.5f)
                reflectiveQuadToRelative(9.666f, -22.833f)
                lineTo(832.667f, -452f)
                close()
            }
        }.build()
    }
}