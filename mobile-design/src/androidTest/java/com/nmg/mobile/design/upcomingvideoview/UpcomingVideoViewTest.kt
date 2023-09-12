package com.nmg.mobile.design.upcomingvideoview

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.card.CardData
import com.nmg.mobile.design.widgets.card.CardView
import com.nmg.mobile.design.widgets.reel.UpcomingItem
import com.nmg.mobile.design.widgets.reel.UpcomingVideoView
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UpcomingVideoViewTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }


    @Test
    fun test_UpcomingVideoView() {
        composeRule.setContent {

            NMGTheme() {
                UpcomingVideoView(object : UpcomingItem {
                    override var imageURL: String
                        get() = "https://placehold.co/144x75/png"
                        set(value) {}
                    override var headline: String
                        get() = "獨家專訪｜用科技顛覆金融 李小加革新小店投資模式"
                        set(value) {}
                    override var timeCode: String
                        get() = "22:22"
                        set(value) {}
                    override var secCountDown: Int
                        get() = 10
                        set(value) {}
                    override var onClickCancel: () -> Unit
                        get() = {}
                        set(value) {}
                    override var onClickPlay: () -> Unit
                        get() = {}
                        set(value) {}

                }
                )
            }
        }
        Thread.sleep(1000)
        compareScreenshot(composeRule)
    }


}