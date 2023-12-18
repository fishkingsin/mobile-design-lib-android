package com.nmg.mobile.design.widgets.videoplayer

data class VideoPlayerControlItems(
    override var current: VideoPlayerControlItem?,
    override var previous: VideoPlayerControlItem?,
    override var next: VideoPlayerControlItem?,
) : VideoPlayerControlItemsProtocol