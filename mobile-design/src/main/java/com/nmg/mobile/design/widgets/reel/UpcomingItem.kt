package com.nmg.mobile.design.widgets.reel

public interface UpcomingItem {
    var imageURL: String
    var headline: String
    var timeCode: String
    var secCountDown: Int
}

data class UpcomingItemData(
    override var imageURL: String,
    override var headline: String,
    override var timeCode: String,
    override var secCountDown: Int
): UpcomingItem