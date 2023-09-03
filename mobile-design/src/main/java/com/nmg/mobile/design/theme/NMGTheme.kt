package com.nmg.mobile.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun NMGTheme(
    colors: ThemeableColors = defaultThemeColors,
    typography: ThemeableTypography = defaultTypography,
    customSystem: CustomSystem = CustomSystem(
        value1 = 1000,
        value2 = "Custom system"
    ),
    content: @Composable () -> Unit
) {

    /* ... */
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalCustomSystem provides customSystem,
        /* ... */
        content = content
    )
}


object NMGTheme {
    val colors: ThemeableColors
        @Composable
        get() = LocalColors.current
    val typography: ThemeableTypography
        @Composable
        get() = LocalTypography.current
    val customSystem: CustomSystem
        @Composable
        get() = LocalCustomSystem.current
    /* ... */
}

