package com.example.dialogs.dialogfragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogs.MainActivity

class AirplaneModeDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return if(Settings.System.getInt(context?.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0){
            AlertDialog.Builder(requireActivity())
                .setTitle("AirplaneMode")
                .setMessage("Mode is active")
                .setPositiveButton("Ok") { _, _ ->
                    returnToMain()
                }
                .create()
        }else{
            AlertDialog.Builder(requireActivity())
                .setTitle("AirplaneMode")
                .setMessage("Mode is not active")
                .setPositiveButton("Ok") { _, _ ->
                    returnToMain()
                }
                .create()
        }
    }
    private fun returnToMain() {
        val i = Intent(context, MainActivity::class.java)
        startActivity(i)
    }
}