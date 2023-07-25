package com.example.randommealplanner

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class InstructionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instruction_screen)

        var instructionsText = findViewById<TextView>(R.id.instructions)


        getFoodInstructionsURL(instructionsText)

    }

    private fun getFoodInstructionsURL(instructionsText:TextView) {
        val client = AsyncHttpClient()

        client["https:themealdb.com/api/json/v1/1/random.php", object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe", response)
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JsonHttpResponseHandler.JSON) {
                Log.d("Recipe", "success$json")

                var mealInstructions = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strInstructions")

                instructionsText.text = mealInstructions
            }

        }]
    }
}