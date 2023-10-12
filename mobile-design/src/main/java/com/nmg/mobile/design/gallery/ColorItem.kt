package com.nmg.mobile.design.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

private fun Color.toHexCode(): String {
    val red = this.red * 255
    val green = this.green * 255
    val blue = this.blue * 255
    return String.format("#%02x%02x%02x", red.toInt(), green.toInt(), blue.toInt())
}

@Composable
public fun ColorItem(colorName: String = "", color: Color) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(colorName, style = NMGTheme.typography.caption)
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RectangleShape)
                .background(color)
                .border(1.dp, Color.Black, RectangleShape)
        ) {
        }
        Text(color.toHexCode())
    }
}

@Preview
@Composable
fun ColorItem_Preview() {
    NMGTheme {
        ColorItem(NMGTheme.colors.primaryMain.toHexCode(), NMGTheme.colors.primaryMain)
    }
}
