package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.widgets.reel.UpcomingItem
import com.nmg.mobile.design.widgets.reel.UpcomingVideoView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.coroutines.Job


@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayerControlYT(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    context: Context = LocalContext.current,
    currentItem: VideoPlayerControlData,
    preItem: VideoPlayerControlData? = null,
    nextItem: VideoPlayerControlData? = null,
    upcomingItem: UpcomingItem? = null,
    onClickPlay: (() -> Unit)? = null,
    onClickPlayPre: (() -> Unit)? = null,
    onClickPlayNext: (() -> Unit)? = null,
    secCountDown: Int = 10,
    autoPlayNext: (() -> Job)? = null,
    onStateChange: ((VideoPlayerControlState) -> Unit) = {}
) {
    val tag = "[VideoPlayerControlYT]"
    val videoURL = currentItem.videoURL

    var isFullscreen by remember { mutableStateOf(false) }
    var youTubePlayerView by remember { mutableStateOf<YouTubePlayerView?>(null) }
    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }

    var shouldShowControls by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    var isPlaying by remember { mutableStateOf(false) }
//    var totalDuration by remember { mutableStateOf(0L) }
//    var currentTime by remember { mutableStateOf(0L) }
    var bufferedPercentage by remember { mutableStateOf(0) }
//    var playbackState by remember { mutableStateOf(exoPlayer.playbackState) }
//    var playState by remember { mutableStateOf(VideoPlayerControlState.LOADING) }
    var hasPreviousMediaItem by remember { mutableStateOf(preItem != null) }
    var hasNextMediaItem by remember { mutableStateOf(nextItem != null) }
    var isPlayToEnd by remember {
        mutableStateOf(false)
    }

    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            lifecycleEvent = event
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            youTubePlayerView?.let { lifecycleOwner.lifecycle.removeObserver(it) }
        }
    }

    Box(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .size(390.dp, 219.dp)
            .background(Color.Black)
    ) {
        // Adds view to Compose
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                // Creates view
                YouTubePlayerView(context).apply {
                    youTubePlayerView = this
                    // Add logic here if necessary
                    lifecycleOwner.lifecycle.addObserver(this)

                    this.addFullscreenListener(object : FullscreenListener {

                        override fun onEnterFullscreen(
                            fullscreenView: View,
                            exitFullscreen: () -> Unit
                        ) {
                            isFullscreen = true
                        }

                        override fun onExitFullscreen() {
                            isFullscreen = false
                        }
                    })

                    val youTubePlayerListener = object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            youTubePlayer.loadOrCueVideo(lifecycleOwner.lifecycle, videoURL, 0f)
                            onStateChange(VideoPlayerControlState.READY)
                            val uri = Uri.parse(videoURL)
                            val videoId = uri.getQueryParameter("v")
                            videoId?.let {
                                Log.i(tag, "videoId=${videoId}")
                                youTubePlayer.loadOrCueVideo(lifecycleOwner.lifecycle, videoId, 0f)
                            }
                        }

                        override fun onPlaybackRateChange(
                            youTubePlayer: YouTubePlayer,
                            playbackRate: PlayerConstants.PlaybackRate
                        ) {
//                        playbackSpeedTextView.text = "Playback speed: $playbackRate"
                        }

                        override fun onStateChange(
                            youTubePlayer: YouTubePlayer,
                            state: PlayerConstants.PlayerState
                        ) {
                            super.onStateChange(youTubePlayer, state)
                            when(state) {
                                PlayerConstants.PlayerState.PLAYING -> {
                                    isPlaying = true
                                    isLoading = false
                                    onStateChange(VideoPlayerControlState.PLAYING)
                                }
                                PlayerConstants.PlayerState.PAUSED -> {
                                    isPlaying = false
                                    onStateChange(VideoPlayerControlState.PAUSED)
                                }
                                PlayerConstants.PlayerState.ENDED -> {
                                    isPlaying = false
                                    isLoading = false
                                    onStateChange(VideoPlayerControlState.COMPLETED)
                                }
                                else -> {
                                    // do nothing
                                }
                            }
                        }
                    }

                    val iFramePlayerOptions = IFramePlayerOptions.Builder()
                        .controls(1)
                        .fullscreen(1) // enable full screen button
                        .build()

                    this.enableAutomaticInitialization = false
                    this.initialize(youTubePlayerListener, iFramePlayerOptions)
                }
            },
            update = { view ->
                // View's been inflated or state read in this block has been updated
                // Add logic here if necessary

                // As selectedItem is read here, AndroidView will recompose
                // whenever the state changes
                // Example of Compose -> View communication
            }
        )
        if (!isPlayToEnd) {
            if (isLoading) {
                VideoPlayerControlInitViewYT(boxScope = this, data = currentItem)
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
fun VideoPlayerControlInitViewYT(boxScope: BoxScope, data: VideoPlayerControlData) {
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