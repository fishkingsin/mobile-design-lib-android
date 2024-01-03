package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : CardDataProtocol> VerticalCard(data: Data) {
    Box(
        modifier = Modifier
            .aspectRatio(126f / 224f)
            .heightIn(max = 224.dp)
            .widthIn(max = 126.dp)
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
                .background(color = Color.Black, shape = shape)
                .clip(shape)
                .fillMaxSize()
        )

        data.tag?.also {
            if (it.isNotEmpty()) {
                Text(
                    text = it,
                    color = Color.White,
                    style = NMGTheme.typography.eleMedium14,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                        .align(Alignment.BottomStart)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerticalCardViewPreview() {
    Box(
        modifier = Modifier.size(126f.dp, 224f.dp)
    ) {
        VerticalCard(
            data = CardData(
                id = 1,
                imageURL = "https://placehold.co/126x224/png",
                headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                leadingFootnote = "4小時前",
                secondFootnote = "經人觀點",
                tag = "#職學職用",
                _timecode = "22:22"
            )
        )
    }
}
