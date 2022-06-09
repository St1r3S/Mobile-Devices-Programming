package com.example.notifications.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class CameraButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_CAMERA_BUTTON) {
            val builder = context?.let {
                NotificationCompat.Builder(it, "3")
                    .setSmallIcon(com.google.android.material.R.drawable.abc_ic_menu_share_mtrl_alpha)
                    .setContentTitle("Camera")
                    .setContentText("Camera button pressed")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }

            context?.let {
                NotificationManagerCompat.from(it).apply {
                    builder?.let { it1 -> this.notify(Random.nextInt(), it1.build()) }
                }
            }
        }
    }
}