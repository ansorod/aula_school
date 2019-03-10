package com.school.android.myapplication.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.school.android.myapplication.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("jamal", "onReceive")
        setNotification(context)
    }

    private fun setNotification(context: Context) {
        createNotificationChannel(context)
        val notification = NotificationCompat.Builder(context.applicationContext, "com.school.jamal")
            .setContentTitle("AlarmManager")
            .setContentText("O Tempo acabou!")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(12, notification)
    }

    private fun createNotificationChannel(context: Context) {
        val channel = NotificationChannel("com.school.jamal", "Ordinary Name", NotificationManager.IMPORTANCE_HIGH)
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }
}
