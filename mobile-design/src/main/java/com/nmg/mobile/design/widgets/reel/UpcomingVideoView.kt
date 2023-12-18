package com.nmg.mobile.design.widgets.reel

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Item : UpcomingItem> UpcomingVideoView(item: Item,
                                                   onClickCancel: (() -> Unit)? = null,
                                                   onClickPlay: (() -> Unit)? = null,
                                                   secCountDown: Int = 10,
                                                   ) {
    Column(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .heightIn(max = 219.dp)
            .widthIn(max = 390.dp)
            .background(color = Color.Black)
            .padding(NMGTheme.customSystem.padding)
    ) {
        Row {
            Text(
                text = "將於",
                style = NMGTheme.typography.eleRegular14,
                color = NMGTheme.colors.commonNeutralGray50
            )
            Text(
                text = "$secCountDown",
                style = NMGTheme.typography.eleRegular14,
                color = NMGTheme.colors.commonNeutralGray2,
                modifier = Modifier.padding(top = 1.dp, start = 2.dp, end = 3.dp)
            )
            Text(
                text = "秒後播放",
                style = NMGTheme.typography.eleRegular14,
                color = NMGTheme.colors.commonNeutralGray50
            )
        }
        Row(modifier = Modifier.padding(top = 18.dp)) {
            Box(contentAlignment = Alignment.BottomEnd) {
                val shape = RoundedCornerShape(4.dp)
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.imageURL)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .background(color = Color.Black, shape = shape)
                        .width(144.dp)
                        .height(75.dp)
                        .aspectRatio(75f / 144f)
                        .clip(shape)
                )
                Text(
                    text = item.timeCode,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .padding(bottom = 4.dp, end = 4.dp)
                        .background(
                            color = Color(0xF2838383),
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                        .padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = item.headline,
                style = NMGTheme.typography.cardTitle,
                color = NMGTheme.colors.commonNeutralGray2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "取消",
                textAlign = TextAlign.Center,
                style = NMGTheme.typography.eleRegular16,
                color = NMGTheme.colors.commonNeutralGray2,
                modifier = Modifier
                    .weight(1f)
                    .clickable(true, onClick = {
                        Log.i("UpcomingVideoView", "onClickCancel")
                        onClickCancel?.let { it() }
                    })
                    .border(width = 1.dp, color = NMGTheme.colors.commonNeutralGray2)
                    .background(color = Color.Transparent)
                    .padding(top = 9.dp, bottom = 9.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "立即播放",
                textAlign = TextAlign.Center,
                style = NMGTheme.typography.eleRegular16,
                color = NMGTheme.colors.commonNeutralGray90,
                modifier = Modifier
                    .weight(1f)
                    .clickable(true, onClick = {
                        Log.i("UpcomingVideoView", "onClickPlay")
                        onClickPlay?.let {
                            Log.i("UpcomingVideoView", "onClickPlay let")
                            it()
                        }
                    })
                    .border(width = 1.dp, color = NMGTheme.colors.commonNeutralGray2)
                    .background(color = Color.White)
                    .padding(top = 9.dp, bottom = 9.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UpcomingVideoViewPreview() {
    UpcomingVideoView(
        object : UpcomingItem {
            override var imageURL: String = "https://placehold.co/144x75/png"
            override var headline: String = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式"
            override var timeCode: String = "22:22"
            override var secCountDown: Int = 10
        },
    )
}
