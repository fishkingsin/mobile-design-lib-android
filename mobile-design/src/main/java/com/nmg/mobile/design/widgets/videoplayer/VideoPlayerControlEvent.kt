package com.nmg.mobile.design.widgets.videoplayer

import kotlinx.coroutines.Job

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
