package com.nmg.mobile.design.gallery.demo

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.card.CardView
import com.nmg.mobile.design.widgets.reel.ReelCard

@Composable
fun CardDemo() {
    Column {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(10) {
                        ReelCard(
                            data = CardData(
                                imageURL = "https://placehold.co/124x224/png",
                                headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                                leadingFootnote = "4小時前",
                                secondFootnote = "經人觀點",
                                _timecode = "22:22"
                            )
                        )
                    }
                }
            }
            items(10) {
                CardView(
                    data = CardData(
                        imageURL = "https://placehold.co/358x200/png",
                        headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                        leadingFootnote = "4小時前",
                        secondFootnote = "經人觀點",
                        _timecode = "22:22"
                    )
                )
            }
        }
    }
}