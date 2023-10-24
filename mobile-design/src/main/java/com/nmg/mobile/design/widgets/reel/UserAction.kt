package com.nmg.mobile.design.widgets.reel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun UserAction(@DrawableRes drawableRes: Int) {
    Icon(
        bitmap = ImageBitmap.imageResource(id = drawableRes),
        tint = Color.White,
        modifier = Modifier.size(16.dp),
        contentDescription = null
    )
}
