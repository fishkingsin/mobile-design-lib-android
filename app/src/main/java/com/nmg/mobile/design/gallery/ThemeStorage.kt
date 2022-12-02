package com.nmg.mobile.design.gallery

import android.content.Context
import android.content.SharedPreferences

public object ThemeStorage {
    fun setThemeColor(context: Context, themeColor: String?) {
        val sharedpreferences: SharedPreferences =
            context.getSharedPreferences("theme_data", Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.putString("theme", themeColor)
        editor.apply()
    }

    fun getThemeColor(context: Context): String? {
        val sharedpreferences: SharedPreferences =
            context.getSharedPreferences("theme_data", Context.MODE_PRIVATE)
        return sharedpreferences.getString("theme", "grey")
    }
}