package com.nmg.mobile.design.gallery.demo.tvpoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Suppress("ktlint:standard:max-line-length")
@Composable
fun TVBody() {
    Text(
        text = "飲飲食食的小生意，對於疊水的投資者，缺乏性感的想像空間，偏偏神州大地是14億人口的市場，若從每... 展開",
        style = NMGTheme.typography.body,
        color = NMGTheme.colors.commonNeutralGray90
    )
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                painter = painterResource(id = R.drawable.share),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }
    }
}
