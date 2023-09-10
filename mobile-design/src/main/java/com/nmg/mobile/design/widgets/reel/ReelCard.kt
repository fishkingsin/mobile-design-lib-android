package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.card.CardDataAbstract

@Composable
public fun <Data : CardDataAbstract>ReelCard(data: Data, overlay: (@Composable (BoxScope) -> Unit)? = null) {
    Box(
        modifier = Modifier
            .aspectRatio(126f / 224f)
            .heightIn(max = 224.dp)
            .widthIn(max = 124.dp)
    ) {
        val shape = RoundedCornerShape(4.dp)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageURL)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .background(color = Color.Black, shape = shape)
                .fillMaxSize()
        )
        overlay?.let {
            it(this)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReelCardPreview() {
    ReelCard(
        data = CardData(
            imageURL = "https://placehold.co/124x224/png",
            headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
            leadingFootnote = "4小時前",
            secondFootnote = "經人觀點",
            _timecode = "22:22"
        ),
        overlay = {
            ReelCardOverlay("#hashtag", it)
        }
    )
}
