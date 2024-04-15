package ca.georgiancollege.comp3025_w2024_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.comp3025_w2024_week8.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    // Declare an instance of the binding class
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Read TV shows data from JSON file
        val tvShowsJsonString = resources.openRawResource(R.raw.shows).bufferedReader().use { it.readText() }

        try {
            val jsonObject = JSONObject(tvShowsJsonString)
            val tvShowsJsonArray = jsonObject.getJSONArray("tv_shows")

            // Parse JSON array to create a list of TVShow objects
            val tvShowsList = mutableListOf<TVShow>()
            for (i in 0 until tvShowsJsonArray.length()) {
                val tvShowObject = tvShowsJsonArray.getJSONObject(i)
                val title = tvShowObject.getString("title")
                val rating = tvShowObject.getString("rating")
                val seasons = tvShowObject.getString("seasons")
                val genre = tvShowObject.getString("genre")
                tvShowsList.add(TVShow(title,seasons, rating, genre))
            }

            // Convert MutableList to Array
            val tvShowsArray: Array<TVShow> = tvShowsList.toTypedArray()

            val firstAdapter = FirstAdapter(tvShowsArray)
            // Use view binding to replace findViewById or synthetic properties
            binding.FirstRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = firstAdapter
            }
        } catch (e: JSONException) {
            Log.e("JSON_FETCH", "Error parsing JSON", e)
        }
    }
}
