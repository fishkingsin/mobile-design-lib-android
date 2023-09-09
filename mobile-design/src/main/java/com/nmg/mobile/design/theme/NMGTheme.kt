package com.nmg.mobile.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

@Composable
public fun NMGTheme(
    colors: ThemeableColors = NMGDefaultColors(LocalContext.current),
    typography: ThemeableTypography = defaultTypography,
    customSystem: CustomSystem = CustomSystem(
        value1 = 1000,
        value2 = "Custom system",
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


public object NMGTheme {
    public val colors: ThemeableColors
        @Composable
        get() = LocalColors.current
    public val typography: ThemeableTypography
        @Composable
        get() = LocalTypography.current
    public val customSystem: CustomSystem
        @Composable
        get() = LocalCustomSystem.current
    /* ... */
}

