package com.example.melodiesringer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class Autostart : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        when(intent.action){
            Intent.ACTION_BOOT_COMPLETED ->{
                val startIntent = Intent(context,MelRingService::class.java)
                context.startService(startIntent)
            }
        }


    }
}