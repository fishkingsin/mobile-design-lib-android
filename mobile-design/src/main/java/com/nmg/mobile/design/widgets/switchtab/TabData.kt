package com.nmg.mobile.design.widgets.switchtab

interface TabData {
    val title: String
}

data class SimpleTabData(override val title: String) : TabData
