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
        Pair("eleSemibold24", defaultTypography.eleSemibold24),
        Pair("eleSemibold22", defaultTypography.eleSemibold22),
        Pair("eleMedium18", defaultTypography.eleMedium18),
        Pair("eleMedium14", defaultTypography.eleMedium14),
        Pair("eleRegular24", defaultTypography.eleRegular24),
        Pair("eleRegular18", defaultTypography.eleRegular18),
        Pair("eleRegular16", defaultTypography.eleRegular16),
        Pair("eleRegular14", defaultTypography.eleRegular14),
        Pair("eleRegular12", defaultTypography.eleRegular12),
        Pair("eleRegular10", defaultTypography.eleRegular10),
        Pair("carouselTitle", defaultTypography.carouselTitle),
        Pair("cardTitle", defaultTypography.cardTitle),
        Pair("cardContent", defaultTypography.cardContent),
        Pair("articleH1", defaultTypography.articleH1),
        Pair("articleH2", defaultTypography.articleH2),
        Pair("articleH3", defaultTypography.articleH3),
        Pair("articleContent", defaultTypography.articleContent),
        Pair("articleDescription", defaultTypography.articleDescription)
    )

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_typographies() {
        composeRule.setContent {
            NMGTheme {
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
    fun test_eleSemibold24() {
        composeRule.setContent {
            NMGTheme {
                Text("eleSemibold24", style = defaultTypography.eleSemibold24)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleSemibold22() {
        composeRule.setContent {
            NMGTheme {
                Text("eleSemibold22", style = defaultTypography.eleSemibold22)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleMedium18() {
        composeRule.setContent {
            NMGTheme {
                Text("eleMedium18", style = defaultTypography.eleMedium18)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleMedium14() {
        composeRule.setContent {
            NMGTheme {
                Text("eleMedium14", style = defaultTypography.eleMedium14)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular24() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular24", style = defaultTypography.eleRegular24)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular18() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular18", style = defaultTypography.eleRegular18)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular16() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular16", style = defaultTypography.eleRegular16)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular14() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular14", style = defaultTypography.eleRegular14)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular12() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular12", style = defaultTypography.eleRegular12)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_eleRegular10() {
        composeRule.setContent {
            NMGTheme {
                Text("eleRegular10", style = defaultTypography.eleRegular10)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_carouselTitle() {
        composeRule.setContent {
            NMGTheme {
                Text("carouselTitle", style = defaultTypography.carouselTitle)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_cardTitle() {
        composeRule.setContent {
            NMGTheme {
                Text("cardTitle", style = defaultTypography.cardTitle)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_cardContent() {
        composeRule.setContent {
            NMGTheme {
                Text("cardContent", style = defaultTypography.cardContent)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_articleH1() {
        composeRule.setContent {
            NMGTheme {
                Text("articleH1", style = defaultTypography.articleH1)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_articleH2() {
        composeRule.setContent {
            NMGTheme {
                Text("articleH2", style = defaultTypography.articleH2)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_articleH3() {
        composeRule.setContent {
            NMGTheme {
                Text("articleH3", style = defaultTypography.articleH3)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_articleContent() {
        composeRule.setContent {
            NMGTheme {
                Text("articleContent", style = defaultTypography.articleContent)
            }
        }

        compareScreenshot(composeRule)
    }

    @Test
    fun test_articleDescription() {
        composeRule.setContent {
            NMGTheme {
                Text("articleDescription", style = defaultTypography.articleDescription)
            }
        }

        compareScreenshot(composeRule)
    }
}
