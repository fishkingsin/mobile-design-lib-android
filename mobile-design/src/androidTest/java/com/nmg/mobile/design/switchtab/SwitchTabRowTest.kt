package com.nmg.mobile.design.switchtab

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.EDDefaultColors
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.switchtab.SimpleTabData
import com.nmg.mobile.design.widgets.switchtab.SwitchTabRow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SwitchTabRowTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_SwitchTabRow() {
        composeRule.setContent {
            NMGTheme(colors = EDDefaultColors()) {
                SwitchTabRow(
                    tabs = listOf(
                        SimpleTabData("理財投資"),
                        SimpleTabData("最新影片")
                    )
                ) {
                }
            }
        }
        Thread.sleep(5000)
        compareScreenshot(composeRule)
    }
}
