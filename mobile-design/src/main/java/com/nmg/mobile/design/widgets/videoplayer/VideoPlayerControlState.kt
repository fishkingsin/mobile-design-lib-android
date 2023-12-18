package com.nmg.mobile.design.widgets.videoplayer

import androidx.annotation.DrawableRes
import com.nmg.mobile.design.R

sealed class VideoPlayerControlState(
    @DrawableRes open val icon: Int,
) {
    class LOADING(
        @DrawableRes override val icon: Int = R.drawable.video_player_loading
    ): VideoPlayerControlState(icon = icon)
    class PLAYING(
        @DrawableRes override val icon: Int = R.drawable.video_player_pause
    ): VideoPlayerControlState(icon = icon)
    class PLAYING_TAB(
        @DrawableRes override val icon: Int = R.drawable.video_player_pause
    ): VideoPlayerControlState(icon = icon)
    class PAUSED(
        @DrawableRes override val icon: Int = R.drawable.video_player_play
    ): VideoPlayerControlState(icon = icon)
    class COMPLETED(
        @DrawableRes override val icon: Int = R.drawable.video_player_replay
    ): VideoPlayerControlState(icon = icon)

    class COMPLETED_CANCEL_AUTOPLAY(
        @DrawableRes override val icon: Int = R.drawable.video_player_play
    ): VideoPlayerControlState(icon = icon)
    class ERROR(
        @DrawableRes override val icon: Int = R.drawable.video_player_loading
    ): VideoPlayerControlState(icon = icon)
    class READY(
        @DrawableRes override val icon: Int = R.drawable.video_player_play
    ): VideoPlayerControlState(icon = icon)
}

