package com.st10454774.imadexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvDetailedInfo: TextView
    private lateinit var tvAverageScreenTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize views
        tvDetailedInfo = generateDetailedInfo
        val tvAverageScreenTime = findViewById(R.id.tvAverageScreenTime)

        // Retrieve data from parallel arrays
        val detailedInfo = generateDetailedInfo()
        tvDetailedInfo.text = detailedInfo

        // Calculate average screen time
        val averageTime = DataManager.calculateAverageScreenTime()
        tvAverageScreenTime.text = "Average screen time: ${averageTime} minutes"
        // convert = hours + remaining mins
    }

    private fun generateDetailedInfo(): String) {
        val builder = StringBuilder()

        for (i in 0 until DataManager.strDate.size) {
            val date = DataManager.strDate[i]
            val morningTime = DataManager.intMorning[i]
            val afternoonTime = DataManager.intAfternoon[i]
            val notes = DataManager.strNotes[i]

            // Format the string for each days activity
            val formattedDayInfo = """
                $date\n
                Morning:$morningTime min | Afternoon: $afternoonTime min\n 
                Notes: $notes
                
            """.trimIndent()

            builder.append.toString()
        }

        return builder.toString()
    }
}