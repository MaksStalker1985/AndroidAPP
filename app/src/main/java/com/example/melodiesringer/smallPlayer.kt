package com.example.melodiesringer

import android.media.MediaPlayer
import android.net.Uri
import kotlin.random.Random

class smallPlayer {
    private var status : Boolean = false
    private var musicContent : MusicContent = TODO()
    private var musicList : Array<MusicContent>
    private var db = Database_Processor()
    private var activeList : Array<MusicContent>

    private fun initPlayList(){
        musicList = db.readData()
    }
    public fun startPlay(){
        musicContent = activeList[0]
        var mPlayer = MediaPlayer.create(this, Uri.parse(musicContent.SongPath))

    }
    public fun stopPlay(){

    }
    public fun loadPlayList(){
        initPlayList()
        for (music in musicList){
            if(music.IsActive == 1){
                activeList += music
            }else{

            }
        }

    }
}