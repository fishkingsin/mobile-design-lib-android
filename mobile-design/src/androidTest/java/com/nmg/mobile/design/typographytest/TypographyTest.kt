package com.nmg.mobile.design.typographytest

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.theme.defaultTypography
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TypographyTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context
    val typographies = listOf(
        Pair("largeTitleEmphasize", defaultTypography.largeTitleEmphasize),
        Pair("titleEmphasize", defaultTypography.titleEmphasize),
        Pair("title1", defaultTypography.title1),
        Pair("title2", defaultTypography.title2),
        Pair("title3", defaultTypography.title3),
        Pair("title4", defaultTypography.title4),
        Pair("title2Emphasize", defaultTypography.title2Emphasize),
        Pair("title3Emphasize", defaultTypography.title3Emphasize),
        Pair("title4Emphasize", defaultTypography.title4Emphasize),
        Pair("title5", defaultTypography.title5),
        Pair("headline", defaultTypography.headline),
        Pair("headlineEmphasize", defaultTypography.headlineEmphasize),
        Pair("primaryButton", defaultTypography.primaryButton),
        Pair("captionEmphasize", defaultTypography.captionEmphasize),
        Pair("caption", defaultTypography.caption),
        Pair("caption2", defaultTypography.caption2),
        Pair("caption3Emphasize", defaultTypography.caption3Emphasize),
        Pair("naviTitle", defaultTypography.naviTitle),
        Pair("body", defaultTypography.body),
        Pair("bodyEmphasize", defaultTypography.bodyEmphasize),
    )
    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_typographies() {
        composeRule.setContent {

            NMGTheme() {

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(300.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(typographies) {
                        Text("${it.first} ${it.second.fontSize}", style = it.second)
                    }
                }
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_largeTitleEmphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("largeTitleEmphasize", style = defaultTypography.largeTitleEmphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_titleEmphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("titleEmphasize", style = defaultTypography.titleEmphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title1() {
        composeRule.setContent {

            NMGTheme() {
                Text("title1", style = defaultTypography.title1)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title2() {
        composeRule.setContent {

            NMGTheme() {
                Text("title2", style = defaultTypography.title2)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title3() {
        composeRule.setContent {

            NMGTheme() {
                Text("title3", style = defaultTypography.title3)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title4() {
        composeRule.setContent {

            NMGTheme() {
                Text("title4", style = defaultTypography.title4)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title2Emphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("title2Emphasize", style = defaultTypography.title2Emphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title3Emphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("title3Emphasize", style = defaultTypography.title3Emphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title4Emphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("title4Emphasize", style = defaultTypography.title4Emphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_title5() {
        composeRule.setContent {

            NMGTheme() {
                Text("title5", style = defaultTypography.title5)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_headline() {
        composeRule.setContent {

            NMGTheme() {
                Text("headline", style = defaultTypography.headline)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_headlineEmphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("headlineEmphasize", style = defaultTypography.headlineEmphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_primaryButton() {
        composeRule.setContent {

            NMGTheme() {
                Text("primaryButton", style = defaultTypography.primaryButton)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_captionEmphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("captionEmphasize", style = defaultTypography.captionEmphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_caption() {
        composeRule.setContent {

            NMGTheme() {
                Text("caption", style = defaultTypography.caption)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_caption2() {
        composeRule.setContent {

            NMGTheme() {
                Text("caption2", style = defaultTypography.caption2)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_caption3Emphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("caption3Emphasize", style = defaultTypography.caption3Emphasize)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_naviTitle() {
        composeRule.setContent {

            NMGTheme() {
                Text("naviTitle", style = defaultTypography.naviTitle)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_body() {
        composeRule.setContent {

            NMGTheme() {
                Text("body", style = defaultTypography.body)
            }
        }

        compareScreenshot(composeRule)
    }
    @Test
    fun test_bodyEmphasize() {
        composeRule.setContent {

            NMGTheme() {
                Text("bodyEmphasize", style = defaultTypography.bodyEmphasize)
            }
        }

        compareScreenshot(composeRule)
    }
}
