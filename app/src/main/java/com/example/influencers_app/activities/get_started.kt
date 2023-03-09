package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.influencers_app.R

class get_started : AppCompatActivity() {
    lateinit var join_now:Button
    lateinit var login_tv_get_Started:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        join_now = findViewById(R.id.join_now_btn)
        login_tv_get_Started = findViewById(R.id.login_tv_get_Started)

        join_now.setOnClickListener {
            val intent: Intent = Intent(this,register::class.java)
            startActivity(intent)
        }

        login_tv_get_Started.setOnClickListener {
            val intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}