package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.widgets.chip.ChipData
import com.nmg.mobile.design.widgets.chip.ChipGroup

private data class DemoChipData(override val title: String) : ChipData

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChipGroup_Demo_Preview() {
    ChipGroup(
        items =
        listOf(
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
            DemoChipData("Logout")
        )
    ) {
    }
}
