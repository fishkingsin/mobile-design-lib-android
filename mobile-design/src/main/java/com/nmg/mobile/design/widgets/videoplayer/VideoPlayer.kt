package com.nmg.mobile.design.widgets.videoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
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
import kotlinx.coroutines.isActive

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
public fun VideoPlayer(
    uri: Uri,
    isAutoPlay: Boolean = true,
    seekToPos: Long = -1L,
    onStateChange: ((VideoPlayerControlState) -> Unit)? = null,
    onProgressChange: ((Long, Long) -> Unit)? = null,
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier
) {
    val TAG = "[VideoPlayer]"
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
            Log.i(TAG, "${TAG}onPlayerError error=${error}")
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
            var playerState = VideoPlayerControlState.PLAYER_IDLE
            when (playbackState) {
                ExoPlayer.STATE_IDLE -> {
                    //播放器已实例化，但尚未准备就绪。
                    Log.i(TAG, "${TAG}ExoPlayer.STATE_IDLE")
                    playerState = VideoPlayerControlState.PLAYER_IDLE
                }
                ExoPlayer.STATE_BUFFERING -> {
                    //播放器无法从当前位置开始播放，因为已缓冲的数据不足。
                    Log.i(TAG, "${TAG}ExoPlayer.STATE_BUFFERING")
//                    playerState =  VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY
                }
                ExoPlayer.STATE_READY -> {
                    //播放器可以立即从当前位置开始播放。这意味着如果播放器的 playWhenReady 属性为 true，播放器将自动开始播放媒体。如果该属性为 false，播放器会暂停播放。
                    Log.i(TAG, "${TAG}ExoPlayer.STATE_READY")
                    playerState =  VideoPlayerControlState.PLAY_READY
                }
                ExoPlayer.STATE_ENDED -> {
                    //播放器已完成媒体播放。
                    Log.i(TAG, "${TAG}ExoPlayer.STATE_ENDED")
                    playerState =  VideoPlayerControlState.COMPLETED
                }
                else -> {
                    Log.i(TAG, "${TAG}UNKNOWN_STATE")
                }
            }
            onStateChange?.let {
                Log.i(TAG, "${TAG}onStateChange playerState=${playerState}")
                it(playerState)
            }
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            onStateChange?.let {
                it(if (isPlaying) {
                    VideoPlayerControlState.PLAYING
                } else {
                    VideoPlayerControlState.PAUSED
                })
            }
        }
    })
    exoPlayer.seekTo(1000)
    var progressChange by remember {
        mutableStateOf(0L)
    }
    var progressNeedToSeek by remember {
        mutableStateOf(seekToPos)
    }
    LaunchedEffect(progressChange) {
        delay(200)
        onProgressChange?.let {
            it(exoPlayer.currentPosition, exoPlayer.duration)
        }
        progressChange += 1
    }
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