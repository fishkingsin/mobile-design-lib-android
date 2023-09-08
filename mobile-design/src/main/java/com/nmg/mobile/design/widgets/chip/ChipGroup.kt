package com.nmg.mobile.design.widgets.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme
public interface ChipData {
    val title: String
}
@Composable
public fun <Items: List<ChipData>> ChipGroup(items: Items) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabBackground = NMGTheme.colors.tabBackground
    val tabSelectedBackground = NMGTheme.colors.tabSelectedBackground

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(items.size) { index ->
            Chip(
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                text = { selected ->
                    Text(
                        color = if(selected) { tabBackground } else { tabSelectedBackground},
                        modifier = Modifier
                            .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                        text = items[index].title)
                }
            )
        }
    }
}

private data class DemoChipData(override val title: String): ChipData

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChipGroup_Preview() {
    NMGTheme() {
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
        )
        )
    }
}
