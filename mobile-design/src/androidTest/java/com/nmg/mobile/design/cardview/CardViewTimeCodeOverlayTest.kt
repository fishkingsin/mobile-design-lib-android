package com.nmg.mobile.design.cardview

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.card.CardViewTimeCodeOverlay
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CardViewTimeCodeOverlayTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_CardViewTimeCodeOverlay() {
        composeRule.setContent {
            NMGTheme {
                Box {
                    CardViewTimeCodeOverlay(
                        timecode = "22:22",
                        this
                    )
                }
            }
        }
        Thread.sleep(5000)
        compareScreenshot(composeRule)
    }
}
