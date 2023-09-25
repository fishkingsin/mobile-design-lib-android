package com.nmg.mobile.design.cardview

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.card.CardView
import com.nmg.mobile.design.widgets.card.HorizontalCard
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HorizontalCardTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_HorizontalCard() {
        composeRule.setContent {
            NMGTheme() {
                LazyColumn {
                    items(2) {
                        HorizontalCard(
                            data = CardData(
                                imageURL = "https://placehold.co/133x75/png",
                                headline = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式獨家專訪｜用科技顛覆金融 李小加革新小店投資模式獨家專訪｜用科技顛覆金融 李小加革新小店投資模式",
                                leadingFootnote = "4小時前",
                                secondFootnote = "經人觀點",
                                _timecode = "22:22"
                            ),
                            isPlaying = it == 0
                        )
                    }
                }
            }
        }
        Thread.sleep(5000)
        compareScreenshot(composeRule)
    }

}