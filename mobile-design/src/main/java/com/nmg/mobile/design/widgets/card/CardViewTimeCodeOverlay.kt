package com.nmg.mobile.design.widgets.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun CardViewTimeCodeOverlay(timecode: String, boxScope: BoxScope) {
    boxScope.apply {
        Row(
            modifier = Modifier
                .padding(NMGTheme.customSystem.spacing)
                .align(Alignment.BottomEnd)
                .background(
                    color = Color(0xF2838383), shape = RoundedCornerShape(size = 4.dp)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Icon(
                modifier = Modifier.padding(1.dp),
                tint = Color.White,
                painter = painterResource(id = R.drawable.play),
                contentDescription = "image description",
            )
            Text(
                text = timecode,
                color = Color.White,
                modifier = Modifier
                    .padding(2.dp),
            )

        }
    }
}

@Preview
@Composable
fun CardViewTimeCodeOverlay_Preview() {
    NMGTheme {
        Box {
            CardViewTimeCodeOverlay(
                timecode = "22:22", this
            )
        }
    }
}