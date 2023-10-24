package com.nmg.mobile.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

public val defaultTypography = Typography(
    eleSemibold24 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    ),
    eleSemibold22 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold
    ),

    eleMedium18 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    eleMedium14 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),

    eleRegular24 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular18 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular16 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular14 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular12 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    eleRegular10 = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    ),

    carouselTitle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.4.sp
    ),
    cardTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight.Medium
    ),
    cardContent = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.2.sp,
        fontWeight = FontWeight.Normal
    ),
    articleH1 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.SemiBold
    ),
    articleH2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.32.sp
    ),
    articleH3 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 28.8.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.32.sp
    ),
    articleContent = TextStyle(
        fontSize = 16.sp,
        lineHeight = 27.2.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.32.sp
    ),
    articleDescription = TextStyle(
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight(400),
        letterSpacing = 0.28.sp
    )
)
