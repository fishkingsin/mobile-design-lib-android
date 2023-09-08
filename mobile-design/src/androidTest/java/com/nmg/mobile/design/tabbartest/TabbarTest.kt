package com.nmg.mobile.design.tabbartest

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.chip.ChipGroup
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TabbarTest: ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }


    @Test
    fun test_Tabbar() {
        composeRule.setContent {

            NMGTheme() {
                ChipGroup()
            }
        }
        compareScreenshot(composeRule)
    }


}
