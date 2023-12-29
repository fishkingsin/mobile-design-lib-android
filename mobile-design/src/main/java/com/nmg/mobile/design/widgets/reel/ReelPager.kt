package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
/*
e: file:///Users/james/Development/nmg/mobile-design-lib-android/mobile-design/src/main/java/com/nmg/mobile/design/widgets/reel/ReelPager.kt:27:26 Using 'rememberPagerState(Int = ..., Float = ...): PagerState' is an error. Please use the overload where you can provide a source of truth for the pageCount.
* */
//        val pagerState = rememberPagerState(initialPage = 0)
//        VerticalPager(pageCount = 10, state = pagerState) {
//            ReelPlayer(item = list[it]) {
//            }
//        }
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
