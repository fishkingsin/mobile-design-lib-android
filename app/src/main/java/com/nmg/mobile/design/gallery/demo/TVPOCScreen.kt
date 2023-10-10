package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable

@Composable
fun TVPOCScreen() {
    TVPOC(TVContent(ytUrl = "kXaRg6wUYK8")) { content, lifecycleOwner ->
        content.view(lifecycleOwner)
    }
}

@Composable
fun TVPOCVimeoScreen() {
    TVPOC(
        TVContent(m3u8 = "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8")
    ) { content, lifecycleOwner ->
        content.view(lifecycleOwner)
    }
}
