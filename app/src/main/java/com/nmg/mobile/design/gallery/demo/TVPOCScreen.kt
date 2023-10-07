package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import com.nmg.mobile.design.widgets.ytplayer.YTPlayerView

@Composable
fun TVPOCScreen() {
    TVPOC("kXaRg6wUYK8") { url, lifecycleOwner ->
        YTPlayerView(lifecycleOwner, url)
    }
}
