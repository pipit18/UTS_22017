package com.example.movieselector

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTitle: EditText = findViewById(R.id.editTextTitle)
        val radioGroupWatchFor: RadioGroup = findViewById(R.id.radioGroupWatchFor)
        val checkBoxThriller: CheckBox = findViewById(R.id.checkBoxThriller)
        val checkBoxHorror: CheckBox = findViewById(R.id.checkBoxHorror)
        val checkBoxAction: CheckBox = findViewById(R.id.checkBoxAction)
        val checkBoxRomance: CheckBox = findViewById(R.id.checkBoxRomance)
        val checkBoxComedy: CheckBox = findViewById(R.id.checkBoxComedy)
        val checkBoxFantasy: CheckBox = findViewById(R.id.checkBoxFantasy)
        val editTextYear: EditText = findViewById(R.id.editTextYear)
        val spinnerDurationHour: Spinner = findViewById(R.id.spinnerDurationHour)
        val spinnerDurationMinutes: Spinner = findViewById(R.id.spinnerDurationMinutes)
        val buttonOk: Button = findViewById(R.id.buttonOk)

        buttonOk.setOnClickListener {
            val title = editTextTitle.text.toString()
            val watchFor = when (radioGroupWatchFor.checkedRadioButtonId) {
                R.id.radioButtonAdult -> "Adult (17+)"
                R.id.radioButtonKids -> "Kids"
                else -> ""
            }
            val genres = mutableListOf<String>()
            if (checkBoxThriller.isChecked) genres.add("Thriller")
            if (checkBoxHorror.isChecked) genres.add("Horror")
            if (checkBoxAction.isChecked) genres.add("Action")
            if (checkBoxRomance.isChecked) genres.add("Romance")
            if (checkBoxComedy.isChecked) genres.add("Comedy")
            if (checkBoxFantasy.isChecked) genres.add("Fantasy")
            val year = editTextYear.text.toString()
            val durationHour = spinnerDurationHour.selectedItem.toString()
            val durationMinutes = spinnerDurationMinutes.selectedItem.toString()

            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("TITLE", title)
                putExtra("WATCH_FOR", watchFor)
                putExtra("GENRES", genres.joinToString())
                putExtra("YEAR", year)
                putExtra("DURATION_HOUR", durationHour)
                putExtra("DURATION_MINUTES", durationMinutes)
            }
            startActivity(intent)
        }
    }
}
