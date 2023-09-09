package com.nmg.mobile.design.theme

import android.content.Context
import android.content.res.Resources
import com.nmg.mobile.design.R

public object ThemeManager {
    fun getThem(context: Context): Resources.Theme {
        return context.theme
    }

    public fun setCustomizedThemes(context: Context, theme: String?) {
        when (theme) {
            "ww" -> context.setTheme(R.style.WW)
            "ed" -> context.setTheme(R.style.ED)
            "more" -> context.setTheme(R.style.MORE)
            "kiss" -> context.setTheme(R.style.KISS)
            "nm" -> context.setTheme(R.style.NM)
            "gotrip" -> context.setTheme(R.style.GOTRIP)
            "os" -> context.setTheme(R.style.OS)
            "oh" -> context.setTheme(R.style.OH)
        }
    }
}