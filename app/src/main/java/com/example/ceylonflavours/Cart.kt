package com.example.ceylonflavours

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButtonHome = findViewById<ImageButton>(R.id.imageButton3)
        imageButtonHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val imageButtonReservation = findViewById<ImageButton>(R.id.imageButton1)
        imageButtonReservation.setOnClickListener {
            val intent = Intent(this, Reservation::class.java)
            startActivity(intent)
        }

        val imageButtonProfile = findViewById<ImageButton>(R.id.imageButton4)
        imageButtonProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val imageButtonSetting = findViewById<ImageButton>(R.id.imageButton5)
        imageButtonSetting.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }

        val buttonCheckout = findViewById<Button>(R.id.buttonCheckout)
        buttonCheckout.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
        }
    }
}
