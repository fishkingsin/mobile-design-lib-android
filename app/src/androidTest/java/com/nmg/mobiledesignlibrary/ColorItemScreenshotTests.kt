package com.nmg.mobiledesignlibrary

import android.content.Context
import androidx.annotation.ColorRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.gallery.ColorItem
import com.nmg.mobile.design.gallery.CommonColorItems
import com.nmg.mobile.design.gallery.colorResource
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ColorItemScreenshotTests : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }


    @Test
    fun test_color_common() {
        composeRule.setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CommonColorItems(
                        listOf(
                            Pair(
                                "Common_Neutral_Gray_5",
                                colorResource(id = R.color.Common_Neutral_Gray_5)
                            ),
                            Pair(
                                "Common_Neutral_Gray_90",
                                colorResource(id = R.color.Common_Neutral_Gray_90)
                            ),
                            Pair(
                                "Common_Neutral_Gray_80",
                                colorResource(id = R.color.Common_Neutral_Gray_80)
                            ),
                            Pair(
                                "Common_Neutral_Gray_70",
                                colorResource(id = R.color.Common_Neutral_Gray_70)
                            ),
                            Pair(
                                "Common_Neutral_Gray_60",
                                colorResource(id = R.color.Common_Neutral_Gray_60)
                            ),
                            Pair(
                                "Common_Neutral_Gray_50",
                                colorResource(id = R.color.Common_Neutral_Gray_50)
                            ),
                            Pair(
                                "Common_Neutral_Gray_40",
                                colorResource(id = R.color.Common_Neutral_Gray_40)
                            ),
                            Pair(
                                "Common_Neutral_Gray_30",
                                colorResource(id = R.color.Common_Neutral_Gray_30)
                            ),
                            Pair(
                                "Common_Neutral_Gray_20",
                                colorResource(id = R.color.Common_Neutral_Gray_20)
                            ),
                            Pair(
                                "Common_Neutral_Gray_10",
                                colorResource(id = R.color.Common_Neutral_Gray_10)
                            ),
                            Pair(
                                "Common_Neutral_Gray_5",
                                colorResource(id = R.color.Common_Neutral_Gray_5)
                            ),
                            Pair("Alert", colorResource(id = R.color.Alert)),
                            Pair("Success", colorResource(id = R.color.Success)),
                            Pair("Black", colorResource(id = R.color.Black)),
                            Pair("White", colorResource(id = R.color.White)),
                        )
                    )
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_Alert_snapshot() {
        renderComponent(R.color.Alert)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_Success_snapshot() {
        renderComponent(R.color.Success)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_Black_snapshot() {
        renderComponent(R.color.Black)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_White_snapshot() {
        renderComponent(R.color.White)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_ED_snapshot() {
        instrumentationContext.setTheme(R.style.ED)
        renderComponent(R.color.ed_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_WW_snapshot() {
        instrumentationContext.setTheme(R.style.WW)
        renderComponent(R.color.ww_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_MORE_snapshot() {
        instrumentationContext.setTheme(R.style.MORE)
        renderComponent(R.color.more_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_KISS_snapshot() {
        instrumentationContext.setTheme(R.style.KISS)
        renderComponent(R.color.kiss_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_NM_snapshot() {
        instrumentationContext.setTheme(R.style.NM)
        renderComponent(R.color.nm_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_OS_snapshot() {
        instrumentationContext.setTheme(R.style.OS)
        renderComponent(R.color.os_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_OH_snapshot() {
        instrumentationContext.setTheme(R.style.OH)
        renderComponent(R.color.oh_primaryMain)
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_GOTRIP_snapshot() {
        instrumentationContext.setTheme(R.style.GOTRIP)
        renderComponent(R.color.gotrip_primaryMain)
        compareScreenshot(composeRule)
    }

    @Composable
    private fun colorItemComponent(color: Color) {
        MaterialTheme {
            Surface(color = MaterialTheme.colors.background) {
                ColorItem(color = color)
            }
        }
    }

    @Composable
    private fun colorItemComponent(@ColorRes id: Int) {
        MaterialTheme {
            Surface(color = MaterialTheme.colors.background) {
                
                ColorItem(color = colorResource(id = id))
            }
        }
    }

    private fun renderComponent(@ColorRes id: Int) {
        composeRule.setContent {
            colorItemComponent(id)
        }
    }

    private fun renderComponent(color: Color) {
        composeRule.setContent {
            colorItemComponent(color)
        }
    }

}
