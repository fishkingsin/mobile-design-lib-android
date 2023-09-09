package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.card.VideoCardView
import com.nmg.mobile.design.widgets.chip.ChipGroup
import com.nmg.mobile.design.widgets.chip.DemoChipData
import com.nmg.mobile.design.widgets.reel.ReelCard
import com.nmg.mobile.design.widgets.reel.ReelCardOverlay

@Composable
fun CardDemo() {
    Column {
        LazyColumn(
            modifier = Modifier.padding(horizontal = NMGTheme.customSystem.padding),
            verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.spacing)
        ) {
            item {
                Column(
                    modifier = Modifier.padding(vertical = NMGTheme.customSystem.padding),
                    verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding)
                ) {
                    ChipGroup(items = listOf(
                        DemoChipData("Home"),
                        DemoChipData("About"),
                        DemoChipData("Settings"),
                        DemoChipData("Profile"),
                        DemoChipData("Help"),
                        DemoChipData("Contact"),
                        DemoChipData("Privacy"),
                        DemoChipData("Terms"),
                        DemoChipData("FAQ"),
                        DemoChipData("Support"),
                        DemoChipData("Logout"),
                    )) {

                    }
                    Text("最新的連續短片", style = NMGTheme.typography.title1Medium)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.spacing)) {
                        items(10) { it ->
                            ReelCard(
                                data = CardData(
                                    imageURL = "https://placehold.co/124x224/png?text=$it",
                                    headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                                    leadingFootnote = "4小時前",
                                    secondFootnote = "經人觀點",
                                    _timecode = "22:22"
                                ),
                                overlay = { boxscope ->
                                    ReelCardOverlay(
                                        message = "22:22",
                                        boxScope = boxscope
                                    )
                                }
                            )
                        }
                    }
                }
            }
            items(10) {
                VideoCardView(
                    data = CardData(
                        imageURL = "https://placehold.co/358x200/png?text=$it",
                        headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                        leadingFootnote = "4小時前",
                        secondFootnote = "經人觀點",
                        _timecode = "22:22"
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardDemoPreview() {
    CardDemo()
}