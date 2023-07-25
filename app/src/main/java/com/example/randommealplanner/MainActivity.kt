package com.example.randommealplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.buttonTitle)

        button.setOnClickListener { yellowButtonClicked() }


    }

    private fun yellowButtonClicked() {
        Log.d("OnClick", "clicked button")
        val i = Intent(this, SecondScreen::class.java)
        startActivity(i)
    }
}