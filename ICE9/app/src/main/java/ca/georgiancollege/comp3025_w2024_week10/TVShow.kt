package ca.georgiancollege.comp3025_w2024_week10

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShow(
    val title: String,
    val studio: String
)

