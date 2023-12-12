package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> VideoCardView(
    data: Data,
    overlay: @Composable ((BoxScope) -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        TopImageCardView(data.imageURL, overlay = overlay) {
            CardViewHeadline(data)
            CardViewFootnote(data)
        }
    }
}

@Suppress("ktlint:standard:max-line-length")
@Preview
@Composable
fun VideoCardView_Preview() {
    val cardData = CardData(
        imageURL = "https://placehold.co/358x200/png",
        headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式獨家專訪" +
                "｜用科技顛覆金融 李小加革新小店投資模式獨家專訪" +
                "｜用科技顛覆金融 李小加革新小店投資模式",
        leadingFootnote = "4小時前",
        secondFootnote = "經人觀點",
        _timecode = "22:22"
    )
    NMGTheme {
        VideoCardView(
            data = cardData
        ) { boxScope ->
            CardViewTimeCodeOverlay(cardData.timecode, boxScope)
        }
    }
}
