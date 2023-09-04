package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun <Data : CardDataAbstract> CardViewFootnote(data: Data) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.spacing)
    ) {
        val color = NMGTheme.colors.footnote
        val style = NMGTheme.typography.caption

        Text(text = data.leadingFootnote, color = color, style = style)
        Text(text = data.secondFootnote, color = color, style = style)
    }
}