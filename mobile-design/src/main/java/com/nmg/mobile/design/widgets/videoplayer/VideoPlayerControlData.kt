package com.nmg.mobile.design.widgets.videoplayer

interface VideoPlayerControlData {
    var playState: VideoPlayerControlState
    var videoURL: String
    var title: String
    var imageURL: String
    var totalTime: String
    var sliderValue: Float
}
