package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    override val largeTitleEmphasize: TextStyle,
    override val titleEmphasize: TextStyle,
    override val title1: TextStyle,
    override val title2: TextStyle,
    override val title3: TextStyle,
    override val title4: TextStyle,
    override val title2Emphasize: TextStyle,
    override val title3Emphasize: TextStyle,
    override val title4Emphasize: TextStyle,
    override val title5: TextStyle,
    override val headline: TextStyle,
    override val headlineEmphasize: TextStyle,
    override val primaryButton: TextStyle,
    override val captionEmphasize: TextStyle,
    override val caption: TextStyle,
    override val caption2: TextStyle,
    override val caption3Emphasize: TextStyle,
    override val naviTitle: TextStyle,
    override val body: TextStyle,
    override val bodyEmphasize: TextStyle
): ThemeableTypography

val LocalTypography = staticCompositionLocalOf<ThemeableTypography> {
    Typography(
        largeTitleEmphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 45.sp),
        titleEmphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 24.sp),
        title1 = TextStyle(
            fontWeight = Normal,
            fontSize = 24.sp),
        title2 = TextStyle(
            fontWeight = Normal,
            fontSize = 18.sp),
        title3 = TextStyle(
            fontWeight = Normal,
            fontSize = 17.sp),
        title4 = TextStyle(
            fontWeight = Normal,
            fontSize = 20.sp),
        title2Emphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 18.sp),
        title3Emphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 17.sp),
        title4Emphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 20.sp),
        title5 = TextStyle(
            fontWeight = Normal,
            fontSize = 22.sp),
        headline = TextStyle(
            fontSize = 16.sp,
            lineHeight = 22.sp,
            fontWeight = Normal,
            letterSpacing = 0.4.sp,
        ),
        headlineEmphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 16.sp),
        primaryButton = TextStyle(
            fontWeight = Normal,
            fontSize = 14.sp),
        captionEmphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 12.sp),
        caption = TextStyle(
            fontWeight = Normal,
            fontSize = 12.sp),
        caption2 = TextStyle(
            fontWeight = Normal,
            fontSize = 10.sp),
        caption3Emphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 8.sp),
        naviTitle = TextStyle(
            fontWeight = Normal,
            fontSize = 14.sp),
        body = TextStyle(
            fontWeight = Normal,
            fontSize = 14.sp),
        bodyEmphasize = TextStyle(
            fontWeight = Bold,
            fontSize = 14.sp)
    )
}