package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ReelCardOverlay(message: String, boxScope: BoxScope) {
    boxScope.apply {
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = message
        )
    }
}