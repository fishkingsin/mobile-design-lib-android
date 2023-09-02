package com.nmg.mobile.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun NMGTheme(
    colors: Colors = defaultThemeColors,
    textStyles: TextStyles = defaultTextStyles,
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
    val colors: Colors
        @Composable
        get() = LocalColors.current
    val textStyles: TextStyles
        @Composable
        get() = LocalTextStyles.current
    val customSystem: CustomSystem
        @Composable
        get() = LocalCustomSystem.current
    /* ... */
}

