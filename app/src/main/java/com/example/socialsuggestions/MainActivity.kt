package com.example.socialsuggestions

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txttime: EditText
    lateinit var txtoutput: TextView
    lateinit var btnsubmit: Button
    lateinit var btnclear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txttime = findViewById(R.id.txttime)
        txtoutput = findViewById(R.id.txtoutput)
        btnsubmit = findViewById(R.id.btnsubmit)
        btnclear = findViewById(R.id.btnclear)

        btnsubmit.setOnClickListener {
            val time = txttime.text.toString().trim().lowercase()

            if (time.isEmpty()) {
                txttime.error = "Please fill in required information"
            }

            txtoutput.text = when (time) {
                "morning" -> "Send a Good morning text to a family member"
                "mid-morning" -> "Reach out to a colleague with a quick thank you"
                "afternoon" -> "Send a funny meme or interesting link to a friend"
                "afternoon snack time" -> "Send a quick thinking of you message"
                "dinner" -> "Call a friend or relative for a 5-min catch up"
                "after dinner" -> "Leave a thoughtful comment on a friend's post"
                else -> "Please enter a valid time of day"
            }
        }
        btnclear.setOnClickListener {
            txttime.text.clear()
            txtoutput.text = ""
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}