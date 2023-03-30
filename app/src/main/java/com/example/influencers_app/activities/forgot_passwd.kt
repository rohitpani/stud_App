package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.influencers_app.R

class forgot_passwd : AppCompatActivity() {
    lateinit var enter_button: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_passwd)
        enter_button = findViewById(R.id.enter_btn_forgot_passwd)
        enter_button.setOnClickListener {
            val intent: Intent = Intent(this,verification::class.java)
            intent.putExtra("callingAct","forgot_password")
            startActivity(intent)
        }
    }
}