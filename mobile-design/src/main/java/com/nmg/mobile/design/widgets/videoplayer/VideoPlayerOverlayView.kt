package com.nmg.mobile.design.widgets.videoplayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun VideoPlayerOverlayView(
    boxScope: BoxScope,
    playerControlState: VideoPlayerControlState,
    currentItem: VideoPlayerControlData,
    ShouldShowUpComingView: @Composable () -> Unit = { }
) {
    when (playerControlState.javaClass) {
        VideoPlayerControlState.LOADING::class.java -> {
            VideoPlayerControlInitViewYT(boxScope, data = currentItem)
        }
        VideoPlayerControlState.COMPLETED::class.java -> {
            ShouldShowUpComingView()
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}