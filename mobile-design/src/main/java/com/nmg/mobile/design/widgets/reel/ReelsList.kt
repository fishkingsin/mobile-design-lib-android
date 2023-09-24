package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayer

@Composable
fun <Reels : List<ReelInterface>> ReelsList(reels: Reels) {
    LazyColumn {
        items(reels.size) { index ->
            Box(Modifier.fillParentMaxSize()) {
                VideoPlayer(uri = reels[index].getVideoUrl())
                Column(Modifier.align(Alignment.BottomStart)) {
                    ReelFooter(reels[index])
                    Divider()
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ReelsListPreview() {
    ReelsList(DummyData.reels)
}

object DummyData {
    val reels = listOf<ReelInterface>(
        Reel(
            id = 1,
            video = "lake.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/4.png",
            userName = "Farhan Roy",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "Wkwkwk..."
        ),
        Reel(
            id = 2,
            video = "food.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/7.png",
            userName = "Muhammad Ali",
            isLiked = true,
            likesCount = 5923,
            commentsCount = 11,
            comment = "Awas kamu ya klo pergi"
        ),
        Reel(
            id = 3,
            video = "icecream.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/3.png",
            userName = "Christian Juned",
            isLiked = true,
            likesCount = 2314,
            comment = "Es krim dingin sedapp",
            commentsCount = 200
        ),
        Reel(
            id = 4,
            video = "soap-bubbles.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/6.png",
            userName = "Cak Jhon",
            isLiked = true,
            likesCount = 786,
            comment = "Ados slurr",
            commentsCount = 700
        ),
        Reel(
            id = 5,
            video = "castle.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/2.png",
            userName = "David Dulkader",
            isLiked = true,
            likesCount = 1890,
            comment = "Kerjaan di tengah hutan",
            commentsCount = 232
        )

    )
}
