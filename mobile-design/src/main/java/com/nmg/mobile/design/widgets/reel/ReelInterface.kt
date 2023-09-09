package com.nmg.mobile.design.widgets.reel

import android.net.Uri

public interface ReelInterface {
    public val id: Int
    val video: String
    public val userImage: String
    public val userName: String
    public val isLiked: Boolean
    public val likesCount: Int
    public val comment: String
    public val commentsCount: Int

    public fun getVideoUrl(): Uri
}