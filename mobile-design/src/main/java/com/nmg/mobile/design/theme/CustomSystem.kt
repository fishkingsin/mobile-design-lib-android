package com.nmg.mobile.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
public data class CustomSystem(
    val value1: Int,
    val value2: String,
    val padding: Dp = 12.dp,
    val spacing: Dp = 8.dp,
    val roudnCorner: Dp = 4.dp,
    val cardMinHeight: Dp = 120.dp,
    val cardMaxHeight: Dp = 200.dp,
) {
}


val LocalCustomSystem = staticCompositionLocalOf {
    CustomSystem(
        value1 = 0,
        value2 = "",
    )
}