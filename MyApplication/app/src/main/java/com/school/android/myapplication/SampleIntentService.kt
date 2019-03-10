package com.school.android.myapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

class SampleIntentService : IntentService("AnyName") {

    override fun onHandleIntent(p0: Intent?) {
        while(true) {
            Log.i("tag_intent_service", "onStartCommand")
            Thread.sleep(10000)
        }
    }
}