package com.example.notifications.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val builder = context?.let {
                NotificationCompat.Builder(it, "2")
                    .setContentTitle("AirplaneMode")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }

            if (intent.getBooleanExtra("state", false)
            ) {
                builder?.setSmallIcon(com.google.android.material.R.drawable.abc_ic_menu_share_mtrl_alpha)
                builder?.setContentText("Mode is active")
            } else {
                builder?.setSmallIcon(com.google.android.material.R.drawable.abc_ic_menu_share_mtrl_alpha)
                builder?.setContentText("Mode is not active")
            }

            context?.let {
                NotificationManagerCompat.from(it).apply {
                    builder?.let { it1 -> this.notify(Random.nextInt(), it1.build()) }
                }
            }
        }
    }
}