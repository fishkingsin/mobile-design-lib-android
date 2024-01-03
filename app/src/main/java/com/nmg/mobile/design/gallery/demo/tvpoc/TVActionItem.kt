package com.nmg.mobile.design.gallery.demo.tvpoc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Suppress("ktlint:standard:max-line-length")
@Composable
fun TVActionItem() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
                color = Color(0xFF00E2FF),
                shape = RoundedCornerShape(size = 4.dp)
            )
            .background(
                color = Color(0xF2FFFFFF),
                shape = RoundedCornerShape(size = 4.dp)
            ),

        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "李小加獨家專訪 2小時足本回顧",
                style = NMGTheme.typography.articleH1,
                color = NMGTheme.colors.primaryMain
            )
            Text(
                text = """
                    滴灌通主席李小加就想到了破解方案，兼開發出複利生財的投資模式，有如太極生兩儀、兩儀生四象。薑是老的辣，61歲的他下海創業，把生意經的算盤敲得更為響噹噹。
                """,
                style = NMGTheme.typography.articleDescription,
                color = NMGTheme.colors.commonNeutralGray90
            )
        }
    }
}
