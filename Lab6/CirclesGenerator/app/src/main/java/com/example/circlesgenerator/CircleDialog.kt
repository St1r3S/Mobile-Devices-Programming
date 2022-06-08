package com.example.circlesgenerator

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class CircleDialog: DialogFragment() {

    private var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        num = arguments?.getInt("number") as Int
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Number")
            .setMessage("You choose number: $num")
            .setPositiveButton("Ok", null)
            .create()
    }

    companion object {
        fun newInstance(number: Int): CircleDialog {
            val args = Bundle()
            args.putInt("number", number)
            val fragment = CircleDialog()
            fragment.arguments = args
            return fragment
        }
    }
}