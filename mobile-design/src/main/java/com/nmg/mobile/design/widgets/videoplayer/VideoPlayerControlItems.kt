package com.nmg.mobile.design.widgets.videoplayer

data class VideoPlayerControlItems(
    override var current: VideoPlayerSource?,
    override var previous: VideoPlayerSource?,
    override var next: VideoPlayerSource?
) : VideoPlayerControlItemsProtocol
