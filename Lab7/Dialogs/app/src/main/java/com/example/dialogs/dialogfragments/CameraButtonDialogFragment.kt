package com.example.dialogs.dialogfragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogs.MainActivity

class CameraButtonDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Camera")
            .setMessage("Camera button pressed")
            .setPositiveButton("Ok") { _, _ ->
                returnToMain()
            }
            .create()
    }
    private fun returnToMain() {
        val i = Intent(context, MainActivity::class.java)
        startActivity(i)
    }
}
