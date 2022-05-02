package com.example.melodiesringer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MusicListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_list)
        val closeButton = findViewById<ImageView>(R.id.imageView4)
        closeButton.setOnClickListener {
           finishAndRemoveTask()
        }
        }
    }