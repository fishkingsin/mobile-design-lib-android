package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val verticalPadding = 12.dp
val horizontalPadding = 10.dp

@Composable
fun ReelsView() {
    Box(Modifier.background(color = Color.Black)) {
        ReelsList(DummyData.reels)

        ReelsHeader()
    }
}

