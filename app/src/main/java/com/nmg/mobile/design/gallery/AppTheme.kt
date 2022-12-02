package com.nmg.mobile.design.gallery

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

private val colorLightPrimary = Color(0xFFFFB400)

class AppColors(
    primary: Color,
) {
    var primary by mutableStateOf(primary)
        private set

    fun copy(
        primary: Color = this.primary
    ): AppColors = AppColors(
        primary
    )

    // will be explained later
    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
    }
}

fun lightColors(
    primary: Color = colorLightPrimary,
): AppColors = AppColors(
    primary = primary,
)

internal val LocalColors = staticCompositionLocalOf{ lightColors() }

@Composable
fun AppTheme(
    colors: AppColors = AppTheme.colors,
    content: @Composable () -> Unit
) {
    // creating a new object for colors to not mutate the initial colors set when updating the values
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
    ) {
        content()
    }
}