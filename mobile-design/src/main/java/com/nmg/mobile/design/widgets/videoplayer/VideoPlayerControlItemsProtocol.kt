package com.nmg.mobile.design.widgets.videoplayer

import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControlItem

interface VideoPlayerControlItemsProtocol {
    var current: VideoPlayerControlItem?
    var previous: VideoPlayerControlItem?
    var next: VideoPlayerControlItem?
}