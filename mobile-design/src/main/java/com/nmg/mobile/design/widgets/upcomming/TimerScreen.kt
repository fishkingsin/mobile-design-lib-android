package com.nmg.mobile.design.widgets.upcomming

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(count: Int, onCountChange: () -> Unit) {
    var elapsedTime: Int by remember { mutableStateOf(0) }

    DisposableEffect(Unit) {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            while (true) {
                delay(1000)
                elapsedTime += 1
                if (elapsedTime == count) {
                    onCountChange()
                    break
                }
                Log.d("TimerScreen", "Timer is still working ${elapsedTime}")
            }
        }

        onDispose {
            job.cancel()
        }
    }

    Row {
        Text(
            text = "將於",
            style = NMGTheme.typography.eleRegular14,
            color = NMGTheme.colors.commonNeutralGray50
        )
        Text(
            text = "${count - elapsedTime}",
            style = NMGTheme.typography.eleRegular14,
            color = NMGTheme.colors.commonNeutralGray2,
            modifier = Modifier.padding(top = 1.dp, start = 2.dp, end = 3.dp)
        )
        Text(
            text = "秒後播放",
            style = NMGTheme.typography.eleRegular14,
            color = NMGTheme.colors.commonNeutralGray50
        )
    }
}

@Composable
@Preview
fun TimerScreenPreview() {
    TimerScreen(count = 10, onCountChange = {})
}