package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> CardView(data: Data) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        TopImageCardView(data.imageURL) {
            CardViewHeadline(data)
            CardViewFootnote(data)
        }
    }
}

@Preview
@Composable
fun CardView_Preview() {
    NMGTheme {
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
