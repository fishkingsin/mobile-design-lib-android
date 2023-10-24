package com.nmg.mobiledesignlibrary

import android.util.Log
import androidx.test.ext.junit.rules.activityScenarioRule
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import com.karumi.shot.ScreenshotTest
import com.nmg.mobile.design.gallery.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest : ScreenshotTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun activityTest() {
        val activity = launchActivity()
        activityScenarioRule.scenario.use {
            compareScreenshot(it.waitForActivity())
        }
    }

    // Hack needed until we fully support Activity Scenarios
    private fun launchActivity(): MainActivity {
        var activity: MainActivity? = null
        activityScenarioRule.scenario.onActivity {
            activity = it
        }
        while (activity == null) {
            Log.d("MainActivityTest", "Waiting for activity to be initialized")
        }
        return activity!!
    }
}
