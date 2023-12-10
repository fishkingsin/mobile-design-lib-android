package com.nmg.mobile.design.widgets.videoplayer

class VideoPlayerControlItem(
    override var playState: VideoPlayerControlState = VideoPlayerControlState.LOADING,
    override var title: String = "",
    override var videoURL: String = "",
    override var imageURL: String = "",
    override var totalTime: String = "",
    override var sliderValue: Float = 0f
) : VideoPlayerControlData {
}