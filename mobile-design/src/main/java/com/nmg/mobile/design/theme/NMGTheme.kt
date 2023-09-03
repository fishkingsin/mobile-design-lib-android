package com.nmg.mobile.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun NMGTheme(
    colors: ThemeableColors = defaultThemeColors,
    textStyles: ThemeableTextStyles = defaultTextStyles,
    customSystem: CustomSystem = CustomSystem(
        value1 = 1000,
        value2 = "Custom system"
    ),
    content: @Composable () -> Unit
) {

    /* ... */
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTextStyles provides textStyles,
        LocalCustomSystem provides customSystem,
        /* ... */
        content = content
    )
}


object NMGTheme {
    val colors: ThemeableColors
        @Composable
        get() = LocalColors.current
    val textStyles: ThemeableTextStyles
        @Composable
        get() = LocalTextStyles.current
    val customSystem: CustomSystem
        @Composable
        get() = LocalCustomSystem.current
    /* ... */
}

