package com.nmg.mobile.design.reel

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.ReelPager
import com.nmg.mobile.design.widgets.reel.ReelPlayerData
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ReelPagerTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_ReelPager() {
        composeRule.setContent {
            NMGTheme {
                Box(modifier = Modifier.background(Color.Gray)) {
                    val list = mutableListOf<ReelPlayerData>()
                    for (item in 1..10) {
                        list.add(object : ReelPlayerData {
                            override var title: String = "@經一共肥計畫 $item"
                            override var desc: String = "若從每人身上賺1元大餅，已是14個億的大茶飯，難度在於中間化零為整的手段。滴灌通主席李小加就想到了破解方案，兼開發出複利生財的投資模式，有如太極生兩儀、兩儀生四象。薑是老的辣，61歲的他下海創業，把生意經的算盤敲得響噹噹。 $item"
                        })
                    }
                    NMGTheme {
                        ReelPager(list = list)
                    }
                }
            }
        }
        Thread.sleep(1000)
        compareScreenshot(composeRule)
    }
}
