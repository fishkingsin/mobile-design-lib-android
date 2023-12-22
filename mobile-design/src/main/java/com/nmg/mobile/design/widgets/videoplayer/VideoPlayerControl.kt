package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
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

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayerControl(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    context: Context = LocalContext.current,
    playableItems: VideoPlayerControlItems,
    onClickPlay: (() -> Unit)? = null,
    onClickPlayPrevious: (() -> Unit)? = null,
    onClickPlayNext: (() -> Unit) = { },
    onStateChange: ((VideoPlayerControlState) -> Unit) = {},
    onFullScreenClick: (() -> Unit) = {},
    ShouldShowUpComingView: @Composable () -> Unit = { }
) {
    val tag = "[VideoPlayerControl]"
    val videoURL = playableItems.current?.videoURL ?: ""

    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                playWhenReady = true
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                repeatMode = Player.REPEAT_MODE_OFF
            }
    }
    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    var shouldShowControls by remember { mutableStateOf(false) }
    var totalDuration by remember { mutableStateOf(0L) }
    var currentTime by remember { mutableStateOf(0L) }
    var progressValue: Double by remember { mutableStateOf(0.0) }
    var bufferedPercentage by remember { mutableStateOf(0) }
    var playbackState by remember { mutableStateOf(exoPlayer.playbackState) }
    var playerControlState: VideoPlayerControlState by remember {
        mutableStateOf(
            VideoPlayerControlState.LOADING()
        )
    }

    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            lifecycleEvent = event
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            exoPlayer.release()
        }
    }
    LaunchedEffect(videoURL) {
        Log.i(tag, "update isLoading=$playerControlState")
        val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(context)
        val source = when {
            videoURL.contains(".m3u8") -> {
                HlsMediaSource.Factory(
                    dataSourceFactory
                ).createMediaSource(MediaItem.fromUri(videoURL))
            }

            else -> {
                ProgressiveMediaSource.Factory(
                    dataSourceFactory
                )
                    .createMediaSource(MediaItem.fromUri(videoURL))
            }
        }
        exoPlayer.setMediaSource(source)
        exoPlayer.prepare()
        Log.i(tag, "update videoURL=$videoURL")
    }

    Box(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .size(390.dp, 219.dp)
            .background(Color.Black)
            .clickable(enabled = true, onClick = {
                shouldShowControls = !shouldShowControls
            })
    ) {
        DisposableEffect(Unit) {
            val listener: Player.Listener = object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    super.onPlayerError(error)
                    Log.i(tag, "${tag}onPlayerError")
                    error.printStackTrace()
                    playerControlState = VideoPlayerControlState.ERROR()
                    onStateChange(playerControlState)
                }

                override fun onEvents(player: Player, events: Player.Events) {
                    super.onEvents(player, events)
                    totalDuration = player.duration.coerceAtLeast(0L)
                    currentTime = player.currentPosition.coerceAtLeast(0L)
                    progressValue = if (totalDuration == 0L) {
                        0.0
                    } else {
                        currentTime * 1.0 / totalDuration
                    }
                    bufferedPercentage = player.bufferedPercentage
                    playerControlState = when (player.isPlaying) {
                        true -> VideoPlayerControlState.PLAYING()
                        false -> VideoPlayerControlState.PAUSED()
                    }

                    playbackState = player.playbackState
                    when (playbackState) {
                        ExoPlayer.STATE_IDLE -> {
                            // The player has been instantiated but is not ready yet.
                            Log.i(tag, "${tag}ExoPlayer.STATE_IDLE")
                            playerControlState = VideoPlayerControlState.LOADING()
                            onStateChange(playerControlState)
                        }

                        ExoPlayer.STATE_BUFFERING -> {
                            // The player cannot start playback from the current position
                            // because there is insufficient data buffered
                            Log.i(tag, "${tag}ExoPlayer.STATE_BUFFERING")
                            playerControlState = VideoPlayerControlState.LOADING()
                            onStateChange(playerControlState)
                        }

                        ExoPlayer.STATE_READY -> {
                            // The player can immediately start playing from the current position.
                            // This means that the player will automatically start playing media
                            // if its playWhenReady property is true. If this property is false,
                            // the player will pause playback.
                            Log.i(tag, "${tag}ExoPlayer.STATE_READY")

                            playerControlState = VideoPlayerControlState.READY()
                            onStateChange(playerControlState)
                        }

                        ExoPlayer.STATE_ENDED -> {
                            // The player has completed media playback
                            Log.i(tag, "${tag}ExoPlayer.STATE_ENDED")

//                            playState = VideoPlayerControlState.COMPLETED
                            playerControlState = VideoPlayerControlState.COMPLETED()
                            onStateChange(playerControlState)
                        }

                        ExoPlayer.EVENT_PLAYER_ERROR -> {
                            Log.i(tag, "${tag}ExoPlayer.EVENT_PLAYER_ERROR")
//                            playState = VideoPlayerControlState.ERROR
                            playerControlState = VideoPlayerControlState.ERROR()
                            onStateChange(playerControlState)
                        }

                        else -> {
                            Log.i(tag, "${tag}UNKNOWN_STATE")
                        }
                    }
                }
            }
            exoPlayer.addListener(listener)
            onDispose {
                exoPlayer.removeListener(listener)
                exoPlayer.release()
            }
        }
        AndroidView(factory = {
            PlayerView(context).apply {
                hideController()
                useController = false
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT

                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        })

        val current = playableItems.current
        if (playerControlState is VideoPlayerControlState.LOADING && current != null) {
            VideoPlayerControlInitView(boxScope = this, data = current)
        }
        if (shouldShowControls) {
            ViewPlayerControlUI(
                this,
                state = playerControlState,
                onClickPlayPrevious = onClickPlayPrevious,
                onClickPlay = {
                    when (playerControlState) {
                        VideoPlayerControlState.LOADING() -> {
                            return@ViewPlayerControlUI
                        }
                        VideoPlayerControlState.PLAYING() -> {
                            exoPlayer.pause()
                            onStateChange(VideoPlayerControlState.PAUSED())
                        }

                        else -> {
                            exoPlayer.play()
                            onStateChange(VideoPlayerControlState.PLAYING())
                        }
                    }
                },
                onClickPlayNext = onClickPlayNext,
                onFullScreenClick = onFullScreenClick

            )

            VideoPlayerControlProgressView(
                boxScope = this,
                progressValue = progressValue.toFloat()
            ) {
                exoPlayer.seekTo((totalDuration * it).toLong())
            }
        }

        if (playerControlState is VideoPlayerControlState.COMPLETED) {
            ShouldShowUpComingView()
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
