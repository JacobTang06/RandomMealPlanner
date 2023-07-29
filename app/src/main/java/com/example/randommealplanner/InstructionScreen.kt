package com.example.randommealplanner

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class InstructionScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instruction_screen)

        var instructionsText = findViewById<TextView>(R.id.instructions)
        val intent = intent

        instructionsText.text = intent.getStringExtra("instructions")
        instructionsText.movementMethod = ScrollingMovementMethod()


    }

}