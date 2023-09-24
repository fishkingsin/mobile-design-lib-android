package com.nmg.mobile.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

public val defaultTypography = Typography(
    largeTitleEmphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp
    ),
    titleEmphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    title1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    title1Medium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight(500),
        letterSpacing = 0.35.sp
    ),
    title2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    title3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp
    ),
    title4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    title2Emphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    title3Emphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    title4Emphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    title5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    headline = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.4.sp
    ),
    headlineEmphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    primaryButton = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    captionEmphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    caption2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    caption3Emphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 8.sp
    ),
    naviTitle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyEmphasize = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)
