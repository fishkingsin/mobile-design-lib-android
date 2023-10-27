package com.nmg.mobile.design.gallery.demo.tvpoc

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Suppress("ktlint:standard:max-line-length")
@Composable
fun TVHeadline() {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式 #1",
        style = NMGTheme.typography.title2Emphasize
    )
}
