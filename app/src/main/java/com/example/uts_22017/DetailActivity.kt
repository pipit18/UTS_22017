package com.example.movieselector

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("TITLE")
        val watchFor = intent.getStringExtra("WATCH_FOR")
        val genres = intent.getStringExtra("GENRES")
        val year = intent.getStringExtra("YEAR")
        val durationHour = intent.getStringExtra("DURATION_HOUR")
        val durationMinutes = intent.getStringExtra("DURATION_MINUTES")

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)
        textViewDetails.text = "Title: $title\nWatch For: $watchFor\nGenres: $genres\nYear: $year\nDuration: ${durationHour}h ${durationMinutes}m"
    }
}
