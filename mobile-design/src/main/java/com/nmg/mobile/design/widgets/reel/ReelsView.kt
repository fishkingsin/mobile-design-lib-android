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
public fun ReelsView(reels: List<ReelInterface> = DummyData.reels) {
    Box(Modifier.background(color = Color.Black)) {
        ReelsList(reels)

        ReelsHeader()
    }
}
