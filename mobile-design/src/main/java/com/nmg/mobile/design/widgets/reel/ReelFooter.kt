package com.nmg.mobile.design.widgets.reel

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <Reel : ReelInterface> ReelFooter(reel: Reel) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(
            reel = reel,
            modifier = Modifier.weight(8f)
        )

        FooterUserAction(
            reel = reel,
            modifier = Modifier.weight(2f)
        )
    }
}
