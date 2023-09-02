package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors(
    val tabSelectedBackground: Color,
    val tabBackground: Color,
    var commonNeutralGray90: Color,
    var commonNeutralGray80: Color,
    var commonNeutralGray70: Color,
    var commonNeutralGray60: Color,
    var commonNeutralGray50: Color,
    var commonNeutralGray40: Color,
    var commonNeutralGray30: Color,
    var commonNeutralGray20: Color,
    var commonNeutralGray10: Color,
    var commonNeutralGray5: Color,
    var commonNeutralGray2: Color,
    var primaryMain: Color,
    val footnote: Color,
    /* ... */
) {

}

val LocalColors = staticCompositionLocalOf {
    Colors(
        tabSelectedBackground = Color.Unspecified,
        tabBackground = Color.Unspecified,
        commonNeutralGray90 = Color.Unspecified,
        commonNeutralGray80 = Color.Unspecified,
        commonNeutralGray70 = Color.Unspecified,
        commonNeutralGray60 = Color.Unspecified,
        commonNeutralGray50 = Color.Unspecified,
        commonNeutralGray40 = Color.Unspecified,
        commonNeutralGray30 = Color.Unspecified,
        commonNeutralGray20 = Color.Unspecified,
        commonNeutralGray10 = Color.Unspecified,
        commonNeutralGray5 = Color.Unspecified,
        commonNeutralGray2 = Color.Unspecified,
        primaryMain = Color.Unspecified,
        footnote = Color.Unspecified,
        /* ... */
    )
}
