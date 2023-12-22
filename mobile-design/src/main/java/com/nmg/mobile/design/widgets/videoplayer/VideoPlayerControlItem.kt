package com.nmg.mobile.design.widgets.videoplayer

import com.nmg.mobile.design.widgets.upcomming.UpcomingItem
import com.nmg.mobile.design.widgets.upcomming.UpcomingItemData

class VideoPlayerControlItem(
    override var title: String = "",
    override var videoURL: String = "",
    override var imageURL: String = "",
    override var totalTime: String = "",
    override var sliderValue: Float = 0f,
    override var videoType: String
) : VideoPlayerControlData

fun VideoPlayerControlItem.toUpComingItem(): UpcomingItem {
    return UpcomingItemData(
        imageURL = this.imageURL,
        headline = this.title,
        timeCode = this.totalTime,
        secCountDown = 10
    )
}
