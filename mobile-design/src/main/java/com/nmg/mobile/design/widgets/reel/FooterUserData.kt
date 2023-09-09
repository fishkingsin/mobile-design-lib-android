package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun <Reel: ReelInterface>FooterUserData(reel: Reel, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                imageModel = reel.userImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(28.dp)
                    .background(color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = reel.userName,
                color = Color.White,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Follow",
                color = Color.White,
                style = MaterialTheme.typography.subtitle2
            )
        }

        Spacer(modifier = Modifier.height(horizontalPadding))
        Text(text = reel.comment, color = Color.White)
        Spacer(modifier = Modifier.height(horizontalPadding))


        // Audio
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(reel.userName, color = Color.White)
            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Audio asli",
                color = Color.White
            )
        }
    }
}