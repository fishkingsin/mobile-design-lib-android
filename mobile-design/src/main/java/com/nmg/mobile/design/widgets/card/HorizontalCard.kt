package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> HorizontalCard(data: Data, isPlaying: Boolean = false) {
    Box(
        modifier = Modifier
            .background(if (isPlaying) NMGTheme.colors.commonNeutralGray5 else Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Box(
                Modifier
                    .width(width = 133.dp)
                    .aspectRatio(133F / 75F)
            ) {
                val shape = RoundedCornerShape(4.dp)
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data.imageURL)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .background(color = NMGTheme.colors.placeholder, shape = shape)
                        .fillMaxSize()
                        .clip(shape)
                )

                if (isPlaying) {
                    PlayNowOverlay(this)
                }
            }

            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = data.headline,
                color = NMGTheme.colors.commonNeutralGray90,
                style = NMGTheme.typography.cardTitle,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Suppress("ktlint:standard:max-line-length")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun horizontalCardView_Preview() {
    LazyColumn {
        items(10) {
            HorizontalCard(
                data = CardData(
                    imageURL = "https://placehold.co/133x75/png",
                    headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式獨家專訪" +
                        "｜用科技顛覆金融 李小加革新小店投資模式獨家專訪" +
                        "｜用科技顛覆金融 李小加革新小店投資模式",
                    leadingFootnote = "4小時前",
                    secondFootnote = "經人觀點",
                    _timecode = null
                ),
                isPlaying = it == 1
            )
        }
    }
}
