package com.nmg.mobile.design.widgets.videoplayer

interface VideoPlayerControlEvent {
    fun onClickBack(): Unit {}
    fun onClickPlay(): Unit {}
    fun onClickPre(): Unit {}
    fun onClickNext(): Unit {}
    fun onClickPause(): Unit {}
    fun onClickReplay(): Unit {}
    fun onClickFullScreen(): Unit {}
}