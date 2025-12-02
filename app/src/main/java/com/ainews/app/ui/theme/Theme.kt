package com.ainews.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = HealthGreen,
    onPrimary = CardBackgroundLight,
    primaryContainer = HealthGreenDark,
    onPrimaryContainer = CardBackgroundLight,
    secondary = HealthBlue,
    onSecondary = CardBackgroundLight,
    secondaryContainer = HealthBlueDark,
    onSecondaryContainer = CardBackgroundLight,
    tertiary = HealthOrange,
    background = BackgroundDark,
    onBackground = TextPrimaryDark,
    surface = CardBackgroundDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = CardBackgroundDark,
    onSurfaceVariant = TextSecondaryDark,
    error = HealthRed,
    onError = CardBackgroundLight
)

private val LightColorScheme = lightColorScheme(
    primary = HealthGreen,
    onPrimary = CardBackgroundLight,
    primaryContainer = HealthGreenLight,
    onPrimaryContainer = HealthGreenDark,
    secondary = HealthBlue,
    onSecondary = CardBackgroundLight,
    secondaryContainer = HealthBlueLight,
    onSecondaryContainer = HealthBlueDark,
    tertiary = HealthOrange,
    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = CardBackgroundLight,
    onSurface = TextPrimary,
    surfaceVariant = BackgroundLight,
    onSurfaceVariant = TextSecondary,
    error = HealthRed,
    onError = CardBackgroundLight
)

@Composable
fun AIHealthNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
