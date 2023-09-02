package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R

@Composable
fun <Data: CardDataAbstract> CardView(data: Data) {
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageURL)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.clip(CircleShape).fillMaxWidth().height(200.dp)
        )
        Text(text = data.headline)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = data.leadingFootnote)
            Text(text = data.secondFootnote)
        }
    }
}

@Preview
@Composable
fun CardView_Preview() {
    CardView(data = CardData(
        imageURL = "https://placehold.co/358x200/png",
        headline = "headline",
        leadingFootnote = "leadingFootnote",
        secondFootnote = "secondFootnote",
        "timecode",
    ))
}