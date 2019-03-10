package com.school.android.myapplication.bound

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.Binder
import android.os.IBinder
import android.util.Log

class CountDownService : Service() {

    private val mBinder = CountDownBinder()
    private var mCurrentValue = 0
    private var mTask: ServiceTask? = null

    override fun onBind(intent: Intent): IBinder? {
        return mBinder
    }

    inner class CountDownBinder : Binder() {
        fun getService(): CountDownService {
            return this@CountDownService
        }
    }

    fun stopCounting() {
        mTask?.cancel(true)
    }

    fun startCounting() {
        if(mTask == null || mTask?.status != AsyncTask.Status.RUNNING && mTask?.status != AsyncTask.Status.PENDING) {
            mCurrentValue = 0
            mTask = ServiceTask()
            mTask?.execute()
        }
    }

    fun getCount() : Int {
        return mCurrentValue
    }

    private inner class ServiceTask : AsyncTask<Void, Int, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            while(true) {
                Log.i(TAG, "Counting...")
                Thread.sleep(1000)
                mCurrentValue++
            }
        }
    }

    companion object {
        const val TAG = "tag_bound_service"
    }
}
