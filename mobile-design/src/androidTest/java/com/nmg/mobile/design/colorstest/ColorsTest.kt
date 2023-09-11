package com.nmg.mobile.design.colorstest

import android.content.Context
import androidx.annotation.ColorRes
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.extensions.colorResource
import com.nmg.mobile.design.gallery.ColorItem
import com.nmg.mobile.design.gallery.CommonColorItems
import com.nmg.mobile.design.theme.EDDefaultColors
import com.nmg.mobile.design.theme.GotripDefaultColors
import com.nmg.mobile.design.theme.KissDefaultColors
import com.nmg.mobile.design.theme.MoreDefaultColors
import com.nmg.mobile.design.theme.NMDefaultColors
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.theme.OHDefaultColors
import com.nmg.mobile.design.theme.OSDefaultColors
import com.nmg.mobile.design.theme.ThemeManager
import com.nmg.mobile.design.theme.WWDefaultColors
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ColorsTest : ScreenshotTest {
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
            NMGTheme {
                Surface(color = Color.White) {
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
    fun test_color_WW_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "ww")
        composeRule.setContent {
            NMGTheme(colors = WWDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_ED_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "ed")
        composeRule.setContent {
            NMGTheme(colors = EDDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_kiss_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "kiss")
        composeRule.setContent {
            NMGTheme(colors = KissDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_more_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "more")
        composeRule.setContent {
            NMGTheme(colors = MoreDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_nm_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "nm")
        composeRule.setContent {
            NMGTheme(colors = NMDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_os_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "os")
        composeRule.setContent {
            NMGTheme(colors = OSDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_gotrip_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "gotrip")
        composeRule.setContent {
            NMGTheme(colors = GotripDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun test_color_oh_snapshot() {
        ThemeManager.setCustomizedThemes(instrumentationContext, "oh")
        composeRule.setContent {
            NMGTheme(colors = OHDefaultColors()) {
                Surface(color = Color.White) {

                    ColorItem(color = NMGTheme.colors.primaryMain)
                }
            }
        }
        compareScreenshot(composeRule)
    }

    @Composable
    fun colorItemComponent(color: Color) {
        Surface(color = Color.White) {
            ColorItem(color = color)
        }
    }

    @Composable
    fun colorItemComponent(@ColorRes id: Int) {
        Surface(color = Color.White) {

            ColorItem(color = colorResource(id = id))
        }
    }

    fun renderComponent(@ColorRes id: Int) {
        composeRule.setContent {
            colorItemComponent(id)
        }
    }

    fun renderComponent(color: Color) {
        composeRule.setContent {
            colorItemComponent(color)
        }
    }
}
