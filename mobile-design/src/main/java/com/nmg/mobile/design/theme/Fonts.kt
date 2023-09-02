package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

@Immutable
data class TypographySystem(
    val fontFamily: FontFamily,
    val textStyle: TextStyle
)

val LocalTypographySystem = staticCompositionLocalOf {
    TypographySystem(
        fontFamily = FontFamily.Default,
        textStyle = TextStyle.Default
    )
}