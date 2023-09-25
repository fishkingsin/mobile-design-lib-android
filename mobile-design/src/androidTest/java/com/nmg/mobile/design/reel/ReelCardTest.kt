package com.nmg.mobile.design.reel

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.reel.ReelCard
import com.nmg.mobile.design.widgets.reel.ReelCardOverlay
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ReelCardTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_ReelCard() {
        composeRule.setContent {
            NMGTheme() {
                Box(
                    modifier = Modifier.size(126f.dp, 224f.dp)
                ) {
                    ReelCard(
                        data = CardData(
                            imageURL = "https://placehold.co/126x224/png",
                            headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                            leadingFootnote = "4小時前",
                            secondFootnote = "經人觀點",
                            _timecode = "22:22"
                        ),
                        overlay = {
                            ReelCardOverlay("22:22", it)
                        }
                    )
                }
            }
        }
        Thread.sleep(5000)
        compareScreenshot(composeRule)
    }

}