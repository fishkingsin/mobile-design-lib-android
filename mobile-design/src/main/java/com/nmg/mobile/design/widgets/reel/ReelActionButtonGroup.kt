package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun ReelActionButtonGroup(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReelActionButton(object : ReelActionButtonData {
            override var vectorDrawableRes: Int = R.drawable.reel_link
            override var vectorDrawableResSelected: Int? = null
            override var isSelected: Boolean = false
        })
        ReelActionButton(object : ReelActionButtonData {
            override var vectorDrawableRes: Int = R.drawable.reel_like_normal
            override var vectorDrawableResSelected: Int? = R.drawable.reel_like_selected
            override var isSelected: Boolean = false
        })
        ReelActionButton(object : ReelActionButtonData {
            override var vectorDrawableRes: Int = R.drawable.reel_share
            override var vectorDrawableResSelected: Int? = null
            override var isSelected: Boolean = true
        })
    }
}

@Preview(showBackground = true)
@Composable
fun ReelActionButtonGroupPreview() {
    NMGTheme {
        Box(modifier = Modifier.background(Color.Black)) {
            ReelActionButtonGroup(modifier = Modifier)
        }
    }
}
