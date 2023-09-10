package com.nmg.mobile.design.theme

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.res.ResourcesCompat
import com.nmg.mobile.design.R

public data class NMGDefaultColors(val context: Context): ThemeableColors {
    override val chipSelectedBackground: Color
        get() = commonNeutralGray90
    override val chipBackground: Color
        get() = commonNeutralGray5
    override val commonNeutralGray90: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_90,
        context.theme
    ))

    override val commonNeutralGray80: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_80,
        context.theme
    ))

    override val commonNeutralGray70: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_70,
        context.theme
    ))


    override val commonNeutralGray60: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_60,
        context.theme
    ))

    override val commonNeutralGray50: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_50,
        context.theme
    ))

    override val commonNeutralGray40: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_40,
        context.theme
    ))


    override val commonNeutralGray30: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_30,
        context.theme
    ))


    override val commonNeutralGray20: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_20,
        context.theme
    ))


    override val commonNeutralGray10: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_10,
        context.theme
    ))
    override val commonNeutralGray5: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_5,
        context.theme
    ))
    override val commonNeutralGray2: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_2,
        context.theme
    ))

    override val primaryMain: Color = Color(context.themeColor(R.attr.primaryMain))

    override val primary: Color = primaryMain

    override val footnote: Color
        get() = commonNeutralGray30
}

@ColorInt
@SuppressLint("Recycle")
public fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.Black.toArgb())
    }
}