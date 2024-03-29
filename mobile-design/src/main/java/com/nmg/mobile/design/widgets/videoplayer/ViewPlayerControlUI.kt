package com.nmg.mobile.design.widgets.videoplayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R

@Composable
fun ViewPlayerControlUI(
    boxScope: BoxScope,
    state: VideoPlayerControlState,
    onClickPlayPrevious: (() -> Unit)? = null,
    onClickPlay: (() -> Unit) = {},
    onClickPlayNext: (() -> Unit)? = null,
    onFullScreenClick: (() -> Unit) = {}
) {
    boxScope.apply {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onClickPlayPrevious != null) {
                IconButton(onClick = onClickPlayPrevious) {
                    Icon(
                        modifier = Modifier
                            .width(44.dp)
                            .height(44.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.video_player_pre),
                        contentDescription = ""
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                ) {
                }
            }
            Spacer(modifier = Modifier.width(32.dp))

            IconButton(
                enabled = when (state) {
                    is VideoPlayerControlState.LOADING -> false
                    is VideoPlayerControlState.ERROR -> false
                    else -> true
                },
                onClick = onClickPlay
            ) {
                Icon(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    tint = Color.White,
                    painter = painterResource(state.icon),
                    contentDescription = ""
                )

//                    painter = painterResource(id = R.drawable.video_player_replay),
            }
            Spacer(modifier = Modifier.width(32.dp))
            if (onClickPlayNext != null) {
                IconButton(onClick = {
                    onClickPlayNext()
                }) {
                    Icon(
                        modifier = Modifier
                            .width(44.dp)
                            .height(44.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.video_player_next),
                        contentDescription = ""
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                ) {
                }
            }
        }

        IconButton(
            onClick = {
                onFullScreenClick()
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .width(16.dp)
                    .height(16.dp),
                tint = Color.White,
                painter = painterResource(id = R.drawable.video_player_expand),
                contentDescription = ""
            )
        }
    }
}

@Composable
@Preview
fun ViewPlayerControlUI_Playing_Preview() {
    Box(Modifier.width(640.dp).height(360.dp)) {
        ViewPlayerControlUI(
            boxScope = this,
            state = VideoPlayerControlState.PLAYING(),
            onClickPlay = {},
            onFullScreenClick = {}
        )
    }
}

@Composable
@Preview
fun ViewPlayerControlUI_Paused_Preview() {
    Box(Modifier.width(640.dp).height(360.dp)) {
        ViewPlayerControlUI(
            boxScope = this,
            state = VideoPlayerControlState.PAUSED(),
            onClickPlay = {},
            onFullScreenClick = {}
        )
    }
}

@Composable
@Preview
fun ViewPlayerControlUI_Loading_Preview() {
    Box(Modifier.width(640.dp).height(360.dp)) {
        ViewPlayerControlUI(
            boxScope = this,
            state = VideoPlayerControlState.LOADING(),
            onClickPlay = {},
            onFullScreenClick = {}
        )
    }
}

@Composable
@Preview
fun ViewPlayerControlUI_Previous_Preview() {
    Box(Modifier.width(640.dp).height(360.dp)) {
        ViewPlayerControlUI(
            boxScope = this,
            state = VideoPlayerControlState.PLAYING(),
            onClickPlayPrevious = {},
            onClickPlay = {},
            onClickPlayNext = {},
            onFullScreenClick = {}
        )
    }
}
