package com.example.melodiesringer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val system_switch = findViewById<Switch>(R.id.switch1)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("melodies ringer",Context.MODE_PRIVATE)
        val i = sharedPreferences.all
       /* if(i["status"] == 1){
            system_switch.isChecked = true
        }else{

        }*/
        val aboutButton = findViewById<Button>(R.id.aboutBtn)
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        val musicListButton = findViewById<Button>(R.id.musicListButton)
        musicListButton.setOnClickListener{
                val intent = Intent (this, MusicListActivity::class.java)
                startActivity(intent)
            }
        val intt = Intent(this,MelRingService::class.java)
        this.startService(intt)

        system_switch.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                try {
                    editor.clear()
                    editor.putInt("status", 1)
                    val myToast = Toast.makeText(applicationContext,"Melodies Ringer Enabled",Toast.LENGTH_SHORT)
                    myToast.show()
                }
                catch (e:Exception){

                }
            }else{
                try {
                    editor.clear()
                    editor.putInt("status", 0)
                    val myToast = Toast.makeText(applicationContext,"Melodies Ringer Disabled",Toast.LENGTH_SHORT)
                    myToast.show()
                }catch (e:Exception){

                }
            }
        }

        }


    }
