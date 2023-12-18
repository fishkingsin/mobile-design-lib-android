package com.nmg.mobile.design.widgets.videoplayer

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
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
import com.nmg.mobile.design.widgets.reel.UpcomingItem
import com.nmg.mobile.design.widgets.reel.UpcomingVideoView
import kotlinx.coroutines.Job

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayerControl(
    context: Context = LocalContext.current,
    activity: Activity? = null,
    currentItem: VideoPlayerControlData,
    preItem: VideoPlayerControlData? = null,
    nextItem: VideoPlayerControlData? = null,
    upcomingItem: UpcomingItem? = null,
    onClickPlay: (() -> Unit)? = null,
    onClickPlayPre: (() -> Unit)? = null,
    onClickPlayNext: (() -> Unit) = { },
    secCountDown: Int = 10,
    autoPlayNext: (() -> Job)? = null,
//    onStateChange: ((VideoPlayerControlState) -> Unit) = {}
) {
    val tag = "[VideoPlayerControl]"
    val videoURL = currentItem.videoURL

    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                playWhenReady = true
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                repeatMode = Player.REPEAT_MODE_OFF
            }
    }
//    Log.i(tag, "videoURL=${videoURL}")
//    Log.i(tag, "currentItem.videoURL=${currentItem.videoURL}")
//    Log.i(
//        tag,
//        "currentItem.videoURL=${exoPlayer.currentMediaItem?.localConfiguration?.uri.toString()}"
//    )

    var shouldShowControls by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    var isPlaying by remember { mutableStateOf(exoPlayer.isPlaying) }
    var totalDuration by remember { mutableStateOf(0L) }
    var currentTime by remember { mutableStateOf(0L) }
    var progressValue: Double by remember { mutableStateOf(0.0) }
    var bufferedPercentage by remember { mutableStateOf(0) }
    var playbackState by remember { mutableStateOf(exoPlayer.playbackState) }
//    var playState by remember { mutableStateOf(VideoPlayerControlState.LOADING) }
    var hasPreviousMediaItem by remember { mutableStateOf(preItem != null) }
    var hasNextMediaItem by remember { mutableStateOf(nextItem != null) }
    var isPlayToEnd by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(videoURL) {
        Log.i(tag, "update isLoading=${isLoading}")
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
        Log.i(tag, "update videoURL=${videoURL}")
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
                    autoPlayNext?.let {
                        Log.i(tag, "${tag}error autoPlayNext")
                        it()
                    }
                }

                override fun onEvents(
                    player: Player,
                    events: Player.Events
                ) {
                    super.onEvents(player, events)
                    totalDuration = player.duration.coerceAtLeast(0L)
                    currentTime = player.currentPosition.coerceAtLeast(0L)
                    progressValue = if (totalDuration == 0L) {
                        0.0
                    } else {
                        currentTime * 1.0 / totalDuration
                    }
                    bufferedPercentage = player.bufferedPercentage
                    isPlaying = player.isPlaying
                    playbackState = player.playbackState
                    when (playbackState) {
                        ExoPlayer.STATE_IDLE -> {
                            // The player has been instantiated but is not ready yet.
                            Log.i(tag, "${tag}ExoPlayer.STATE_IDLE")
//                            onStateChange(VideoPlayerControlState.LOADING)
                        }

                        ExoPlayer.STATE_BUFFERING -> {
                            // The player cannot start playback from the current position
                            // because there is insufficient data buffered
                            Log.i(tag, "${tag}ExoPlayer.STATE_BUFFERING")
//                            onStateChange(VideoPlayerControlState.LOADING)
                        }

                        ExoPlayer.STATE_READY -> {
                            // The player can immediately start playing from the current position.
                            // This means that the player will automatically start playing media
                            // if its playWhenReady property is true. If this property is false,
                            // the player will pause playback.
                            Log.i(tag, "${tag}ExoPlayer.STATE_READY")
                            isLoading = false
//                            playState = VideoPlayerControlState.PLAYING
//                            onStateChange(VideoPlayerControlState.READY)
                        }

                        ExoPlayer.STATE_ENDED -> {
                            // The player has completed media playback
                            Log.i(tag, "${tag}ExoPlayer.STATE_ENDED")
                            isPlayToEnd = true
//                            playState = VideoPlayerControlState.COMPLETED
                            autoPlayNext?.let {
                                Log.i(tag, "${tag}autoPlayNext")
                                it()
                            }
//                            onStateChange(VideoPlayerControlState.COMPLETED)
                        }

                        ExoPlayer.EVENT_PLAYER_ERROR -> {
                            Log.i(tag, "${tag}ExoPlayer.EVENT_PLAYER_ERROR")
//                            playState = VideoPlayerControlState.ERROR
                            autoPlayNext?.let {
                                Log.i(tag, "${tag}autoPlayNext")
                                it()
                            }
//                            onStateChange(VideoPlayerControlState.ERROR)
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
        if (!isPlayToEnd) {
            if (isLoading) {
                VideoPlayerControlInitView(boxScope = this, data = currentItem)
            }
            if (shouldShowControls) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (hasPreviousMediaItem) {
                        IconButton(onClick = { onClickPlayPre?.let { it() } }) {
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
                    IconButton(onClick = {
                        if (isLoading) {
                            return@IconButton
                        }
                        if (isPlaying) {
                            exoPlayer.pause()
//                            onStateChange(VideoPlayerControlState.PAUSED)
                        } else {
                            exoPlayer.play()
//                            onStateChange(VideoPlayerControlState.PLAYING)
                        }
                    }) {
                        val painter = if (isLoading) {
                            painterResource(id = R.drawable.video_player_loading)
                        } else if (isPlaying) {
                            painterResource(id = R.drawable.video_player_pause)
                        } else {
                            painterResource(id = R.drawable.video_player_play)
                        }
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painter,
                            contentDescription = ""
                        )

//                    painter = painterResource(id = R.drawable.video_player_replay),
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    if (hasNextMediaItem) {
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
                        activity?.let {
                            if (it.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                                it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                            } else {
                                it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                            }
                        }
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

                VideoPlayerControlPlayingView(
                    boxScope = this,
                    progressValue = progressValue.toFloat()
                )
            }
        } else {
            upcomingItem?.let {
                UpcomingVideoView(
                    item = upcomingItem,
                    onClickCancel = null,
                    onClickPlay = {
                        Log.i("VideoPlayerControl", "UpcomingVideoView#onClickPlay")
                        onClickPlay?.let { it() }
                    },
                    secCountDown = secCountDown
                )
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