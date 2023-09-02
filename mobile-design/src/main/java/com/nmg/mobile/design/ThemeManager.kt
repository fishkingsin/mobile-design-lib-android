package com.nmg.mobile.design

import android.content.Context

//class ThemeManager : ThemeManageable {
//    companion object {
//        @Volatile
//        private var INSTANCE: ThemeManager? = null
//
//        fun getInstance(): ThemeManager = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: ThemeManager().also {  INSTANCE = it }
//        }
//    }
//
//    private var _currentTheme: NMGThemeable? = null
//
//    override val currentTheme: NMGThemeable
//        get() = _currentTheme!!
//
//
//    override fun applyTheme(theme: NMGThemeable) {
//        _currentTheme = theme
//    }
//}