package com.example.melodiesringer

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.IBinder
import android.telecom.Call
import android.telecom.Call.Details
import androidx.annotation.RequiresApi

class melodiesRingerService : Service() {

    final var _status : Boolean = false
    public val listener  : Call.Details = TODO()
    public var playing : Boolean = false
    override fun onCreate() {
        super.onCreate()
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try{
            _status = readSettings()
        }catch (e:Exception){

        }
        if (_status){
            if(listener.state == Call.STATE_DIALING){
                
            }else{

            }
        }else{

        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun readSettings () : Boolean{
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("melodies ringer",Context.MODE_PRIVATE)
        if(sharedPreferences.getInt("status",0) == 1){
            return true
        }else{
            return false
        }

    }
}