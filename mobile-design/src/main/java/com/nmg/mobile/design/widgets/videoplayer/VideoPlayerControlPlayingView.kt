package com.nmg.mobile.design.widgets.videoplayer

import android.util.Log
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun VideoPlayerControlPlayingView(boxScope: BoxScope, progressValue: Float) {
    Log.i("progress", "VideoPlayerControlPlayingView#sliderValue ${progressValue}")
    boxScope.apply {
        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .align(Alignment.BottomCenter),
            value = progressValue,
            onValueChange = { itValue ->
                Log.i("progress", "onValueChange#itValue ${itValue}")
            },
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
                Log.i("progress", "onValueChangeFinished")

            },
            colors = SliderDefaults.colors(
                thumbColor = NMGTheme.colors.primaryMain,
                activeTrackColor = NMGTheme.colors.primaryMain,
                inactiveTrackColor = Color.White
            )
        )
    }
}