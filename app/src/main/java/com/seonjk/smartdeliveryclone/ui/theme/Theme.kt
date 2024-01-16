package com.seonjk.smartdeliveryclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = SmartDeliveryColors(
    isDark = true,
    primary = Orange,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = BackgroundBlack,
    onBackground = OnBackgroundGrey,
    titleColor = Color.White,
    descriptionColor = Color.LightGray
)

private val LightColorScheme = SmartDeliveryColors(
    isDark = false,
    primary = Orange,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.White,
    onBackground = OnBackgroundWhite,
    titleColor = Color.Black,
    descriptionColor = Color.DarkGray

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun SmartDeliveryCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    ProvideSmartDeliveryColors(colorScheme) {
        MaterialTheme(
            colorScheme = debugColors(darkTheme),
            typography = Typography,
            content = content
        )
    }
}

object SmartDeliveryCloneTheme {
    val colors: SmartDeliveryColors
        @Composable
        get() = LocalSmartDeliveryColors.current
}

@Stable
class SmartDeliveryColors(
    isDark: Boolean,
    primary: Color,
    secondary: Color,
    tertiary: Color,
    onBackground: Color,
    background: Color = Color(0xFFFFFBFE),
    surface: Color = Color(0xFFFFFBFE),
    onPrimary: Color = Color.White,
    onSecondary: Color = Color.White,
    onTertiary: Color = Color.White,
    onSurface: Color = Color(0xFF1C1B1F),
    titleColor: Color,
    descriptionColor: Color,
) {
    var isDark by mutableStateOf(isDark)
        private set
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var tertiary by mutableStateOf(tertiary)
        private set
    var onTertiary by mutableStateOf(onTertiary)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var titleColor by mutableStateOf(titleColor)
        private set
    var descriptionColor by mutableStateOf(descriptionColor)
        private set

    fun update(other: SmartDeliveryColors) {
        isDark = other.isDark
        primary = other.primary
        onPrimary = other.onPrimary
        secondary = other.secondary
        onSecondary = other.onSecondary
        tertiary = other.tertiary
        onTertiary = other.onTertiary
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
        titleColor = other.titleColor
        descriptionColor = other.descriptionColor
    }

    fun copy(): SmartDeliveryColors = SmartDeliveryColors(
        isDark = isDark,
        primary = primary,
        onPrimary = onPrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        tertiary = tertiary,
        onTertiary = onTertiary,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        titleColor = titleColor,
        descriptionColor = descriptionColor
    )
}

@Composable
fun ProvideSmartDeliveryColors(
    colors: SmartDeliveryColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalSmartDeliveryColors provides colorPalette, content = content)
}

private val LocalSmartDeliveryColors = staticCompositionLocalOf<SmartDeliveryColors> {
    error("No SmartDeliveryPalette provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = ColorScheme(
    primary = debugColor,
    secondary = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    tertiaryContainer = debugColor,
    tertiary = debugColor,
    surfaceVariant = debugColor,
    surfaceTint = debugColor,
    secondaryContainer = debugColor,
    scrim = debugColor,
    primaryContainer = debugColor,
    outlineVariant = debugColor,
    outline = debugColor,
    onTertiaryContainer = debugColor,
    onSurfaceVariant = debugColor,
    onSecondaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    onErrorContainer = debugColor,
    inverseSurface = debugColor,
    inversePrimary = debugColor,
    inverseOnSurface = debugColor,
    onTertiary = debugColor
)
