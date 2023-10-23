package com.nmg.mobile.design.uistate

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.uistate.LoadDataStatus
import com.nmg.mobile.design.widgets.uistate.LoadDataStatusModel
import com.nmg.mobile.design.widgets.uistate.LoadDataStatusView
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoadDataStatusViewTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test_LoadDataStatusView() {
        composeRule.setContent {
            NMGTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth(),
                    ) {
                        LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.LOADING))
                    }

                    Box(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth(),
                    ) {
                        LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.ERROR, message = "error"))
                    }

                    Box(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth(),
                    ) {
                        LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.ERROR, message = "no data"))
                    }
                }
            }
        }
        Thread.sleep(5000)
        compareScreenshot(composeRule)
    }
}