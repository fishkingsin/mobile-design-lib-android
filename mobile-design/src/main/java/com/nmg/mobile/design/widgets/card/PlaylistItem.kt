package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> PlaylistItem(data: Data) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        TopImageCardView(
            data.imageURL,
            overlay = {
                Image(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_playlist_item_play),
                    contentDescription = "image description"
                )
            }
        ) {
            CardViewHeadline(data)
            CardViewFootnote(data)
        }
    }
}

@Preview
@Composable
fun PlaylistItem_Preview() {
    NMGTheme {
        PlaylistItem(
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
