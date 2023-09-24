package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun TypographyDemo() {
    val typographies =
        listOf(
            Pair("largeTitleEmphasize", NMGTheme.typography.largeTitleEmphasize),
            Pair("titleEmphasize", NMGTheme.typography.titleEmphasize),
            Pair("title1", NMGTheme.typography.title1),
            Pair("title2", NMGTheme.typography.title2),
            Pair("title3", NMGTheme.typography.title3),
            Pair("title4", NMGTheme.typography.title4),
            Pair("title2Emphasize", NMGTheme.typography.title2Emphasize),
            Pair("title3Emphasize", NMGTheme.typography.title3Emphasize),
            Pair("title4Emphasize", NMGTheme.typography.title4Emphasize),
            Pair("title5", NMGTheme.typography.title5),
            Pair("headline", NMGTheme.typography.headline),
            Pair("headlineEmphasize", NMGTheme.typography.headlineEmphasize),
            Pair("primaryButton", NMGTheme.typography.primaryButton),
            Pair("captionEmphasize", NMGTheme.typography.captionEmphasize),
            Pair("caption", NMGTheme.typography.caption),
            Pair("caption2", NMGTheme.typography.caption2),
            Pair("caption3Emphasize", NMGTheme.typography.caption3Emphasize),
            Pair("naviTitle", NMGTheme.typography.naviTitle),
            Pair("body", NMGTheme.typography.body),
            Pair("bodyEmphasize", NMGTheme.typography.bodyEmphasize),
        )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(typographies) {
            Text("${it.first} ${it.second.fontSize}", style = it.second)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TypographyDemo_EDTheme() {
    NMGTheme {
        TypographyDemo()
    }
}
