package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.nmg.mobile.design.widgets.card.CardViewTimeCodeOverlay

@Composable
public fun ReelCardOverlay(message: String, boxScope: BoxScope) {
    CardViewTimeCodeOverlay(timecode = message, boxScope = boxScope)
}
