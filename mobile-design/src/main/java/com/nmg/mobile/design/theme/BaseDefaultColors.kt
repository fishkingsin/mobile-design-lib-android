package com.nmg.mobile.design.theme

import androidx.compose.ui.graphics.Color

public abstract class BaseDefaultColors : ThemeableColors {

    val defaultColor: ThemeableColors = defaultThemeColors
    override val chipSelectedBackground: Color = defaultColor.chipSelectedBackground
    override val chipBackground: Color = defaultColor.chipBackground
    override val commonNeutralGray90: Color = defaultColor.commonNeutralGray90
    override val commonNeutralGray80: Color = defaultColor.commonNeutralGray80
    override val commonNeutralGray70: Color = defaultColor.commonNeutralGray70
    override val commonNeutralGray60: Color = defaultColor.commonNeutralGray60
    override val commonNeutralGray50: Color = defaultColor.commonNeutralGray50
    override val commonNeutralGray40: Color = defaultColor.commonNeutralGray40
    override val commonNeutralGray30: Color = defaultColor.commonNeutralGray30
    override val commonNeutralGray20: Color = defaultColor.commonNeutralGray20
    override val commonNeutralGray10: Color = defaultColor.commonNeutralGray10
    override val commonNeutralGray5: Color = defaultColor.commonNeutralGray5
    override val commonNeutralGray2: Color = defaultColor.commonNeutralGray2
    override val placeholder: Color = defaultColor.placeholder
    override val footnote: Color = defaultColor.footnote
    override val chipSelectedForeground: Color = defaultColor.chipSelectedForeground
    override val chipForeground: Color = defaultColor.chipForeground
    override val selectedTabContentColor: Color = defaultColor.selectedTabContentColor
    override val unselectedTabContentColor: Color = defaultColor.unselectedTabContentColor

}
