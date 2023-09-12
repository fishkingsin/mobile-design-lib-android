package com.nmg.mobile.design.widgets.reel

public interface UpcomingItem {
    var imageURL: String
    var headline: String
    var timeCode: String
    var secCountDown: Int
    var onClickCancel: () -> Unit
    var onClickPlay: () -> Unit
}