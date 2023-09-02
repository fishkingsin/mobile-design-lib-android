package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.sp

@Immutable
data class TextStyles(
    var largeTitleEmphasize: TextStyle,
    var titleEmphasize: TextStyle,
    var title1: TextStyle,
    var title2: TextStyle,
    var title3: TextStyle,
    var title4: TextStyle,
    var title2Emphasize: TextStyle,
    var title3Emphasize: TextStyle,
    var title4Emphasize: TextStyle,
    var title5: TextStyle,
    var headline: TextStyle,
    var headlineEmphasize: TextStyle,
    var primaryButton: TextStyle,
    var captionEmphasize: TextStyle,
    var caption: TextStyle,
    var caption2: TextStyle,
    var caption3Emphasize: TextStyle,
    var naviTitle: TextStyle,
    var body: TextStyle,
    var bodyEmphasize: TextStyle
)

val LocalTextStyles = staticCompositionLocalOf {
    TextStyles(
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