package com.nmg.mobile.design.widgets.switchtab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun Float.pxToDp(): Dp {
    val value = this
    return with(LocalDensity.current) {
        value.toDp()
    }
}

@Composable
fun <Data : TabData> SwitchTabRow(
    tabs: List<Data>,
    selectedTabIndex: Int = 0,
    onTabClick: (Int) -> Unit
) {
    var tabIndex by remember { mutableStateOf(selectedTabIndex) }
    val scrollableTabRowWidth = remember { mutableStateOf(0f) }

    LaunchedEffect(selectedTabIndex) {
        tabIndex = selectedTabIndex
    }

    ScrollableTabRow(
        edgePadding = 0.dp,
        modifier = Modifier
            .widthIn(100.dp, scrollableTabRowWidth.value.pxToDp())
            .padding(0.dp),
        selectedTabIndex = tabIndex,
        backgroundColor = Color.Transparent,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[tabIndex]),
                contentAlignment = Alignment.Center
            ) {
                Divider(
                    modifier = Modifier
                        .width(22.dp)
                        .background(NMGTheme.colors.primaryMain, RoundedCornerShape(3.dp)),
                    thickness = 4.dp
                )
            }
        },
        divider = { }
    ) {
        var tabsWidth = 0F
        tabs.forEachIndexed { index, tab ->
            val customTab = @Composable {
                Tab(
                    modifier = Modifier
                        .padding(horizontal = 0.dp)
                        .padding(bottom = 0.dp)
                        .height(38.dp),
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                        onTabClick(index)
                    },
                    text = {
                        Text(
                            text = tab.title,
                            style = if (tabIndex == index) {
                                NMGTheme.typography.eleMedium18
                            } else {
                                NMGTheme.typography.eleRegular18
                            }
                        )
                    },
                    selectedContentColor = NMGTheme.colors.selectedTabContentColor,
                    unselectedContentColor = NMGTheme.colors.unselectedTabContentColor
                )
            }

            MeasureWidthOf(setWidth = {
                tabsWidth += it.toFloat()
                if (index == tabs.size - 1 && scrollableTabRowWidth.value == 0F) {
                    scrollableTabRowWidth.value = tabsWidth
                }
            }) {
                customTab()
            }
        }
    }
}

@Composable
private fun MeasureWidthOf(setWidth: (Int) -> Unit, content: @Composable () -> Unit) {
    Layout(
        content = content
    ) { list: List<Measurable>, constraints: Constraints ->
        check(list.size == 1)
        val placeable = list.last().measure(constraints)
        layout(
            width = placeable.width.also(setWidth),
            height = placeable.height
        ) {
            placeable.placeRelative(x = 0, y = 0)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchTab_Preview() {
    SwitchTabRow(
        tabs = listOf(
            SimpleTabData("理財投資"),
            SimpleTabData("最新影片")
        )
    ) {
    }
}
