package com.example.melodiesringer

import android.app.Notification
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.telecom.Call
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.annotation.RequiresApi

class MelRingService : Service() {

    private val isRunning = false

    override fun onCreate() {

        super.onCreate()
    }



    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        while (isRunning){

        }

        return START_STICKY;
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}