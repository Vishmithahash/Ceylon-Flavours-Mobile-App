package com.example.ceylonflavours

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RateUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)

        val buttonBack = findViewById<ImageButton>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
            finish()
        }

        val buttonSubmit = findViewById<Button>(R.id.buttonSubmitRating)
        buttonSubmit.setOnClickListener {
            Toast.makeText(this, "Thank you for your rating!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}
