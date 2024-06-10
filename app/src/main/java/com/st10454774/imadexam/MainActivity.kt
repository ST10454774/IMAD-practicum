package com.st10454774.imadexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView =findViewById<ImageView>(R.id.imageView)
        val etAppName= findViewById<TextView>(R.id.etAppName)
        val etStudentNumber = findViewById<TextView>(R.id.etStudentNumber)
        val btnNextScreen = findViewById<Button>(R.id.btnNextScreen)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)
        btnNextScreen.setOnClickListener {
            // call the next screen
            val intent = Intent (this,MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}