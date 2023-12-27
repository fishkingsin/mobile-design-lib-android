package com.nmg.mobile.design.widgets

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.hashtagsmentionstextview.HashtagsMentionsTextView
import java.lang.Thread.sleep
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HashtagsMentionsTextViewTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_HashtagsMentionsTextView() {
        composeRule.setContent {
            NMGTheme {
                val string =
                    "I am #hashtags or #hashtags# and @mentions in Jetpack Compose. I am #hashtags or #hashtags# and @mentions in Jetpack Compose. 這是在 Jetpack Compose 中的一個 #標簽 和 @提及 的超鏈接。 這是在 Jetpack Compose 中的一個 #標簽 和 @提及 的超鏈接。"

                HashtagsMentionsTextView(string, Modifier.padding(16.dp)) {
                    println(it)
                }
            }
        }
        sleep(500)
        compareScreenshot(composeRule)
    }
}
