package com.example.randommealplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFoodRecipeURL()
    }

    private fun getFoodRecipeURL() {
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
                //var movieImageArray = json.jsonObject.getJSONArray("items")
            }

        }]
    }
}