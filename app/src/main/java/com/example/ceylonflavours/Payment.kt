package com.example.ceylonflavours

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val backButton = findViewById<ImageButton>(R.id.buttonBack)
        backButton.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }


        val payNowButton = findViewById<Button>(R.id.buttonPayNow)
        payNowButton.setOnClickListener {
            Toast.makeText(this, "Payment Successful! Thank you for your order.", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
