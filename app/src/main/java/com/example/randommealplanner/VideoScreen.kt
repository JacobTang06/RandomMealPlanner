package com.example.randommealplanner

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VideoScreen:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_screen)

        val youtubeTextView = findViewById<TextView>(R.id.youtubeLink)

        val intent = intent
        var videoURL = intent.getStringExtra("video")

        youtubeTextView.text = videoURL
    }
}