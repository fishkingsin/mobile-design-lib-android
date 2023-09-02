package com.nmg.mobile.design.widgets.tabbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun Tabbar() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabBackground = NMGTheme.colors.tabBackground
    val tabSelectedBackground = NMGTheme.colors.tabSelectedBackground
    val tabs = listOf("Home", "About", "Settings", "Profile", "Help", "Contact", "Privacy", "Terms", "FAQ", "Support", "Logout")
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(tabs.size) { index ->
            TabCell(
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                text = { selected ->
                    Text(
                        color = if(selected) { tabBackground } else { tabSelectedBackground},
                        modifier = Modifier
                            .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                        text = tabs[index])
                }
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Tabbar_Preview() {
    NMGTheme() {
        Tabbar()
    }
}
