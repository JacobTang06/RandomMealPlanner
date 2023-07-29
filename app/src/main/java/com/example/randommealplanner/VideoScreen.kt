package com.example.randommealplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class VideoScreen:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_screen)

        val intent = intent
        var videoURL = intent.getStringExtra("video")

    }
}