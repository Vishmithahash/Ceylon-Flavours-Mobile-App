package com.example.ceylonflavours

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // Setting Page Options
        val itemAchievements = findViewById<LinearLayout>(R.id.itemAchievements)
        val itemNotifications = findViewById<LinearLayout>(R.id.itemNotifications)
        val itemLogout = findViewById<LinearLayout>(R.id.itemLogout)
        val itemRateUs = findViewById<LinearLayout>(R.id.itemRateUs)
        val itemAboutUs = findViewById<LinearLayout>(R.id.itemAbout)
        val itemHelp = findViewById<LinearLayout>(R.id.itemHelp)

        itemAchievements.setOnClickListener {
            val intent = Intent(this, Achievements::class.java)
            startActivity(intent)
        }

        itemNotifications.setOnClickListener {
            val intent = Intent(this, Notifications::class.java)
            startActivity(intent)
        }

        itemLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        itemRateUs.setOnClickListener {
            val intent = Intent(this, RateUs::class.java)
            startActivity(intent)
        }

        itemAboutUs.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

        itemHelp.setOnClickListener {
            val intent = Intent(this, Help::class.java)
            startActivity(intent)
        }


        val imageButtonCart = findViewById<ImageButton>(R.id.imageButton2)
        imageButtonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }

        val imageButtonReservation = findViewById<ImageButton>(R.id.imageButton1)
        imageButtonReservation.setOnClickListener {
            val intent = Intent(this, Reservation::class.java)
            startActivity(intent)
        }

        val imageButtonHome = findViewById<ImageButton>(R.id.imageButton3)
        imageButtonHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val imageButtonProfile = findViewById<ImageButton>(R.id.imageButton4)
        imageButtonProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}
