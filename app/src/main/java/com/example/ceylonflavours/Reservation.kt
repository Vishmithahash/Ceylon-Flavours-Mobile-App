package com.example.ceylonflavours

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import java.util.Calendar

class Reservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reservation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewDate = findViewById<TextView>(R.id.textViewDate)
        val buttonDate = findViewById<ImageButton>(R.id.buttonDate)
        val textViewTime = findViewById<TextView>(R.id.textViewTime)
        val buttonTime = findViewById<ImageButton>(R.id.buttonTime)
        val textViewMembers = findViewById<TextView>(R.id.textViewMembers)
        val buttonPlus = findViewById<ImageButton>(R.id.buttonPlus)
        val buttonMinus = findViewById<ImageButton>(R.id.buttonMinus)
        val editTextAdditional = findViewById<EditText>(R.id.editTextAdditional)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        val calendar = Calendar.getInstance()

        // Date Picker
        buttonDate.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val dateText = "${selectedDay.toString().padStart(2, '0')}/" +
                        "${(selectedMonth + 1).toString().padStart(2, '0')}/$selectedYear"
                textViewDate.text = dateText
            }, year, month, day)

            datePickerDialog.show()
        }

        // Time Picker
        buttonTime.setOnClickListener {
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val amPm = if (selectedHour >= 12) "PM" else "AM"
                val hourFormatted = if (selectedHour % 12 == 0) 12 else selectedHour % 12
                val timeText = "${hourFormatted.toString().padStart(2, '0')}:" +
                        "${selectedMinute.toString().padStart(2, '0')} $amPm"
                textViewTime.text = timeText
            }, hour, minute, false)

            timePickerDialog.show()
        }

        // Member count logic
        var memberCount = 5
        textViewMembers.text = memberCount.toString()

        buttonPlus.setOnClickListener {
            memberCount++
            textViewMembers.text = memberCount.toString()
        }

        buttonMinus.setOnClickListener {
            if (memberCount > 1) {
                memberCount--
                textViewMembers.text = memberCount.toString()
            } else {
                Toast.makeText(this, "Minimum 1 member required", Toast.LENGTH_SHORT).show()
            }
        }

        // Submit Button
        buttonSubmit.setOnClickListener {
            val date = textViewDate.text.toString()
            val time = textViewTime.text.toString()
            val members = memberCount.toString()
            val additional = editTextAdditional.text.toString()

            val message = "Booking Confirmed!\nDate: $date\nTime: $time\nMembers: $members\nAdditional: $additional"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()


            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }


        val imageButtonHome = findViewById<ImageButton>(R.id.imageButton3)
        imageButtonHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val imageButtonCart = findViewById<ImageButton>(R.id.imageButton2)
        imageButtonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
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
    }
}
