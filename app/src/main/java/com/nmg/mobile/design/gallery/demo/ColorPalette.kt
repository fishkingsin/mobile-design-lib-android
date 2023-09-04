package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.gallery.CommonColorItems
import com.nmg.mobile.design.theme.EDDefaultColors
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun ColorPalette() {
    CommonColorItems(
        listOf(
            Pair("Primary", NMGTheme.colors.primaryMain),
            Pair("tabSelectedBackground", NMGTheme.colors.tabSelectedBackground),
            Pair("tabBackground", NMGTheme.colors.tabBackground),
            Pair("commonNeutralGray90", NMGTheme.colors.commonNeutralGray90),
            Pair("commonNeutralGray80", NMGTheme.colors.commonNeutralGray80),
            Pair("commonNeutralGray70", NMGTheme.colors.commonNeutralGray70),
            Pair("commonNeutralGray60", NMGTheme.colors.commonNeutralGray60),
            Pair("commonNeutralGray50", NMGTheme.colors.commonNeutralGray50),
            Pair("commonNeutralGray40", NMGTheme.colors.commonNeutralGray40),
            Pair("commonNeutralGray30", NMGTheme.colors.commonNeutralGray30),
            Pair("commonNeutralGray20", NMGTheme.colors.commonNeutralGray20),
            Pair("commonNeutralGray10", NMGTheme.colors.commonNeutralGray10),
            Pair("commonNeutralGray5", NMGTheme.colors.commonNeutralGray5),
            Pair("commonNeutralGray2", NMGTheme.colors.commonNeutralGray2),
            Pair("footnote", NMGTheme.colors.footnote),
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColorPalettePreview_EDTheme() {
    NMGTheme(colors = EDDefaultColors()) {
        ColorPalette()
    }
}