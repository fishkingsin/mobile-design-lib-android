package com.nmg.mobile.design.gallery.demo

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayer
import com.nmg.mobile.design.widgets.ytplayer.YTPlayerView

@Composable
fun TVPOCScreen() {
    TVPOC("kXaRg6wUYK8") { url, lifecycleOwner ->
        YTPlayerView(lifecycleOwner, url)
    }
}

@Composable
fun TVPOCVimeoScreen() {
    TVPOC("https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8") { url, lifecycleOwner ->
        VideoPlayer(Uri.parse(url), modifier = Modifier.fillMaxWidth().fillMaxHeight(0.33f))
    }
}
