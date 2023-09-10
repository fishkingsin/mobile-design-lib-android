package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
public data class Colors(
    override val commonNeutralGray90: Color,
    override val commonNeutralGray80: Color,
    override val commonNeutralGray70: Color,
    override val commonNeutralGray60: Color,
    override val commonNeutralGray50: Color,
    override val commonNeutralGray40: Color,
    override val commonNeutralGray30: Color,
    override val commonNeutralGray20: Color,
    override val commonNeutralGray10: Color,
    override val commonNeutralGray5: Color,
    override val commonNeutralGray2: Color,
    /* ... */
) : ThemeableColors {
    override val chipSelectedBackground: Color = commonNeutralGray90
    override val chipBackground: Color = commonNeutralGray5
    override val footnote: Color = commonNeutralGray30
    override val primaryMain: Color = Color(0xFFF29600)
    override val primary: Color = primaryMain
}

val LocalColors = staticCompositionLocalOf<ThemeableColors> {
    defaultThemeColors
}
