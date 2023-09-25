package com.nmg.mobile.design.chipgrouptest

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.chip.ChipGroup
import com.nmg.mobile.design.widgets.chip.DemoChipData
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ChipGroupTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_ChipGroup() {
        composeRule.setContent {
            NMGTheme {
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
                        DemoChipData("Logout")
                    )
                ) {
                }
            }
        }
        compareScreenshot(composeRule)
    }
}
