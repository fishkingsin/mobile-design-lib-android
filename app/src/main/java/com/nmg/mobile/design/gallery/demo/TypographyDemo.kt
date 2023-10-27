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
            Pair("eleSemibold24", NMGTheme.typography.eleSemibold24),
            Pair("eleSemibold22", NMGTheme.typography.eleSemibold22),
            Pair("eleMedium18", NMGTheme.typography.eleMedium18),
            Pair("eleMedium14", NMGTheme.typography.eleMedium14),
            Pair("eleRegular24", NMGTheme.typography.eleRegular24),
            Pair("eleRegular18", NMGTheme.typography.eleRegular18),
            Pair("eleRegular16", NMGTheme.typography.eleRegular16),
            Pair("eleRegular14", NMGTheme.typography.eleRegular14),
            Pair("eleRegular12", NMGTheme.typography.eleRegular12),
            Pair("eleRegular10", NMGTheme.typography.eleRegular10),
            Pair("carouselTitle", NMGTheme.typography.carouselTitle),
            Pair("cardTitle", NMGTheme.typography.cardTitle),
            Pair("cardContent", NMGTheme.typography.cardContent),
            Pair("articleH1", NMGTheme.typography.articleH1),
            Pair("articleH2", NMGTheme.typography.articleH2),
            Pair("articleH3", NMGTheme.typography.articleH3),
            Pair("articleContent", NMGTheme.typography.articleContent),
            Pair("articleDescription", NMGTheme.typography.articleDescription)
        )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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
