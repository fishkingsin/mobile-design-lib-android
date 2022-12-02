package com.nmg.mobile.design.gallery

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.R


@Composable
fun CommonColorItems(colors: List<Pair<String, Color>>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {

        items(colors) { color ->

            ColorItem(color.first, color = color.second)

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CommonColorItems_Preview() {
    AppTheme {
        CommonColorItems(
            listOf(
                Pair("Common_Neutral_Gray_5", colorResource(id = R.color.Common_Neutral_Gray_5)),
                Pair("Common_Neutral_Gray_90", colorResource(id = R.color.Common_Neutral_Gray_90)),
                Pair("Common_Neutral_Gray_80", colorResource(id = R.color.Common_Neutral_Gray_80)),
                Pair("Common_Neutral_Gray_70", colorResource(id = R.color.Common_Neutral_Gray_70)),
                Pair("Common_Neutral_Gray_60", colorResource(id = R.color.Common_Neutral_Gray_60)),
                Pair("Common_Neutral_Gray_50", colorResource(id = R.color.Common_Neutral_Gray_50)),
                Pair("Common_Neutral_Gray_40", colorResource(id = R.color.Common_Neutral_Gray_40)),
                Pair("Common_Neutral_Gray_30", colorResource(id = R.color.Common_Neutral_Gray_30)),
                Pair("Common_Neutral_Gray_20", colorResource(id = R.color.Common_Neutral_Gray_20)),
                Pair("Common_Neutral_Gray_10", colorResource(id = R.color.Common_Neutral_Gray_10)),
                Pair("Common_Neutral_Gray_5", colorResource(id = R.color.Common_Neutral_Gray_5)),
                Pair("Alert", colorResource(id = R.color.Alert)),
                Pair("Success", colorResource(id = R.color.Success)),
                Pair("Black", colorResource(id = R.color.Black)),
                Pair("White", colorResource(id = R.color.White)),
            )
        )
    }

}