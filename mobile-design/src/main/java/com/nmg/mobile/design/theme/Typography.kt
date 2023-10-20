package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp

@Immutable
public data class Typography(
    override val eleSemibold24: TextStyle,
    override val eleSemibold22: TextStyle,

    override val eleMedium18: TextStyle,
    override val eleMedium14: TextStyle,

    override val eleRegular24: TextStyle,
    override val eleRegular18: TextStyle,
    override val eleRegular16: TextStyle,
    override val eleRegular14: TextStyle,
    override val eleRegular12: TextStyle,
    override val eleRegular10: TextStyle,

    override val carouselTitle: TextStyle,
    override val cardTitle: TextStyle,
    override val cardContent: TextStyle,
    override val articleH1: TextStyle,
    override val articleH2: TextStyle,
    override val articleH3: TextStyle,
    override val articleContent: TextStyle,
    override val articleDescription: TextStyle
) : ThemeableTypography

val LocalTypography = staticCompositionLocalOf<ThemeableTypography> {
    Typography(
        eleSemibold24 = TextStyle(
            fontSize = 24.sp,
            fontWeight = SemiBold
        ),
        eleSemibold22 = TextStyle(
            fontSize = 22.sp,
            fontWeight = SemiBold
        ),

        eleMedium18 = TextStyle(
            fontSize = 18.sp,
            fontWeight = Medium,
            letterSpacing = 0.36.sp
        ),
        eleMedium14 = TextStyle(
            fontSize = 14.sp,
            fontWeight = Medium
        ),

        eleRegular24 = TextStyle(
            fontSize = 24.sp,
            fontWeight = Normal
        ),
        eleRegular18 = TextStyle(
            fontSize = 18.sp,
            fontWeight = Normal
        ),
        eleRegular16 = TextStyle(
            fontSize = 16.sp,
            fontWeight = Normal
        ),
        eleRegular14 = TextStyle(
            fontSize = 14.sp,
            fontWeight = Normal,
            letterSpacing = 0.28.sp
        ),
        eleRegular12 = TextStyle(
            fontSize = 12.sp,
            fontWeight = Normal,
            letterSpacing = 0.24.sp
        ),
        eleRegular10 = TextStyle(
            fontSize = 10.sp,
            fontWeight = Normal
        ),

        carouselTitle = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontWeight = SemiBold,
            letterSpacing = 0.4.sp
        ),
        cardTitle = TextStyle(
            fontSize = 16.sp,
            lineHeight = 21.sp,
            fontWeight = Medium
        ),
        cardContent = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.2.sp,
            fontWeight = Normal
        ),
        articleH1 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontWeight = SemiBold
        ),
        articleH2 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = SemiBold,
            letterSpacing = 0.32.sp
        ),
        articleH3 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 28.8.sp,
            fontWeight = SemiBold,
            letterSpacing = 0.32.sp
        ),
        articleContent = TextStyle(
            fontSize = 16.sp,
            lineHeight = 27.2.sp,
            fontWeight = Normal,
            letterSpacing = 0.32.sp
        ),
        articleDescription = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight(400),
            letterSpacing = 0.28.sp
        )
    )
}
