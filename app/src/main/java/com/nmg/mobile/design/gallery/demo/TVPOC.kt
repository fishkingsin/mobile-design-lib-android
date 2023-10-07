package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.nmg.mobile.design.gallery.demo.tvpoc.TVActionItem
import com.nmg.mobile.design.gallery.demo.tvpoc.TVBody
import com.nmg.mobile.design.gallery.demo.tvpoc.TVHeadline
import com.nmg.mobile.design.gallery.demo.tvpoc.TVNote
import com.nmg.mobile.design.theme.EDDefaultColors
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.ytplayer.YTPlayerView

@Composable
fun TVPOC(
    url: String,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    content: @Composable (url: String, lifecycleOwner: LifecycleOwner) -> Unit
) {
    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            lifecycleEvent = event
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
        }
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start
    ) {
        content(url, lifecycleOwner)
        LazyColumn {
            // Add a single item
            item {
                TVHeadline()
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start
                ) {
                    TVNote()
                    TVBody()
                }
            }
            item {
                TVActionItem()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TVPOCPreview() {
    NMGTheme(colors = EDDefaultColors()) {
        TVPOC("kXaRg6wUYK8") { url, lifecycleOwner ->
            YTPlayerView(lifecycleOwner, url)
        }
    }
}
