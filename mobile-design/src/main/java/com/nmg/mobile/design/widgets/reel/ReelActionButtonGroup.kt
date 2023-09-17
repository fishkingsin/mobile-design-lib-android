package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun ReelActionButtonGroup() {
    Column(
        verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding),
        horizontalAlignment = Alignment.CenterHorizontally
//        horizontalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.spacing)
    ) {
        ReelActionButton(vectorDrawableRes = R.drawable.reel_link)
        ReelActionButton(vectorDrawableRes = R.drawable.reel_like_normal, vectorDrawableResSelected = R.drawable.reel_like_selected)
        ReelActionButton(vectorDrawableRes = R.drawable.reel_share)
    }
}

@Preview(showBackground = true)
@Composable
fun ReelActionButtonGroupPreview() {
    NMGTheme {
        Box(modifier = Modifier.background(Color.Black)) {
            ReelActionButtonGroup()
        }
    }
}