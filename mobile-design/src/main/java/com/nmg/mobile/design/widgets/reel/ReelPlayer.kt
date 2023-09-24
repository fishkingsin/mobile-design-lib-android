package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Item: ReelPlayerData> ReelPlayer(item: Item, playerView: @Composable ((BoxScope) -> Unit)? = null) {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        playerView?.let {
            it(this)
        }
        ConstraintLayout(modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .align(Alignment.BottomEnd)
        ) {
            val (titleContainer, reelActionButtonGroup, mask) = createRefs()
            Image(modifier = Modifier.constrainAs(mask) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(titleContainer.top)
                    width = fillToConstraints
                    height = fillToConstraints
                },
                painter = painterResource(id = R.drawable.reel_mask),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(start = NMGTheme.customSystem.padding, end = 10.dp, bottom = NMGTheme.customSystem.padding)
                    .constrainAs(titleContainer) {
                    start.linkTo(parent.start)
                    end.linkTo(reelActionButtonGroup.start)
                    bottom.linkTo(parent.bottom)
                    width = fillToConstraints
                },
                verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White,
                    )
                )
                ExpandTextView(
                    text = item.desc,
                )
            }
            ReelActionButtonGroup(
                modifier = Modifier.constrainAs(reelActionButtonGroup) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }.padding(end = NMGTheme.customSystem.padding, bottom = NMGTheme.customSystem.padding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReelPlayerPreview() {
    val item = object : ReelPlayerData {
        override var title: String = "@經一共肥計畫"
        override var desc: String = "若從每人身上賺1元大餅，已是14個億的大茶飯，難度在於中間化零為整的手段。滴灌通主席李小加就想到了破解方案，兼開發出複利生財的投資模式，有如太極生兩儀、兩儀生四象。薑是老的辣，61歲的他下海創業，把生意經的算盤敲得響噹噹。"

    }
    NMGTheme {
        Box(modifier = Modifier.background(Color.Gray)) {
            ReelPlayer(item)
        }
    }
}