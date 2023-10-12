package com.nmg.mobile.design.widgets.videoplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun <Data : VideoPlayerControlData> VideoPlayerControl(
    data: Data,
    onVideoPlayerLayer: (@Composable (BoxScope) -> Unit)? = null,
    onVideoPlayerCompletedLayer: (@Composable (BoxScope) -> Unit)? = null,
    event: VideoPlayerControlEvent?
) {
    var sliderValue: Float by remember { mutableStateOf(data.sliderValue) }
    var playerState: VideoPlayerControlState by remember { mutableStateOf(data.playState) }
    var playerIcon = when (playerState) {
        VideoPlayerControlState.LOADING -> R.drawable.video_player_loading
        VideoPlayerControlState.PLAYING -> 0
        VideoPlayerControlState.PLAYING_TAB -> R.drawable.video_player_pause
        VideoPlayerControlState.PAUSED -> R.drawable.video_player_play
        VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> R.drawable.video_player_replay
        else -> R.drawable.video_player_pause
    }
    var isShowControl = when (playerState) {
        VideoPlayerControlState.LOADING -> true
        VideoPlayerControlState.PLAYING -> false
        VideoPlayerControlState.PLAYING_TAB -> true
        VideoPlayerControlState.PAUSED -> true
        VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> true
        else -> false
    }

    Box(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .size(390.dp, 219.dp)
            .background(Color.Black)
    ) {
        onVideoPlayerLayer?.let { it ->
            it(this)
        }
        if (playerState == VideoPlayerControlState.LOADING) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(data.imageURL)
                    .crossfade(true).build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.background(
                    color = Color.Black,
                    shape = RoundedCornerShape(4.dp)
                ).fillMaxSize().aspectRatio(390f / 219f).size(390.dp, 219.dp)
            )
        }
        if (playerState == VideoPlayerControlState.COMPLETED) {
            onVideoPlayerCompletedLayer?.let { it ->
                it(this)
            }
        }
        if (isShowControl) {
            IconButton(onClick = { event?.onClickBack() }) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(36.dp)
                        .height(36.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.video_player_back),
                    contentDescription = ""
                )
            }
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (playerState != VideoPlayerControlState.LOADING) {
                    IconButton(onClick = { event?.onClickPre() }) {
                        Icon(
                            modifier = Modifier
                                .width(44.dp)
                                .height(44.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_pre),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.width(32.dp))
                IconButton(onClick = {
                    when (playerState) {
                        VideoPlayerControlState.LOADING -> { /* pass */ }
                        VideoPlayerControlState.PLAYING -> { /* pass */ }
                        VideoPlayerControlState.PLAYING_TAB -> {
                            event?.onClickPause()
                        }
                        VideoPlayerControlState.PAUSED -> {
                            event?.onClickPlay()
                        }
                        VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                            event?.onClickReplay()
                        }
                        else -> { /* pass */ }
                    }
                }) {
                    Icon(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp),
                        tint = Color.White,
                        painter = painterResource(id = playerIcon),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))
                if (playerState != VideoPlayerControlState.LOADING) {
                    IconButton(onClick = { event?.onClickNext() }) {
                        Icon(
                            modifier = Modifier
                                .width(44.dp)
                                .height(44.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_next),
                            contentDescription = ""
                        )
                    }
                }
            }
            if (playerState == VideoPlayerControlState.PLAYING_TAB ||
                playerState == VideoPlayerControlState.PAUSED ||
                playerState == VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 15.dp)
                ) {
                    Text(
                        text = "1:36",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "/",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = NMGTheme.colors.commonNeutralGray20,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = data.totalTime,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = NMGTheme.colors.commonNeutralGray20,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
            if (playerState == VideoPlayerControlState.PAUSED ||
                playerState == VideoPlayerControlState.PLAYING_TAB
            ) {
                IconButton(
                    onClick = { event?.onClickFullScreen() },
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
        if (playerState != VideoPlayerControlState.LOADING &&
            playerState != VideoPlayerControlState.COMPLETED
        ) {
            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .align(Alignment.BottomCenter),
                value = sliderValue,
                onValueChange = { },
//            valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
//            steps = 5,
                colors = SliderDefaults.colors(
                    thumbColor = NMGTheme.colors.primaryMain,
                    activeTrackColor = NMGTheme.colors.primaryMain,
                    inactiveTrackColor = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoPlayerControlPreview() {
    NMGTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding),
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.LOADING
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )

            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.PLAYING
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )

            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.PLAYING_TAB
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )

            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.PAUSED
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )

            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.COMPLETED
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )

            VideoPlayerControl(
                object : VideoPlayerControlData {
                    override var playState: VideoPlayerControlState = VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY
                    override var imageURL: String = "https://placehold.co/390x219/png"
                    override var totalTime: String = "22:22"
                    override var sliderValue: Float = 0.5f
                },
                null,
                null,
                null
            )
        }
    }
}
