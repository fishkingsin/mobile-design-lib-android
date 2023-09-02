package com.nmg.mobile.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

val defaultTheme = Colors(
    tabBackground = Color(0xFFF2F2F2),
    tabSelectedBackground = Color(0xFF1A1A1A),
    commonNeutralGray90 = Color(0xFF1A1A1A),
    commonNeutralGray80 = Color(0xFF333333),
    commonNeutralGray70 = Color(0xFF4D4D4D),
    commonNeutralGray60 = Color(0xFF666666),
    commonNeutralGray50 = Color(0xFF808080),
    commonNeutralGray40 = Color(0xFF999999),
    commonNeutralGray30 = Color(0xFFB3B3B3),
    commonNeutralGray20 = Color(0xFFCCCCCC),
    commonNeutralGray10 = Color(0xFFE5E5E5),
    commonNeutralGray5 = Color(0xFFF2F2F2),
    commonNeutralGray2 = Color(0xFFFAFAFA),
    primaryMain = Color(0xFFF29600),
    /* ... */
)

@Composable
fun NMGTheme(
    colors: Colors = defaultTheme,
    typographySystem: TypographySystem = TypographySystem(
        fontFamily = FontFamily.Default,
        textStyle = TextStyle(fontSize = 18.sp)
    ),
    customSystem: CustomSystem = CustomSystem(
        value1 = 1000,
        value2 = "Custom system"
    ),
    content: @Composable () -> Unit
) {

    /* ... */
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypographySystem provides typographySystem,
        LocalCustomSystem provides customSystem,
        /* ... */
        content = content
    )
}


object NMGTheme {
    val colors: Colors
        @Composable
        get() = LocalColors.current
    val typographySystem: TypographySystem
        @Composable
        get() = LocalTypographySystem.current
    val customSystem: CustomSystem
        @Composable
        get() = LocalCustomSystem.current
    /* ... */
}

