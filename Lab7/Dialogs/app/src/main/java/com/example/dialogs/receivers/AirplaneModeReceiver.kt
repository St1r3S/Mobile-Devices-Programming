package com.example.dialogs.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.dialogs.DialogActivity

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val i = Intent(context, DialogActivity::class.java)
            i.putExtra("dialog_id", 2)
            context?.startActivity(i)
        }
    }
}