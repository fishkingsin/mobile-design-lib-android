package com.nmg.mobile.design.widgets.reel

import kotlinx.coroutines.flow.MutableStateFlow

public interface UpcomingItem {
    var imageURL: String
    var headline: String
    var timeCode: String
    var secCountDown: Int
}