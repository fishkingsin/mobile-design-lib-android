package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nmg.mobile.design.widgets.card.CardViewTimeCodeOverlay

@Composable
fun ReelCardOverlay(message: String, boxScope: BoxScope) {
    CardViewTimeCodeOverlay(timecode = message, boxScope = boxScope)
}