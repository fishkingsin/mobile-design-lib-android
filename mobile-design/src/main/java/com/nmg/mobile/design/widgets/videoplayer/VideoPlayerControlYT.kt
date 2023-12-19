package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun VideoPlayerControlYT(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    context: Context = LocalContext.current,
    currentItem: VideoPlayerControlData,
    onStateChange: ((VideoPlayerControlState) -> Unit) = {},
    ShouldShowUpComingView: @Composable () -> Unit = { }
) {
    val tag = "[VideoPlayerControlYT]"
    var videoURL: String? by remember {
        mutableStateOf(null)
    }

    var youTubePlayerView by remember { mutableStateOf<YouTubePlayerView?>(null) }
    var _youTubePlayer by remember { mutableStateOf<YouTubePlayer?>(null) }
    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }

    var playerControlState: VideoPlayerControlState by remember {
        mutableStateOf(VideoPlayerControlState.LOADING())
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
                            Log.d(tag, "onEnterFullscreen")
                        }

                        override fun onExitFullscreen() {
                            Log.d(tag, "onExitFullscreen")
                        }
                    })

                    val youTubePlayerListener = object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            Log.d(tag, "onReady videoURL=${currentItem.videoURL}")
                            // fresh start
                            videoURL = currentItem.videoURL
                            _youTubePlayer = youTubePlayer
                            playerControlState = VideoPlayerControlState.READY()
                            onStateChange(playerControlState)
                            loadYoutubeVideo(
                                lifecycleOwner.lifecycle,
                                _youTubePlayer,
                                currentItem.videoURL
                            )
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
                            Log.i(tag, "${tag} onStateChange $state")
                            when(state) {
                                PlayerConstants.PlayerState.PLAYING -> {
                                    playerControlState = VideoPlayerControlState.PLAYING()
                                    onStateChange(playerControlState)
                                }
                                PlayerConstants.PlayerState.PAUSED -> {
                                    playerControlState = VideoPlayerControlState.PAUSED()
                                    onStateChange(playerControlState)
                                }
                                PlayerConstants.PlayerState.ENDED -> {
                                    playerControlState = VideoPlayerControlState.COMPLETED()
                                    onStateChange(playerControlState)
                                }
                                else -> {
                                    // do nothing
                                }
                            }
                        }
                    }

                    val iFramePlayerOptions = IFramePlayerOptions.Builder()
                        .controls(1)
                        .fullscreen(0) // enable full screen button
                        .autoplay(1)
                        .build()

                    this.enableAutomaticInitialization = false
                    this.initialize(youTubePlayerListener, iFramePlayerOptions)
                }
            },
            update = { view ->
                if (currentItem.videoURL != videoURL) {
                    // continue on next 
                    Log.d(tag, "update videoURL=${currentItem.videoURL}")
                    videoURL = currentItem.videoURL
                    loadYoutubeVideo(lifecycleOwner.lifecycle, _youTubePlayer, currentItem.videoURL)

                }
                // View's been inflated or state read in this block has been updated
                // Add logic here if necessary

                // As selectedItem is read here, AndroidView will recompose
                // whenever the state changes
                // Example of Compose -> View communication
            }
        )
        VideoPlayerOverlayView(this, playerControlState, currentItem, ShouldShowUpComingView)
    }



}

private fun loadYoutubeVideo(lifecycle: Lifecycle, youTubePlayer: YouTubePlayer?, videoURL: String) {
    val uri = Uri.parse(videoURL)
    val videoId = uri.getQueryParameter("v")
    videoId?.let {
        youTubePlayer?.loadOrCueVideo(
            lifecycle = lifecycle,
            videoId = it,
            startSeconds = 0f
        )
    }
}
