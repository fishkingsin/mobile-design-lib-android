package com.nmg.mobile.design.gallery

import android.app.Dialog
import android.content.Context
import android.widget.TextView

object DialogManager {
    fun showCustomAlertDialog(
        context: Context,
        callback: ColorDialogCallback,
    ) {
        val dialog = Dialog(context)

//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.theme_pallete)
        val ed: TextView = dialog.findViewById(R.id.ed)
        ed.setOnClickListener {
            callback.onChosen(ed.text.toString())
            dialog.cancel()
        }
        val ww: TextView = dialog.findViewById(R.id.ww)
        ww.setOnClickListener {
            callback.onChosen(ww.text.toString())
            dialog.cancel()
        }
        val more: TextView = dialog.findViewById(R.id.more)
        more.setOnClickListener {
            callback.onChosen(more.text.toString())
            dialog.cancel()
        }
        val kiss: TextView = dialog.findViewById(R.id.kiss)
        kiss.setOnClickListener {
            callback.onChosen(kiss.text.toString())
            dialog.cancel()
        }
        val nm: TextView = dialog.findViewById(R.id.nm)
        nm.setOnClickListener {
            callback.onChosen(nm.text.toString())
            dialog.cancel()
        }
        val os: TextView = dialog.findViewById(R.id.os)
        os.setOnClickListener {
            callback.onChosen(os.text.toString())
            dialog.cancel()
        }
        val gotrip: TextView = dialog.findViewById(R.id.gotrip)
        gotrip.setOnClickListener {
            callback.onChosen(gotrip.text.toString())
            dialog.cancel()
        }
        val oh: TextView = dialog.findViewById(R.id.oh)
        oh.setOnClickListener {
            callback.onChosen(oh.text.toString())
            dialog.cancel()
        }
        dialog.show()
    }
}
