package com.nmg.mobile.design.gallery.demo.tvpoc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun TVNote() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "2022/11/25",
            style = NMGTheme.typography.eleRegular16,
            color = NMGTheme.colors.textSecondary
        )
        Text(
            text = "經人觀點",
            style = NMGTheme.typography.eleRegular16,
            color = NMGTheme.colors.textSecondary
        )
    }
}
