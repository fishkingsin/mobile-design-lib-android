package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.UpcomingItem
import com.nmg.mobile.design.widgets.reel.UpcomingVideoView

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayerControl(
    context: Context = LocalContext.current,
    currentItem: VideoPlayerControlData,
    preItem: VideoPlayerControlData? = null,
    nextItem: VideoPlayerControlData? = null,
    upcomingItem: UpcomingItem? = null,
    onClickPlay: (() -> Unit)? = null,
) {
    val tag = "[VideoPlayerControl]"

    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(context)

                val source = with(currentItem.videoURL) {
                    when {
                        this?.contains(".m3u8") == true -> {
                            HlsMediaSource.Factory(
                                dataSourceFactory
                            ).createMediaSource(MediaItem.fromUri(currentItem.videoURL))
                        }
                        else -> {
                            ProgressiveMediaSource.Factory(
                                dataSourceFactory
                            )
                                .createMediaSource(MediaItem.fromUri(currentItem.videoURL))
                        }
                    }
                }

                this.setMediaSource(source)
                this.prepare()

                playWhenReady = true
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                repeatMode = Player.REPEAT_MODE_ONE
            }
    }

    var shouldShowControls by remember { mutableStateOf(false) }
    var isPlaying by remember { mutableStateOf(exoPlayer.isPlaying) }
    var totalDuration by remember { mutableStateOf(0L) }
    var currentTime by remember { mutableStateOf(0L) }
    var bufferedPercentage by remember { mutableStateOf(0) }
    var playbackState by remember { mutableStateOf(exoPlayer.playbackState) }
    var playState by remember { mutableStateOf(VideoPlayerControlState.LOADING) }
    var hasPreviousMediaItem by remember { mutableStateOf(preItem != null) }
    var hasNextMediaItem by remember { mutableStateOf(nextItem != null) }

    Box(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .size(390.dp, 219.dp)
            .background(Color.Black)
            .clickable(enabled = true, onClick = {
                if (isPlaying) {
                    playState = VideoPlayerControlState.PLAYING_TAB
                }
            })
    ) {
        DisposableEffect(Unit) {
            val listener : Player.Listener = object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    super.onPlayerError(error)
                    error.printStackTrace()
                    playState = VideoPlayerControlState.ERROR
//                    Log.i(tag, "playState= ${playState} error ${error}")
                }

                override fun onEvents(
                    player: Player,
                    events: Player.Events
                ) {
                    super.onEvents(player, events)
                    totalDuration = player.duration.coerceAtLeast(0L)
                    currentTime = player.currentPosition.coerceAtLeast(0L)
                    bufferedPercentage = player.bufferedPercentage
                    isPlaying = player.isPlaying
                    playbackState = player.playbackState
                    when (playbackState) {
                        ExoPlayer.STATE_IDLE -> {
                            // The player has been instantiated but is not ready yet.
                            Log.i(tag, "${tag}ExoPlayer.STATE_IDLE")
                        }
                        ExoPlayer.STATE_BUFFERING -> {
                            // The player cannot start playback from the current position
                            // because there is insufficient data buffered
                            Log.i(tag, "${tag}ExoPlayer.STATE_BUFFERING")
                        }
                        ExoPlayer.STATE_READY -> {
                            // The player can immediately start playing from the current position.
                            // This means that the player will automatically start playing media
                            // if its playWhenReady property is true. If this property is false,
                            // the player will pause playback.
                            Log.i(tag, "${tag}ExoPlayer.STATE_READY")
                            playState = VideoPlayerControlState.PLAYING
                        }
                        ExoPlayer.STATE_ENDED -> {
                            // The player has completed media playback
                            Log.i(tag, "${tag}ExoPlayer.STATE_ENDED")
                            playState = VideoPlayerControlState.COMPLETED
                        }
                        ExoPlayer.EVENT_PLAYER_ERROR -> {
                            Log.i(tag, "${tag}ExoPlayer.EVENT_PLAYER_ERROR")
                            playState = VideoPlayerControlState.ERROR
                        }
                        else -> {
                            Log.i(tag, "${tag}UNKNOWN_STATE")
                        }
                    }
                }
            }
            exoPlayer.addListener(listener)
            onDispose { exoPlayer.release() }
        }
        AndroidView(factory = {
            PlayerView(context).apply {
                hideController()
                useController = false
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT

                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
        })
        when (playState) {
            VideoPlayerControlState.LOADING -> {
                VideoPlayerControlInitView(boxScope = this, data = currentItem)
            }

            VideoPlayerControlState.PLAYING -> {
                val progressValue = currentTime * 1.0 / totalDuration
                VideoPlayerControlPlayingView(
                    boxScope = this,
                    progressValue = progressValue.toFloat()
                )
            }

            VideoPlayerControlState.PLAYING_TAB, VideoPlayerControlState.PAUSED, VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                VideoPlayerControlPlayingTabOrPauseOrCompletedView(
                    boxScope = this,
                    videoPlayerControlState = playState,
                    //https://gist.github.com/rubenquadros/f2af69972984b13273edd01825c5695e
                    onClickPlay = {
                        exoPlayer.play()
                        playState = VideoPlayerControlState.PLAYING
                    },
                    onClickPause = {
                        exoPlayer.pause()
                        playState = VideoPlayerControlState.PAUSED
                    },
                    hasNextMediaItem = hasNextMediaItem,
                    hasPreviousMediaItem = hasPreviousMediaItem,
                )
                val progressValue = exoPlayer.currentPosition * 1.0 / exoPlayer.duration
                VideoPlayerControlPlayingView(
                    boxScope = this,
                    progressValue = progressValue.toFloat()
                )
            }

            VideoPlayerControlState.COMPLETED -> {
                upcomingItem?.let {
                    UpcomingVideoView(
                        item = upcomingItem,
                        onClickCancel = null,
                        onClickPlay = {
                            Log.i("VideoPlayerControl", "UpcomingVideoView#onClickPlay")
                            onClickPlay?.let { it() }
                        },
                    )
                }
            }
            VideoPlayerControlState.ERROR -> {
                upcomingItem?.let {
                    UpcomingVideoView(
                        item = upcomingItem,
                        onClickCancel = null,
                        onClickPlay = {
                            onClickPlay?.let { it() }
                        },
                    )
                }
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "UNKNOWN STATE")
                }
            }
        }
    }
}

@Composable
fun VideoPlayerControlInitView(boxScope: BoxScope, data: VideoPlayerControlData) {
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
            IconButton(enabled = false, onClick = {}) {
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
fun VideoPlayerControlPlayingView(boxScope: BoxScope, progressValue: Float) {
    Log.i("progress", "VideoPlayerControlPlayingView#sliderValue ${progressValue}")
    boxScope.apply {
        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .align(Alignment.BottomCenter),
            value = progressValue,
            onValueChange = { itValue ->
                Log.i("progress", "onValueChange#itValue ${itValue}")
            },
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
                Log.i("progress", "onValueChangeFinished")

            },
            colors = SliderDefaults.colors(
                thumbColor = NMGTheme.colors.primaryMain,
                activeTrackColor = NMGTheme.colors.primaryMain,
                inactiveTrackColor = Color.White
            )
        )
    }
}

@Composable
fun VideoPlayerControlPlayingTabOrPauseOrCompletedView(
    boxScope: BoxScope,
    videoPlayerControlState: VideoPlayerControlState,
    hasPreviousMediaItem: Boolean,
    hasNextMediaItem: Boolean,
    onClickPrevious: (() -> Unit)? = null,
    onClickPlay: (() -> Unit)? = null,
    onClickPause: (() -> Unit)? = null,
    onClickReplay: (() -> Unit)? = null,
) {
    boxScope.apply {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (hasPreviousMediaItem) {
                IconButton(onClick = { onClickPrevious?.let { it() } }) {
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
                when (videoPlayerControlState) {
                    VideoPlayerControlState.PLAYING_TAB -> {
                        onClickPause?.let { it() }
                    }
                    VideoPlayerControlState.PAUSED -> {
                        onClickPlay?.let { it() }
                    }
                    VideoPlayerControlState.COMPLETED -> onClickReplay?.let { it() }
                    else -> {
                        // pass
                    }
                }
            }) {
                when (videoPlayerControlState) {
                    VideoPlayerControlState.PLAYING_TAB -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_pause),
                            contentDescription = ""
                        )
                    }

                    VideoPlayerControlState.PAUSED -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_play),
                            contentDescription = ""
                        )
                    }

                    VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_replay),
                            contentDescription = ""
                        )
                    }

                    else -> {}
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            if (hasNextMediaItem) {
                IconButton(onClick = { }) {
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

        if (VideoPlayerControlState.PAUSED == videoPlayerControlState ||
            VideoPlayerControlState.PLAYING == videoPlayerControlState ||
            VideoPlayerControlState.PLAYING_TAB == videoPlayerControlState
        ) {
            IconButton(
                onClick = {  },
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
}

@Preview(showBackground = true)
@Composable
fun VideoPlayerControlPreview() {
    // Define the UI element expanded state
//    var item: VideoPlayerControlData = object : VideoPlayerControlData {
//        override var playState = VideoPlayerControlState.LOADING
//        override var imageURL: String = "https://placehold.co/390x219/png"
//        override var totalTime: String = "22:22"
//        override var sliderValue by remember {
//            mutableStateOf(0f)
//        }
//    }
//    val videoUrl = "https://cdn.theoplayer.com/video/big_buck_bunny/big_buck_bunny.m3u8"
//
//    NMGTheme {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding)
//        ) {
//            VideoPlayerControl(
//                data = item,
//                videoUrl = videoUrl
//            )
//        }
//    }
}