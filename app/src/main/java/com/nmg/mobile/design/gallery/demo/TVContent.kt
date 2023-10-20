package com.nmg.mobile.design.gallery.demo

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayer
import com.nmg.mobile.design.widgets.ytplayer.YTPlayerView

data class TVContent(
    override val id: String? = null,
    override val title: String? = null,
    override val description: String? = null,
    override val m3u8: String? = null,
    override var ytUrl: String? = null
) : TVContentProtocol {

    @Composable
    fun view(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
        if (m3u8 != null) {
            m3u8.let {
                VideoPlayer(
                    Uri.parse(m3u8),
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.33f)
                )
            }
        } else if (ytUrl != null) {
            ytUrl?.let {
                YTPlayerView(lifecycleOwner, it)
            }
        } else {
            Text("Failed to Load Video")
        }
    }
}
