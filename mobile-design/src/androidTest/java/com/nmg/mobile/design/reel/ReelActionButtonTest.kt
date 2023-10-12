package com.nmg.mobile.design.reel

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.ReelActionButton
import com.nmg.mobile.design.widgets.reel.ReelActionButtonData
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ReelActionButtonTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_ReelActionButton() {
        composeRule.setContent {
            NMGTheme {
                ReelActionButton(object : ReelActionButtonData {
                    override var vectorDrawableRes: Int = R.drawable.reel_link
                    override var vectorDrawableResSelected: Int? = null
                    override var isSelected: Boolean = false
                })
            }
        }
        Thread.sleep(1000)
        compareScreenshot(composeRule)
    }
}
