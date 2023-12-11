package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource.Factory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.delay

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayer(
    uri: Uri,
    isAutoPlay: Boolean = true,
    onStateChange: (playState: VideoPlayerControlState) -> Unit = { println("callBack") },
    onProgressChange: ((Long, Long) -> Unit)? = null,
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
) {

    val tag = "[VideoPlayer]"
    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val dataSourceFactory: DataSource.Factory = Factory(
                    context

                )

                val source = with(uri.path) {
                    when {
                        this?.contains(".m3u8") == true -> {
                            HlsMediaSource.Factory(
                                dataSourceFactory
                            ).createMediaSource(MediaItem.fromUri(uri))
                        }
                        else -> {
                            ProgressiveMediaSource.Factory(dataSourceFactory)
                                .createMediaSource(MediaItem.fromUri(uri))
                        }
                    }
                }

                this.setMediaSource(source)
                this.prepare()
            }
    }

    exoPlayer.playWhenReady = isAutoPlay
    exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
    exoPlayer.addListener(object : Player.Listener {
        override fun onPositionDiscontinuity(reason: Int) {
            super.onPositionDiscontinuity(reason)
            val currentWindowIndex: Int = exoPlayer.getCurrentWindowIndex()
            val currentPositionMs: Long = exoPlayer.getCurrentPosition()
            Log.d(
                tag,
                "onPositionDiscontinuity: currentWindowIndex=" + currentWindowIndex +
                        ", currentPositionMs=" + currentPositionMs
            )
        }

        override fun onPositionDiscontinuity(
            oldPosition: Player.PositionInfo,
            newPosition: Player.PositionInfo,
            reason: Int
        ) {
            super.onPositionDiscontinuity(oldPosition, newPosition, reason)
            val currentWindowIndex: Int = exoPlayer.getCurrentWindowIndex()
            val currentPositionMs: Long = exoPlayer.getCurrentPosition()
            Log.d(
                tag,
                "onPositionDiscontinuity: currentWindowIndex=" + currentWindowIndex +
                        ", currentPositionMs=" + currentPositionMs
            )
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
            error.printStackTrace()
            Log.i(tag, "${tag}onPlayerError error=$error")
        }
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
//            Log.i(TAG, "${TAG}onIsLoadingChanged#isLoading=${isLoading}")
//            if (!isLoading) {
//                return
//            }
//            onStateChange?.let {
//                it(VideoPlayerControlState.LOADING)
//            }
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
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
                }
                ExoPlayer.STATE_ENDED -> {
                    // The player has completed media playback
                    Log.i(tag, "${tag}ExoPlayer.STATE_ENDED")
                }
                else -> {
                    Log.i(tag, "${tag}UNKNOWN_STATE")
                }
            }
            Log.i(tag, "${tag}playbackState=$playbackState")
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
        }
    })

    LaunchedEffect(Unit) {
        while (true) {
            Log.i(
                "VideoPlayer",
                "currentPosition ${exoPlayer.currentPosition} exoPlayer.contentPosition=${exoPlayer.contentPosition} ${exoPlayer.duration}"
            )
            delay(1000)
            onProgressChange?.let {
                it(exoPlayer.currentPosition, exoPlayer.duration)
            }
        }
    }
    DisposableEffect(
        AndroidView(factory = {
            PlayerView(context).apply {
                hideController()
                useController = false
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT

                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            }
        }, modifier = modifier)
    ) {
        onDispose { exoPlayer.release() }
    }
}
