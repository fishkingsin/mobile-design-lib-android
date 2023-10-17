package com.nmg.mobile.design.videoplayer

import android.content.Context
import android.net.Uri
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayer
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControl
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControlData
import com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControlState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class VideoPlayerControlTest : ScreenshotTest {

//    @get:Rule
//    val composeRule = createComposeRule()
//
//    lateinit var instrumentationContext: Context
//    val testUri = Uri.parse("https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8")
//    @Before
//    fun setup() {
//        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_LOADING() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.LOADING
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_PLAYING() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.PLAYING
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                    null
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_PLAYING_TAB() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.PLAYING_TAB
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                    null
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_PAUSED() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.PAUSED
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                    null
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_COMPLETED() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.COMPLETED
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                    null
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
//
//    @Test
//    fun test_VideoPlayerControlTest_COMPLETED_CANCEL_AUTOPLAY() {
//        composeRule.setContent {
//            NMGTheme {
//                VideoPlayerControl(
//                    object : VideoPlayerControlData {
//                        override var playState: VideoPlayerControlState = VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY
//                        override var imageURL: String = "https://placehold.co/390x219/png"
//                        override var totalTime: String = "22:22"
//                        override var sliderValue: Float = 0.5f
//                    },
//                    null,
//                    null,
//                    null
//                )
//            }
//        }
//        Thread.sleep(5000)
//        compareScreenshot(composeRule)
//    }
}
