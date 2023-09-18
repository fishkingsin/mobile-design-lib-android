package com.nmg.mobile.design.reel

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.ReelActionButton
import com.nmg.mobile.design.widgets.reel.ReelActionButtonData
import com.nmg.mobile.design.widgets.reel.ReelActionButtonGroup
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ReelActionButtonGroupTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }


    @Test
    fun test_ReelActionButtonGroup() {
        composeRule.setContent {

            NMGTheme() {
                ReelActionButtonGroup()
            }
        }
        Thread.sleep(1000)
        compareScreenshot(composeRule)
    }


}