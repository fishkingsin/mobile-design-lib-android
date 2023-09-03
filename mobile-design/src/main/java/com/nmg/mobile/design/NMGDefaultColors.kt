package com.nmg.mobile.design

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.res.ResourcesCompat
import com.nmg.mobile.design.theme.ThemeableColors

public data class NMGDefaultColors(val context: Context) : ThemeableColors {
    override val tabSelectedBackground: Color
        get() = commonNeutralGray90
    override val tabBackground: Color
        get() = commonNeutralGray5
    override var commonNeutralGray90: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_90,
        context.theme
    ))

    override var commonNeutralGray80: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_80,
        context.theme
    ))

    override var commonNeutralGray70: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_70,
        context.theme
    ))


    override var commonNeutralGray60: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_60,
        context.theme
    ))

    override var commonNeutralGray50: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_50,
        context.theme
    ))

    override var commonNeutralGray40: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_40,
        context.theme
    ))


    override var commonNeutralGray30: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_30,
        context.theme
    ))


    override var commonNeutralGray20: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_20,
        context.theme
    ))


    override var commonNeutralGray10: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_10,
        context.theme
    ))
    override var commonNeutralGray5: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_5,
        context.theme
    ))
    override var commonNeutralGray2: Color = Color(ResourcesCompat.getColor(
        context.resources,
        R.color.Common_Neutral_Gray_2,
        context.theme
    ))

    override var primaryMain: Color = Color(context.themeColor(R.attr.primaryMain))

    override val footnote: Color
        get() = commonNeutralGray30
}

@ColorInt
@SuppressLint("Recycle")
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.Unspecified.toArgb())
    }
}