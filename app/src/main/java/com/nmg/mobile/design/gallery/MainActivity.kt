package com.nmg.mobile.design.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nmg.mobile.design.gallery.DialogManager.showCustomAlertDialog
import com.nmg.mobile.design.gallery.ThemeManager.setCustomizedThemes
import com.nmg.mobile.design.gallery.ThemeStorage.getThemeColor
import com.nmg.mobile.design.gallery.ThemeStorage.setThemeColor

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }
}

interface ColorDialogCallback {
    fun onChosen(chosenColor: String?)
}