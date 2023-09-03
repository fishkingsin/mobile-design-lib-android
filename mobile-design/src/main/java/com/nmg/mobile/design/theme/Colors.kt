package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
public data class Colors(
    override var commonNeutralGray90: Color,
    override var commonNeutralGray80: Color,
    override var commonNeutralGray70: Color,
    override var commonNeutralGray60: Color,
    override var commonNeutralGray50: Color,
    override var commonNeutralGray40: Color,
    override var commonNeutralGray30: Color,
    override var commonNeutralGray20: Color,
    override var commonNeutralGray10: Color,
    override var commonNeutralGray5: Color,
    override var commonNeutralGray2: Color,
    /* ... */
) : ThemeableColors {
    override val tabSelectedBackground: Color = commonNeutralGray90
    override val tabBackground: Color = commonNeutralGray5
    override val footnote: Color = commonNeutralGray30
    override var primaryMain: Color = Color(0xFFF29600)
}

val LocalColors = staticCompositionLocalOf<ThemeableColors> {
    defaultThemeColors
}
