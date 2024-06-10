package com.st10454774.imadexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.text.ParseException
import android.widget.Toast
import java.util.Locale

class MainScreen : AppCompatActivity() {

    private lateinit var etDate: EditText
    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText
    private lateinit var tvErrors: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        // Initialize views
        var etDate = findViewById<TextView>(R.id.etDate)
        var etMorning = findViewById<TextView>(R.id.etMorning)
        var etAfternoon = findViewById<TextView>(R.id.etAfternoon)
        var etNotes = findViewById<TextView>(R.id.etNotes)

        val btnSave: Button = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            saveData()
        }

        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener {
            clearForm()
        }

        val btnGoToDetail: Button = findViewById(R.id.btnGoToDetail)
        btnClear.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }
    }

    private fun saveData() {
        val date = etDate.text.toString()
        val morningStr = etMorning.text.toString()
        val afternoonStr = etAfternoon.text.toString()
        val notes = etNotes.text.toString()

        val errors = mutableListOf<String>()

        if (DataManager.getNumberOfDays() <= 7){

            // Validate date format
            try {
                val dateFormat = SimpleDateFormat("d MMM yyyy", Locale.US)

                dateFormat.parse(date) // Check if parsing succeeds
            } catch (e: ParseException) {
                errors.add("Invalid date format, Use format: 6 June 2024")
            }

            // Validate morning and afternoon screen time
            val morning = morningStr.toIntOrNull()
            val afternoon = afternoonStr.toIntOrNull()

            if (morning == null || afternoon == null) {
                errors.add("Morning and afternoon screen time must be numeric.")
            } else {
                if (morning < 0 || morning > 240) {
                    errors.add("Morning screen time must be between 0 and 240 minutes.")
                }
                if (afternoon < 0 || afternoon > 240) {
                    errors.add("Afternoon screen time must be between 0 and 240 minutes.")
                }
            }

            // Display error messages (if any)
            if (errors.isNotEmpty()) {
                val errorMessage = errors.joinToString("\n")
                tvErrors.text = errorMessage
                return
            }

            // Save data to parallel arrays
            DataManager.saveData(date, morning, afternoon, notes)
            // Toast message .. successfully saved

            // Clear input fields for next input
            etDate.text.clear()
            etMorning.text.clear()
            etAfternoon.text.clear()
            etNotes.text.clear()
            } else {
                Toast message "You have already saved 7 days of information"
                return
            }
         }

         private fun clearForm() {
             etDate.text.clear()
             etMorning.text.clear()
             etAfternoon.text.clear()
             etNotes.text.clear()
         }
    }