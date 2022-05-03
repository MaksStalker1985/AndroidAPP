package com.example.melodiesringer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class Autostart : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("Autostart.onReceive() is not implemented")
        val mr = melodiesRingerService()
    }
}