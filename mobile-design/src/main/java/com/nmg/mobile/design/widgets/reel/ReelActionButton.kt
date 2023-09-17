package com.nmg.mobile.design.widgets.reel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun ReelActionButton(
    @DrawableRes vectorDrawableRes: Int,
    @DrawableRes vectorDrawableResSelected: Int? = null,
    isSelected: Boolean = false
) {
    val hasSelectRes = isSelected && null != vectorDrawableResSelected
    val currentRes = if (hasSelectRes) { vectorDrawableResSelected } else { vectorDrawableRes }
    val tintColor = if (hasSelectRes) { Color.Red } else { Color.White }
//    val drawable = AppCompatResources.getDrawable(LocalContext.current, id)
    Box(modifier = Modifier.size(36.dp, 36.dp)) {
        currentRes?.let {
            Icon(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.Center),
                tint = tintColor,
                painter = rememberVectorPainter(image = ImageVector.vectorResource(id = currentRes)),
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReelActionButtonPreview() {
    NMGTheme {
        Row(modifier = Modifier.background(Color.Gray)) {
            ReelActionButton(vectorDrawableRes = R.drawable.reel_link)
            ReelActionButton(vectorDrawableRes = R.drawable.reel_like_normal, vectorDrawableResSelected = R.drawable.reel_like_selected)
            ReelActionButton(vectorDrawableRes = R.drawable.reel_like_normal, vectorDrawableResSelected = R.drawable.reel_like_selected, true)
        }
    }
}

