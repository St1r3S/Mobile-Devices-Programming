package com.example.dialogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.dialogs.dialogfragments.AirplaneModeDialogFragment
import com.example.dialogs.dialogfragments.BatteryDialogFragment
import com.example.dialogs.dialogfragments.CameraButtonDialogFragment

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secont_activity)
        val i = intent
        val id = i.getIntExtra("dialog_id", 0)
        val dialog: DialogFragment
        when (id) {
            1 -> {
                dialog = BatteryDialogFragment()
                dialog.show(supportFragmentManager, "batteryDialogShow")
            }
            2 -> {
                dialog = AirplaneModeDialogFragment()
                dialog.show(supportFragmentManager, "airplaneDialogShow")
            }
            3 -> {
                dialog = CameraButtonDialogFragment()
                dialog.show(supportFragmentManager, "cameraDialogShow")
            }
        }
    }

}

