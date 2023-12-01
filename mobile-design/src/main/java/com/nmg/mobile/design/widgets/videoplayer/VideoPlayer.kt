package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayer(
    uri: Uri,
    isAutoPlay: Boolean = true,
    seekToPos: Long = -1L,
    onStateChange: ((VideoPlayerControlState) -> Unit)? = null,
    onProgressChange: ((Long, Long) -> Unit)? = null,
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    onClickedPlay: MutableSharedFlow<Unit>? = null,
    onClickedPause: MutableSharedFlow<Unit>? = null,
) {
    var playerState by remember {
        mutableStateOf(VideoPlayerControlState.LOADING)
    }
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
        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
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
                    playerState = VideoPlayerControlState.COMPLETED
                }
                else -> {
                    Log.i(tag, "${tag}UNKNOWN_STATE")
                }
            }
            onStateChange?.let {
                Log.i(tag, "${tag}onStateChange playerState=$playerState")
                it(playerState)
            }
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            onStateChange?.let {
                it(
                    if (isPlaying) {
                        VideoPlayerControlState.PLAYING
                    } else {
                        VideoPlayerControlState.PAUSED
                    }
                )
            }
        }
    })

    LaunchedEffect(onClickedPlay) {
        onClickedPlay?.collect {
            Log.i("VideoPlayer", "onClickedPlay ${onClickedPlay}")
            launch(Dispatchers.Main) {
                exoPlayer.play()
            }
        }
    }
    LaunchedEffect(onClickedPause) {
        onClickedPause?.collect {
            Log.i("VideoPlayer", "onClickedPause ${onClickedPause}")
            launch(Dispatchers.Main) {
                exoPlayer.pause()
            }
        }
    }
//    LaunchedEffect(onClickPlayC) {
//        Log.i("VideoPlayer", "onClickPlayC ${onClickPlayC}")
//        onClickPlayC.collect {it
//            Log.i("VideoPlayer", "onClickPlay collect")
//            exoPlayer.play()
//        }
////        Log.i("VideoPlayer", "onClickPause ${onClickPause}")
//    }
//    LaunchedEffect(onClickPauseC) {
//        Log.i("VideoPlayer", "onClickPauseC ${onClickPauseC}")
//        onClickPauseC.collect {
//            Log.i("VideoPlayer", "onClickPause collect")
//            exoPlayer.pause()
//        }
//    }
//    LaunchedEffect(onClickPlay) {
//        onClickPlayC.emit(onClickPlay)
//    }
//    LaunchedEffect(onClickPause) {
//        onClickPauseC.emit(onClickPause)
//    }
//    LaunchedEffect(true) {
//        Log.i("VideoPlayer", "onClickPause ${onClickPauseC}")
//        onClickPauseC.collect {
//            Log.i("VideoPlayer", "onClickPause collect")
//            exoPlayer.pause()
//        }
//    }
//    LaunchedEffect(onClickPause) {
//        exoPlayer.pause()
//        onClickPause = null
//    }
//    var progressChange by remember {
//        mutableStateOf(0L)
//    }
//    LaunchedEffect(progressChange) {
//        delay(200)
//        onProgressChange?.let {
//            it(exoPlayer.currentPosition, exoPlayer.duration)
//        }
//        progressChange += 1
//    }
//    LaunchedEffect(progressNeedToSeek) {
//        if (seekToPos >= 0) {
//            exoPlayer.seekTo(progressNeedToSeek)
//        }
//        Log.i(TAG, "progressNeedToSeek")
//    }

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
