package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun PlayNowOverlay(boxScope: BoxScope) {
    boxScope.apply {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.75F)
                .background(Color.Black, shape = RoundedCornerShape(4.dp))
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.playing_now),
                color = Color.White,
                style = NMGTheme.typography.eleRegular16,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun playNowOverlay_Preview() {
    Box(
        modifier = Modifier.size(200f.dp, 200f.dp)
    ) {
        PlayNowOverlay(this)
    }
}
