package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun <Data : CardDataAbstract> CardView(data: Data) {
    val shape = RoundedCornerShape(4.dp)
    Column(
        modifier = Modifier.background(color = Color.White),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageURL)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .background(color = Color.Black, shape = shape)
                .fillMaxWidth()
                .heightIn(120.dp, 200.dp)
        )
        Text(
            text = data.headline,
            maxLines = 2,
            style = NMGTheme.typography.headline,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val color = NMGTheme.colors.footnote
            val style = NMGTheme.typography.caption

            Text(text = data.leadingFootnote, color = color, style = style)
            Text(text = data.secondFootnote, color = color, style = style)
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