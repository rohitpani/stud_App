package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.influencers_app.R

class reset_password : AppCompatActivity() {
    lateinit var confirm_btn: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        confirm_btn = findViewById(R.id.confirm_button)
        confirm_btn.setOnClickListener {
            val intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}