package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.influencers_app.R

class register : AppCompatActivity() {
    lateinit var sign_up_btn:LinearLayout
    lateinit var login_tv:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        sign_up_btn = findViewById(R.id.sign_up_btn)
        login_tv = findViewById(R.id.login_tv_register)

        sign_up_btn.setOnClickListener {
            val intent: Intent = Intent(this,verification::class.java)
            startActivity(intent)
        }

        login_tv.setOnClickListener {
            val intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }

    }
}