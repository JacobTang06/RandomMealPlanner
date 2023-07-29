package com.example.randommealplanner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class SecondScreen : AppCompatActivity() {
    private lateinit var foodInstructions:String
    private lateinit var foodURL:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen_layout)

        var foodName = findViewById<TextView>(R.id.mealName)
        var foodImage = findViewById<ImageView>(R.id.mealImage)

        var foodCuisine = findViewById<TextView>(R.id.mealCuisine)
        var foodType = findViewById<TextView>(R.id.mealCategory)

        getFoodRecipeURL(foodImage, foodName, foodCuisine, foodType)

        val foodInstructionButton: Button = findViewById(R.id.mealInstructions)

        foodInstructionButton.setOnClickListener { ingredientButtonClicked() }

        val foodVideoButton : Button = findViewById(R.id.videoButton)

        foodVideoButton.setOnClickListener { videoButtonClicked() }
    }

    private fun getFoodRecipeURL(foodImage:ImageView, foodName:TextView, foodCuisine:TextView, foodType:TextView) {
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
                var mealName = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strMeal")
                var mealCategory = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strCategory")
                var mealCuisine = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strArea")
                var mealThumbnail = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strMealThumb")
                var mealVideo = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strYoutube")
                var mealInstructions = json.jsonObject.getJSONArray("meals").getJSONObject(0).getString("strInstructions")

                foodName.text = mealName
                foodCuisine.text = "Cuisine: " + mealCuisine
                foodType.text = "Category: " + mealCategory
                foodInstructions = mealInstructions
                foodURL = mealVideo

                Glide.with(this@SecondScreen)
                    .load(mealThumbnail)
                    .fitCenter()
                    .into(foodImage)


            }

        }]
    }

    private fun ingredientButtonClicked() {
        val i = Intent(this, InstructionScreen::class.java)
        i.putExtra("instructions", foodInstructions)
        startActivity(i)
    }

    private fun videoButtonClicked() {
        val i = Intent(this, VideoScreen::class.java)
        i.putExtra("video", foodURL)
        startActivity(i)
    }
}