package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nmg.mobile.design.R

@Composable
fun ReelsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Reels", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.ic_outlined_camera),
            tint = Color.White,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
    }
}