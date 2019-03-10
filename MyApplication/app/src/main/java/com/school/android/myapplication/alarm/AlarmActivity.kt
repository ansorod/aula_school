package com.school.android.myapplication.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.school.android.myapplication.R
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        setAlarmButton.setOnClickListener(View.OnClickListener {
            setAlarm()
        })
    }

    private fun setAlarm() {
        Log.i(TAG, "setAlarm");
        val alarm = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        // Lembrando que ao utilizar o método setRepeating o intervalo mínimo é de 1 minuto,
        // caso o valor seja menor o Android irá mostrar uma mensagem no Log avisando
        // que o intervalo será de 1 minuto
        alarm.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5000, pendingIntent)
    }

    companion object {
        const val TAG = "tag_alarm"
    }
}
