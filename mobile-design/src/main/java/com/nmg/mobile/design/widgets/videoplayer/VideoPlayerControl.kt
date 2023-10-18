package com.nmg.mobile.design.widgets.videoplayer

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

data class VideoPlayerControl(
    val data: VideoPlayerControlData,
    val onVideoPlayerLayer: (@Composable (BoxScope) -> Unit)? = null,
    val onVideoPlayerCompletedLayer: (@Composable (BoxScope) -> Unit)? = null,
    val onSwipeProgressChange: ((Float) -> Unit)? = null,
    val event: VideoPlayerControlEvent? = null
) {
    @Composable
    fun playerInitView(boxScope: BoxScope) {
        boxScope.apply {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(data.imageURL)
                    .crossfade(true).build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .fillMaxSize()
                    .aspectRatio(390f / 219f)
                    .size(390.dp, 219.dp)
            )
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.video_player_loading),
                        contentDescription = ""
                    )
                }
            }
        }
    }

    @Composable
    fun playerPlayingView(boxScope: BoxScope, sliderValue: Float) {
        boxScope.apply {
            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .align(Alignment.BottomCenter),
                value = sliderValue,
                onValueChange = { itValue ->
                    onSwipeProgressChange?.let { itCall ->
                        itCall(itValue)
                    }
                },
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

    @Composable
    fun playerPlayingTabOrPauseOrCompletedView(
        boxScope: BoxScope,
        videoPlayerControlState: VideoPlayerControlState
    ) {
        boxScope.apply {
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                Spacer(modifier = Modifier.width(32.dp))
                IconButton(onClick = {
                }) {
                    val icon = when (videoPlayerControlState) {
                        VideoPlayerControlState.PLAYING_TAB -> R.drawable.video_player_pause
                        VideoPlayerControlState.PAUSED -> R.drawable.video_player_play
                        VideoPlayerControlState.COMPLETED -> R.drawable.video_player_replay
                        else -> 0
                    }
                    Icon(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp),
                        tint = Color.White,
                        painter = painterResource(id = icon),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))
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

            if (VideoPlayerControlState.PAUSED == videoPlayerControlState
                || VideoPlayerControlState.PLAYING == videoPlayerControlState
                || VideoPlayerControlState.PLAYING_TAB == videoPlayerControlState
            )
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

    @Composable
    fun view() {
        val targetState = when (data.playState) {
            VideoPlayerControlState.PLAYER_INIT -> VideoPlayerControlState.LOADING
            VideoPlayerControlState.PLAYER_IDLE -> VideoPlayerControlState.LOADING
            VideoPlayerControlState.LOADING -> data.playState
            VideoPlayerControlState.PLAY_READY -> VideoPlayerControlState.PAUSED
            VideoPlayerControlState.PLAYING -> data.playState
            VideoPlayerControlState.PLAYING_TAB -> data.playState
            VideoPlayerControlState.PAUSED -> data.playState
            VideoPlayerControlState.COMPLETED -> data.playState
            VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> data.playState
            else -> VideoPlayerControlState.LOADING
        }
        Box(
            modifier = Modifier
                .aspectRatio(390f / 219f)
                .size(390.dp, 219.dp)
                .background(Color.Black)
                .clickable(enabled = true, onClick = {
                    if (data.playState == VideoPlayerControlState.PLAYING) {
                        event?.onClickVideoWhenPlaying()
                    }
                })
        ) {
            onVideoPlayerLayer?.let { it ->
                it(this)
            }
            Log.i(
                "[VideoPlayer]",
                "[VideoPlayer]playState=${data.playState}, targetState=${targetState}"
            )
            when (targetState) {
                VideoPlayerControlState.LOADING -> {
                    playerInitView(this)
                }

                VideoPlayerControlState.PLAYING -> {
                    playerPlayingView(this, sliderValue = data.sliderValue)
                }

                VideoPlayerControlState.PLAYING_TAB, VideoPlayerControlState.PAUSED, VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                    Log.i("[VideoPlayer]", "[VideoPlayer]it")
                    playerPlayingTabOrPauseOrCompletedView(this, targetState)
                }

                VideoPlayerControlState.COMPLETED -> {
                    onVideoPlayerCompletedLayer?.let { it ->
                        it(this)
                    }
                }

                else -> {
                    Text(text = "UNKNOW STATE")
                }
            }
        }
    }
}

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Preview(showBackground = true)
@Composable
fun VideoPlayerControlPreview() {
    val testUri =
//        Uri.parse("https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8")
        Uri.parse("https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8")
//        Uri.parse("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8")
    // Define the UI element expanded state
    var item: VideoPlayerControlData = object : VideoPlayerControlData {
        override var playState by remember {
            mutableStateOf(VideoPlayerControlState.PLAYER_INIT)
        }
        override var imageURL: String = "https://placehold.co/390x219/png"
        override var totalTime: String = "22:22"
        override var sliderValue by remember {
            mutableStateOf(0f)
        }
    }
    var seekToPos by remember {
        mutableStateOf(-1f)
    }

    NMGTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding),
        ) {
            VideoPlayerControl(data = item,
                onVideoPlayerLayer = { itBox ->
                    VideoPlayer(uri = testUri, isAutoPlay = true,
                        onStateChange = { itState ->
                            Log.i(
                                "VideoPlayerControl",
                                "[VideoPlayer]VideoPlayer#itState=${itState}"
                            )
                            item.playState = itState
                        },
                        onProgressChange = { pos, duration ->
                            val currentSliderValue =
                                (((pos * 1.0 / duration) * 100).toInt() * 1.0 / 100)
                            Log.i(
                                "VideoPlayerControl",
                                "[VideoPlayer]#onProgressChange#pos=${pos} duration=${duration} #currentSliderValue=${currentSliderValue}"
                            )
                            if (currentSliderValue.toFloat() == item.sliderValue) {
                                return@VideoPlayer
                            }
                            item.sliderValue = currentSliderValue.toFloat()
                        })
                },
                onSwipeProgressChange = {
                    seekToPos = it
                }
                ).view()
        }
    }
}