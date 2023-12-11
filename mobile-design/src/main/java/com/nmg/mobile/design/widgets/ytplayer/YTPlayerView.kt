package com.nmg.mobile.design.widgets.ytplayer

import android.view.View
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.*
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YTPlayerView(lifecycleOwner: LifecycleOwner, videoId: String, modifier: Modifier = Modifier, ) {
    var isFullscreen by remember { mutableStateOf(false) }
    var youTubePlayerView by remember { mutableStateOf<YouTubePlayerView?>(null) }
    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
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

                        // the video will continue playing in fullscreenView
//                        playerUiContainer.visibility = View.GONE
//                        fullscreenViewContainer.visibility = View.VISIBLE
//                        fullscreenViewContainer.addView(fullscreenView)
//
//                        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//                            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
//                        }
                    }

                    override fun onExitFullscreen() {
                        isFullscreen = false

//                        // the video will continue playing in the player
//                        playerUiContainer.visibility = View.VISIBLE
//                        fullscreenViewContainer.visibility = View.GONE
//                        fullscreenViewContainer.removeAllViews()
//
//                        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_SENSOR) {
//                            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT
//                            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
//                        }
                    }
                })

                val youTubePlayerListener = object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadOrCueVideo(lifecycleOwner.lifecycle, videoId, 0f)
//                        setPlayNextVideoButtonClickListener(youTubePlayer)
//                        setPlaybackSpeedButtonsClickListeners(youTubePlayer)
                    }

                    override fun onPlaybackRateChange(
                        youTubePlayer: YouTubePlayer,
                        playbackRate: PlayerConstants.PlaybackRate
                    ) {
//                        playbackSpeedTextView.text = "Playback speed: $playbackRate"
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
}


@Preview(showBackground = true)
@Composable
fun YTPlayerViewPreview() {
    YTPlayerView(
        lifecycleOwner = LocalLifecycleOwner.current,
        videoId = "https://www.youtube.com/watch?v=y5QW38jqPCI"
    )
}