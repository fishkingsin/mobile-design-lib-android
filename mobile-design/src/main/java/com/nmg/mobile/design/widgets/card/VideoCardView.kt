package com.nmg.mobile.design.widgets.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataAbstract> VideoCardView(data: Data) {
    TopImageCardView(data.imageURL, overlay = {
        CardViewTimeCodeOverlay(data.timecode, it)
    }) {
        CardViewHeadline(data)
        CardViewFootnote(data)
    }
}

@Preview
@Composable
fun VideoCardView_Preview() {
    NMGTheme {
        VideoCardView(
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
