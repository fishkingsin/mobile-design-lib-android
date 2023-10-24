package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.theme.NMGTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
public fun ReelPager(list: MutableList<ReelPlayerData>) {
    // Display 10 items
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
//        val nestedScrollConnection = object: NestedScrollConnection {
//
//        }

        val pagerState = rememberPagerState(initialPage = 0)
        VerticalPager(pageCount = 10, state = pagerState) {
            ReelPlayer(item = list[it]) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
public fun ReelPagerPreview() {
    val list = mutableListOf<ReelPlayerData>()
    for (item in 1..10) {
        list.add(object : ReelPlayerData {
            override var title: String = "@經一共肥計畫 $item"
            override var desc: String = "若從每人身上賺1元大餅，已是14個億的大茶飯，難度在於中間化零為整的手段。滴灌通主席李小加就想到了破解方案，兼開發出複利生財的投資模式，有如太極生兩儀、兩儀生四象。薑是老的辣，61歲的他下海創業，把生意經的算盤敲得響噹噹。 $item"
        })
    }
    NMGTheme {
        ReelPager(list = list)
    }
}
