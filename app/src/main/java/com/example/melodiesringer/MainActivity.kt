package com.example.melodiesringer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val aboutButton = findViewById<Button>(R.id.aboutBtn)
        val musicListButton = findViewById<Button>(R.id.musicListButton)
        musicListButton.setOnClickListener{
                val intent = Intent (this, MusicListActivity::class.java)
                startActivity(intent)
            }

        }


    }
