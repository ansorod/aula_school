package com.school.android.myapplication.bound

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.school.android.myapplication.R
import kotlinx.android.synthetic.main.activity_bound.*

class BoundActivity : AppCompatActivity() {

    private var mService : CountDownService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound)

        startCountingButton.setOnClickListener(View.OnClickListener {
            mService?.startCounting()
        })

        stopCountingButton.setOnClickListener(View.OnClickListener {
            mService?.stopCounting()
        })

        updateButton.setOnClickListener(View.OnClickListener {
            countDownView.text = mService?.getCount().toString()
        })
    }

    override fun onResume() {
        super.onResume()
        bind()
    }

    override fun onPause() {
        super.onPause()
        unbind()
    }

    private fun bind() {
        val serviceIntent = Intent(this, CountDownService::class.java)
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE)
    }

    private fun unbind() {
        unbindService(mConnection)
    }

    private val mConnection = object : ServiceConnection {


        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.i(TAG, "Serviço Conectado");
            var binder = p1 as CountDownService.CountDownBinder
            mService = binder.getService()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.i(TAG, "Serviço desconectado")
            mService = null
        }
    }

    companion object {
        const val TAG = "tag_bound_service"
    }

}
