package com.example.android.firstweekchallenge

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment


class CustomDialog : DialogFragment() {
    enum class TAG {
        FULLNAME, PHONE
    }
    var activityCallback: OnFragmentManager? = null
    var tag: TAG ?= null
    interface OnFragmentManager {
        fun onDataSelected(data: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        super.onAttach(context)
        if (context is OnFragmentManager) {
            activityCallback = context
        } else {
            throw RuntimeException("$context must implement onViewSelected")
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val alertDialogBuilder = AlertDialog.Builder(activity)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val edt = dialogLayout.findViewById<EditText>(R.id.editText)
        alertDialogBuilder.setTitle("Enter information!")
        alertDialogBuilder.setView(dialogLayout)
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            val use = edt!!.text.toString()
            Toast.makeText(activity, "User:   $use", Toast.LENGTH_SHORT).show()
            activityCallback?.onDataSelected(use)
        }
        return alertDialogBuilder.create()
    }
}