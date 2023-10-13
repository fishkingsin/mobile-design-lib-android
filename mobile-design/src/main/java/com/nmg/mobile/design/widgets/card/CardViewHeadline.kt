package com.nmg.mobile.design.widgets.card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> CardViewHeadline(data: Data) {
    Text(
        text = data.headline,
        maxLines = 2,
        style = NMGTheme.typography.headline,
        overflow = TextOverflow.Ellipsis
    )
}
