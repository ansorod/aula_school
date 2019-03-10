package com.school.android.myapplication.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {

    // Método chamado quando um novo token é gerado.
    // O token identifica um usuário específico e pode ser
    // utilizado para que este usuário receba mensagens via FCM
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.i(TAG, "onNewToken")
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        super.onMessageReceived(message)
        Log.i(TAG, "Message received")


        message?.let {
            message.data.keys.forEach {
                val value = message.data[it]
                Log.i(TAG, "Key: $it Value: $value")
            }
        }
    }

    companion object {
        const val TAG = "tag_fcm"
    }
}