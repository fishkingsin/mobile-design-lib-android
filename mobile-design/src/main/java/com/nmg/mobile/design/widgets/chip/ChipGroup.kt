package com.nmg.mobile.design.widgets.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.EDDefaultColors
import com.nmg.mobile.design.theme.GotripDefaultColors
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.theme.WWDefaultColors

public interface ChipData {
    val title: String
}

@Composable
public fun <Items : List<ChipData>> ChipGroup(items: Items, selectedTabIndex: Int = 0, onTapChip: (Int) -> Unit) {
    var tabIndex by remember { mutableStateOf(selectedTabIndex) }
    val chipSelectedForeground = NMGTheme.colors.chipSelectedForeground
    val chipForeground = NMGTheme.colors.chipForeground

    LaunchedEffect(selectedTabIndex) {
        tabIndex = selectedTabIndex
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(items.size) { index ->
            Chip(
                selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                    onTapChip(index)
                },
                content = { selected ->
                    Text(
                        color = if (selected) {
                            chipSelectedForeground
                        } else {
                            chipForeground
                        },
                        modifier = Modifier
                            .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                        text = items[index].title
                    )
                }
            )
        }
    }
}

data class DemoChipData(override val title: String) : ChipData

@Preview(showBackground = true)
@Composable
fun ChipGroup_WW_Theme_Preview() {
    NMGTheme(WWDefaultColors()) {
        ChipGroup(
            items = listOf(
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
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroup_ED_Theme_Preview() {
    NMGTheme(GotripDefaultColors()) {
        ChipGroup(
            items = listOf(
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
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroup_Selected_Tab_Preview() {
    val items = listOf(
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
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        Box {
            ChipGroup(
                items = items,
                selectedTabIndex = selectedTabIndex
            ) {
                selectedTabIndex = it
            }
        }

        Box {
            Button(onClick = {
                selectedTabIndex = (selectedTabIndex + 1) % items.size
            }) {
                Text(text = "Next")
            }
        }
    }
}
