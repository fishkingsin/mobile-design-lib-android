package com.nmg.mobile.design.widgets.videoplayer

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable

@Composable
fun VideoPlayerOverlayView(
    boxScope: BoxScope,
    playerControlState: VideoPlayerControlState,
    currentItem: VideoPlayerSourceProtocol,
    ShouldShowUpComingView: @Composable () -> Unit = { }
) {
    when (playerControlState) {
        is VideoPlayerControlState.LOADING -> {
            VideoPlayerControlInitViewYT(boxScope, data = currentItem)
        }

        is VideoPlayerControlState.COMPLETED -> {
            ShouldShowUpComingView()
        }

        else -> {
            // empty
        }
    }
}
