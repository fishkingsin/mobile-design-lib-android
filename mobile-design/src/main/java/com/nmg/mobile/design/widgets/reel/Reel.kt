package com.nmg.mobile.design.widgets.reel

import android.net.Uri

data class Reel(
    override val id: Int,
    override val video: String,
    override val userImage: String,
    override val userName: String,
    override val isLiked: Boolean = false,
    override val likesCount: Int,
    override val comment: String,
    override val commentsCount: Int
): ReelInterface {

    override fun getVideoUrl(): Uri {
        return Uri.parse("asset:///${video}")
    }

}