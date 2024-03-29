package com.nmg.mobile.design.videoplayer

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControl
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerSource
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControlItems
import org.junit.Before
import org.junit.Rule
import org.junit.Test
/* disable flaky test
class VideoPlayerControlTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_VideoPlayerControlTest() {
        composeRule.setContent {
            NMGTheme {
                VideoPlayerControl(
                    playableItems = VideoPlayerControlItems(
                        current = VideoPlayerSource(
                            "Title",
                            "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8",
                            "https://placehold.co/390x219/png",
                            videoType = "vimeo"
                        ),
                        null,
                        null
                    )
                )
            }
        }
        Thread.sleep(500)
        compareScreenshot(composeRule)

    }
}
*/