package com.nmg.mobile.design.widgets.videoplayer

interface VideoPlayerStateListener {
    fun onLoadReady();
    fun onStateChange(state: VideoPlayerControlState);
}