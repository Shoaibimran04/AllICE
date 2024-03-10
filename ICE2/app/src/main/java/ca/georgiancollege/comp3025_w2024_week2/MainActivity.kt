package ca.georgiancollege.comp3025_w2024_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetTextView = findViewById<TextView>(R.id.greetingTextView)

        Log.i("onCreate", "Saying Hello")

        val clickMeButton = findViewById<Button>(R.id.clickMeButton)

        clickMeButton.setOnClickListener { greetTextView.text = if(greetTextView.text == "Hello, World!") "Good Bye,World!" else "Hello, World!"}
    }
}