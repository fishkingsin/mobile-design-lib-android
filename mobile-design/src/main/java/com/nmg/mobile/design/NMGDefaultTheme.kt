package com.nmg.mobile.design

import android.content.Context

public class NMGDefaultTheme(_customColors: () -> NMGThemeableColors, _customIcons: () -> NMGThemeableIcons) : NMGThemeable {
    override var colors: NMGThemeableColors = _customColors()
    override var icons: NMGThemeableIcons = _customIcons()
}