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
fun ReservationIconUnselected(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "reservation_unselected",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(SmartDeliveryCloneTheme.colors.descriptionColor),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(770.667f, -126f)
                horizontalLineTo(189.333f)
                quadToRelative(-26.125f, 0f, -44.729f, -18.604f)
                reflectiveQuadTo(126f, -189.333f)
                verticalLineToRelative(-581.334f)
                quadToRelative(0f, -26.125f, 18.604f, -44.729f)
                reflectiveQuadTo(189.333f, -834f)
                horizontalLineToRelative(581.334f)
                quadToRelative(26.125f, 0f, 44.729f, 18.604f)
                reflectiveQuadTo(834f, -770.667f)
                verticalLineToRelative(581.334f)
                quadToRelative(0f, 26.125f, -18.604f, 44.729f)
                reflectiveQuadTo(770.667f, -126f)
                close()
                moveToRelative(-26.666f, -146f)
                horizontalLineTo(215.999f)
                verticalLineToRelative(72.001f)
                horizontalLineToRelative(528.002f)
                verticalLineTo(-272f)
                close()
                moveToRelative(-528.002f, -43.999f)
                horizontalLineToRelative(528.002f)
                verticalLineTo(-388f)
                horizontalLineTo(215.999f)
                verticalLineToRelative(72.001f)
                close()
                moveToRelative(0f, -126f)
                horizontalLineToRelative(528.002f)
                verticalLineToRelative(-302.002f)
                horizontalLineTo(215.999f)
                verticalLineToRelative(302.002f)
                close()
                moveToRelative(0f, 169.999f)
                verticalLineToRelative(72.001f)
                verticalLineTo(-272f)
                close()
                moveToRelative(0f, -43.999f)
                verticalLineTo(-388f)
                verticalLineToRelative(72.001f)
                close()
                moveToRelative(0f, -126f)
                verticalLineToRelative(-302.002f)
                verticalLineToRelative(302.002f)
                close()
                moveToRelative(0f, 53.999f)
                verticalLineToRelative(-53.999f)
                verticalLineTo(-388f)
                close()
                moveToRelative(0f, 116f)
                verticalLineToRelative(-43.999f)
                verticalLineTo(-272f)
                close()
            }
        }.build()
    }
}