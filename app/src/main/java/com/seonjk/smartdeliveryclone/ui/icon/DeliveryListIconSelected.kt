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
fun DeliveryListIconSelected(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "list_delivery_selcted",
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
                moveTo(11.667f, 34.792f)
                quadToRelative(-2.042f, 0f, -3.479f, -1.438f)
                quadToRelative(-1.438f, -1.437f, -1.438f, -3.521f)
                horizontalLineTo(4.375f)
                quadToRelative(-1.083f, 0f, -1.854f, -0.771f)
                quadToRelative(-0.771f, -0.77f, -0.771f, -1.854f)
                verticalLineToRelative(-6.166f)
                quadToRelative(0f, -1.084f, 0.771f, -1.875f)
                quadToRelative(0.771f, -0.792f, 1.854f, -0.792f)
                horizontalLineToRelative(15.708f)
                verticalLineToRelative(-7.167f)
                quadToRelative(0f, -1.083f, 0.771f, -1.854f)
                quadToRelative(0.771f, -0.771f, 1.854f, -0.771f)
                horizontalLineToRelative(4.334f)
                verticalLineTo(6.708f)
                quadToRelative(0f, -0.541f, 0.375f, -0.937f)
                reflectiveQuadToRelative(0.916f, -0.396f)
                horizontalLineTo(30f)
                quadToRelative(0.542f, 0f, 0.938f, 0.396f)
                quadToRelative(0.395f, 0.396f, 0.395f, 0.937f)
                verticalLineToRelative(1.875f)
                horizontalLineToRelative(1.709f)
                quadToRelative(0.875f, 0f, 1.562f, 0.5f)
                quadToRelative(0.688f, 0.5f, 0.979f, 1.292f)
                lineToRelative(2.542f, 7.708f)
                quadToRelative(0.083f, 0.209f, 0.125f, 0.417f)
                quadToRelative(0.042f, 0.208f, 0.042f, 0.417f)
                verticalLineToRelative(8.291f)
                quadToRelative(0f, 1.084f, -0.792f, 1.854f)
                quadToRelative(-0.792f, 0.771f, -1.875f, 0.771f)
                horizontalLineToRelative(-2.333f)
                quadToRelative(0f, 2.084f, -1.459f, 3.521f)
                quadToRelative(-1.458f, 1.438f, -3.5f, 1.438f)
                quadToRelative(-2.041f, 0f, -3.479f, -1.438f)
                quadToRelative(-1.437f, -1.437f, -1.437f, -3.521f)
                horizontalLineToRelative(-6.792f)
                quadToRelative(0f, 2.084f, -1.458f, 3.521f)
                quadToRelative(-1.459f, 1.438f, -3.5f, 1.438f)
                close()
                moveToRelative(0f, -2.667f)
                quadToRelative(0.958f, 0f, 1.625f, -0.646f)
                quadToRelative(0.666f, -0.646f, 0.666f, -1.646f)
                quadToRelative(0f, -0.958f, -0.666f, -1.625f)
                quadToRelative(-0.667f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-0.959f, 0f, -1.625f, 0.666f)
                quadToRelative(-0.667f, 0.667f, -0.667f, 1.625f)
                quadToRelative(0f, 1f, 0.667f, 1.646f)
                quadToRelative(0.666f, 0.646f, 1.625f, 0.646f)
                close()
                moveToRelative(16.666f, 0f)
                quadToRelative(0.959f, 0f, 1.625f, -0.646f)
                quadToRelative(0.667f, -0.646f, 0.667f, -1.646f)
                quadToRelative(0f, -0.958f, -0.667f, -1.625f)
                quadToRelative(-0.666f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-0.958f, 0f, -1.625f, 0.666f)
                quadToRelative(-0.666f, 0.667f, -0.666f, 1.625f)
                quadToRelative(0f, 1f, 0.666f, 1.646f)
                quadToRelative(0.667f, 0.646f, 1.625f, 0.646f)
                close()
                moveToRelative(-8.25f, -4.917f)
                verticalLineToRelative(-6.166f)
                horizontalLineTo(4.375f)
                verticalLineToRelative(6.166f)
                horizontalLineTo(7.5f)
                quadToRelative(0.667f, -1.041f, 1.771f, -1.666f)
                quadToRelative(1.104f, -0.625f, 2.396f, -0.625f)
                quadToRelative(1.291f, 0f, 2.395f, 0.625f)
                quadToRelative(1.105f, 0.625f, 1.771f, 1.666f)
                close()
                moveToRelative(2.625f, 0f)
                horizontalLineToRelative(1.459f)
                quadToRelative(0.666f, -1.041f, 1.771f, -1.666f)
                quadToRelative(1.104f, -0.625f, 2.395f, -0.625f)
                quadToRelative(1.292f, 0f, 2.396f, 0.625f)
                quadToRelative(1.104f, 0.625f, 1.771f, 1.666f)
                horizontalLineToRelative(3.125f)
                verticalLineToRelative(-6.166f)
                horizontalLineTo(22.708f)
                close()
                moveToRelative(0f, -8.833f)
                horizontalLineToRelative(12.75f)
                lineToRelative(-2.416f, -7.167f)
                horizontalLineTo(22.708f)
                close()
                moveTo(2.625f, 16.583f)
                quadToRelative(-0.375f, 0f, -0.625f, -0.271f)
                quadToRelative(-0.25f, -0.27f, -0.25f, -0.604f)
                quadToRelative(0f, -0.375f, 0.25f, -0.645f)
                quadToRelative(0.25f, -0.271f, 0.625f, -0.271f)
                horizontalLineToRelative(0.792f)
                verticalLineToRelative(-4.417f)
                horizontalLineToRelative(-0.792f)
                quadToRelative(-0.375f, 0f, -0.625f, -0.25f)
                reflectiveQuadTo(1.75f, 9.5f)
                quadToRelative(0f, -0.417f, 0.25f, -0.667f)
                quadToRelative(0.25f, -0.25f, 0.625f, -0.25f)
                horizontalLineToRelative(14.75f)
                quadToRelative(0.375f, 0f, 0.646f, 0.271f)
                reflectiveQuadToRelative(0.271f, 0.646f)
                quadToRelative(0f, 0.375f, -0.271f, 0.625f)
                reflectiveQuadToRelative(-0.646f, 0.25f)
                horizontalLineToRelative(-0.75f)
                verticalLineToRelative(4.417f)
                horizontalLineToRelative(0.75f)
                quadToRelative(0.375f, 0f, 0.646f, 0.271f)
                quadToRelative(0.271f, 0.27f, 0.271f, 0.645f)
                reflectiveQuadToRelative(-0.271f, 0.625f)
                quadToRelative(-0.271f, 0.25f, -0.646f, 0.25f)
                close()
                moveToRelative(2.583f, -1.791f)
                horizontalLineToRelative(3.917f)
                verticalLineToRelative(-4.417f)
                horizontalLineTo(5.208f)
                close()
                moveToRelative(5.709f, 0f)
                horizontalLineToRelative(3.875f)
                verticalLineToRelative(-4.417f)
                horizontalLineToRelative(-3.875f)
                close()
                moveToRelative(9.166f, 6.25f)
                horizontalLineTo(4.375f)
                close()
                moveToRelative(2.625f, 0f)
                horizontalLineToRelative(12.917f)
                horizontalLineTo(22.708f)
                close()
            }
        }.build()
    }
}
