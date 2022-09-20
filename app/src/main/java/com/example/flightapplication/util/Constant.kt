package com.example.flightapplication.util

import android.app.Activity
import android.app.Dialog
import com.example.flightapplication.R

object Constant {

    lateinit var dialog: Dialog
    fun showDialog(activity: Activity) {
        dialog = Dialog(activity).apply {
            //setContentView(R.layout.dialog_loading)
            //setCancelable(true)
        }
        dialog.show()
    }
}