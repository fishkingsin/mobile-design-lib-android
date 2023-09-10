package com.nmg.mobile.design.widgets.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme.colors
import com.nmg.mobile.design.conditional
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun Chip(content: @Composable (selected: Boolean) -> Unit, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(60.dp)
    val chipBackground = colors.chipBackground
    val chipSelectedBackground = colors.chipSelectedBackground
    Box(
        modifier = Modifier
            .background(color = chipBackground, shape = shape)
            .conditional(selected, modifier = { background(color = chipSelectedBackground, shape = shape) })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            content(selected)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TabCell_Preview() {
    NMGTheme {
        Chip(
            content = { Text("123") },
            selected = false,
            onClick = { }
        )
    }

}