package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YoutubeHelperExampleView() {
    // Adds view to Compose
    Column {
        AndroidView(
            modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
            factory = { context ->
                // Creates view
                YouTubePlayerView(context).apply {
                    // Add logic here if necessary
                    this.addYouTubePlayerListener(
                        object : YouTubePlayerListener {
                            override fun onReady(youTubePlayer: YouTubePlayer) {
                                // Add logic here if necessary
                                youTubePlayer.loadVideo("6JYIGclVQdw", 0f)
                            }

                            override fun onApiChange(youTubePlayer: YouTubePlayer) {
                                // Add logic here if necessary
                                println("onApiChange")
                            }

                            override fun onCurrentSecond(
                                youTubePlayer: YouTubePlayer,
                                second: Float,
                            ) {
                                println("onCurrentSecond $second")
                            }

                            override fun onError(
                                youTubePlayer: YouTubePlayer,
                                error: PlayerConstants.PlayerError,
                            ) {
                                println("onError $error")
                            }

                            override fun onPlaybackQualityChange(
                                youTubePlayer: YouTubePlayer,
                                playbackQuality: PlayerConstants.PlaybackQuality,
                            ) {
                                println("onPlaybackQualityChange $playbackQuality")
                            }

                            override fun onPlaybackRateChange(
                                youTubePlayer: YouTubePlayer,
                                playbackRate: PlayerConstants.PlaybackRate,
                            ) {
                                println("onPlaybackRateChange $playbackRate")
                            }

                            override fun onStateChange(
                                youTubePlayer: YouTubePlayer,
                                state: PlayerConstants.PlayerState,
                            ) {
                                println("onStateChange $state")
                            }

                            override fun onVideoDuration(
                                youTubePlayer: YouTubePlayer,
                                duration: Float,
                            ) {
                                println("onVideoDuration $duration")
                            }

                            override fun onVideoId(
                                youTubePlayer: YouTubePlayer,
                                videoId: String,
                            ) {
                                println("onVideoId $videoId")
                            }

                            override fun onVideoLoadedFraction(
                                youTubePlayer: YouTubePlayer,
                                loadedFraction: Float,
                            ) {
                                print("onVideoLoadedFraction $loadedFraction")
                            }
                        },
                    )
                }
            },
            update = { view ->
                // View's been inflated or state read in this block has been updated
                // Add logic here if necessary

                // As selectedItem is read here, AndroidView will recompose
                // whenever the state changes
                // Example of Compose -> View communication
            },
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun YoutubeHelperExampleView_Preview() {
    YoutubeHelperExampleView()
}
