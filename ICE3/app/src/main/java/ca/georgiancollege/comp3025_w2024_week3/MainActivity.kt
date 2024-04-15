package ca.georgiancollege.comp3025_w2024_week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import ca.georgiancollege.comp3025_w2024_week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // operator buttons
        binding.clearButton.setOnClickListener{ view -> processOperatorButtons(view)}
        binding.percentButton.setOnClickListener{view -> processOperatorButtons(view)}

        // number buttons
        binding.zeroButton.setOnClickListener{view -> processNumberButtons(view)}
    }

    private fun processOperatorButtons(view: View)
    {
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        Log.i("operators", view.tag.toString())
        resultTextView.text = view.tag.toString()
    }

    private fun processNumberButtons(view: View)
    {
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        Log.i("operators", view.tag.toString())
        resultTextView.text = view.tag.toString()
    }
}