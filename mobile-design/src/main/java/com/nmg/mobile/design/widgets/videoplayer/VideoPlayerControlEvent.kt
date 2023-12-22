package com.nmg.mobile.design.widgets.videoplayer

interface VideoPlayerControlEvent {
    fun onClickBack() {}
    fun onClickPlay() {}
    fun onClickPre() {}
    fun onClickNext() {}
    fun onClickPause() {}
    fun onClickReplay() {}
    fun onClickFullScreen() {}
    fun onClickVideoWhenPlaying() {}
}
