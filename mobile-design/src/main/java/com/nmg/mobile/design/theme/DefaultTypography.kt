package com.nmg.mobile.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nmg.mobile.design.R

private val fontFamily = FontFamily(
    Font(R.font.pingfang_bold, FontWeight.Bold),
    Font(R.font.pingfang_extralight, FontWeight.ExtraLight),
    Font(R.font.pingfang_heavy, FontWeight.Bold),
    Font(R.font.pingfang_light, FontWeight.Light),
    Font(R.font.pingfang_medium, FontWeight.Medium),
    Font(R.font.pingfang_regular, FontWeight.Normal)
)

private val fontStyle = TextStyle(
    fontFamily = fontFamily
)

private val eleRegular14 = fontStyle.copy(
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal
)

private val articleH1 = fontStyle.copy(
    fontSize = 20.sp,
    lineHeight = 30.sp,
    fontWeight = FontWeight.SemiBold
)

public val defaultTypography = Typography(
    eleSemibold24 = fontStyle.copy(
        fontFamily = fontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    eleSemibold22 = fontStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold
    ),

    eleMedium18 = fontStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    eleMedium14 = fontStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),

    eleRegular24 = fontStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular18 = fontStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular16 = fontStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular14 = eleRegular14,
    eleRegular12 = fontStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular10 = fontStyle.copy(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    ),
    articleH1 = articleH1,
    articleH2 = fontStyle.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.32.sp
    ),
    articleH3 = fontStyle.copy(
        fontSize = 16.sp,
        lineHeight = 28.8.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.32.sp
    ),
    articleContent = fontStyle.copy(
        fontSize = 16.sp,
        lineHeight = 27.2.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.32.sp
    ),
    articleDescription = fontStyle.copy(
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.28.sp
    ),
    // exceptional
    carouselTitle = articleH1.copy(
        letterSpacing = 0.4.sp
    ),

    cardTitle = fontStyle.copy(
        fontSize = 16.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight.Medium
    ),
    cardContent = eleRegular14.copy(
        lineHeight = 18.2.sp
    )
)
