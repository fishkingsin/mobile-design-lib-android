package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun TopImageCardView(
    imageURL: String,
    overlay: @Composable ((BoxScope) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(NMGTheme.customSystem.roudnCorner)
    Column(
        verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding)
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageURL)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .background(color = Color.Black, shape = shape)
                    .clip(shape)
                    .fillMaxWidth()
                    .heightIn(
                        NMGTheme.customSystem.cardMinHeight,
                        NMGTheme.customSystem.cardMaxHeight
                    )
            )

            overlay?.let {
                it(this)
            }
        }
        content()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopImageCardView_Preview() {
    NMGTheme {
        TopImageCardView(
            imageURL = "https://placehold.co/358x200/png",
            overlay = {
                CardViewTimeCodeOverlay("12:34", it)
            },
            content = {}
        )
    }
}
