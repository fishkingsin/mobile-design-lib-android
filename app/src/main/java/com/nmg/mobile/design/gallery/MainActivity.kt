package com.nmg.mobile.design.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nmg.mobile.design.gallery.demo.ComposeDemoFragment

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ComposeDemoFragment())
            .commit()
        // legacy
//        setContentView(R.layout.activity_main)
    }
}

interface ColorDialogCallback {
    fun onChosen(chosenColor: String?)
}
