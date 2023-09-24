package com.nmg.mobile.design.gallery.demo

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayer

@Composable
fun VideoExampleView() {
    VideoPlayer(
        uri = Uri.parse("https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"),
        modifier = Modifier.fillMaxSize(),
    )
}
