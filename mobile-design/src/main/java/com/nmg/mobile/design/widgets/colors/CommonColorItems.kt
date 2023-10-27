package com.nmg.mobile.design.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R
import com.nmg.mobile.design.extensions.ColorResource
import com.nmg.mobile.design.theme.NMGTheme

@Composable
public fun CommonColorItems(colors: List<Pair<String, Color>>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(colors) { color ->

            ColorItem(color.first, color = color.second)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CommonColorItems_Preview() {
    NMGTheme {
        CommonColorItems(
            listOf(
                Pair("Primary", NMGTheme.colors.primaryMain),
                Pair("Common_Neutral_Gray_5", ColorResource(id = R.color.Common_Neutral_Gray_5)),
                Pair("Common_Neutral_Gray_90", ColorResource(id = R.color.Common_Neutral_Gray_90)),
                Pair("Common_Neutral_Gray_80", ColorResource(id = R.color.Common_Neutral_Gray_80)),
                Pair("Common_Neutral_Gray_70", ColorResource(id = R.color.Common_Neutral_Gray_70)),
                Pair("Common_Neutral_Gray_60", ColorResource(id = R.color.Common_Neutral_Gray_60)),
                Pair("Common_Neutral_Gray_50", ColorResource(id = R.color.Common_Neutral_Gray_50)),
                Pair("Common_Neutral_Gray_40", ColorResource(id = R.color.Common_Neutral_Gray_40)),
                Pair("Common_Neutral_Gray_30", ColorResource(id = R.color.Common_Neutral_Gray_30)),
                Pair("Common_Neutral_Gray_20", ColorResource(id = R.color.Common_Neutral_Gray_20)),
                Pair("Common_Neutral_Gray_10", ColorResource(id = R.color.Common_Neutral_Gray_10)),
                Pair("Common_Neutral_Gray_5", ColorResource(id = R.color.Common_Neutral_Gray_5)),
                Pair("Alert", ColorResource(id = R.color.Alert)),
                Pair("Success", ColorResource(id = R.color.Success)),
                Pair("Black", ColorResource(id = R.color.Black)),
                Pair("White", ColorResource(id = R.color.White))
            )
        )
    }
}
