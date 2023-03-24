package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.influencers_app.R

class change_password : AppCompatActivity() {
    lateinit var back_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        back_btn = findViewById(R.id.change_pswd_back_btn)

        back_btn.setOnClickListener {
            finish()
        }
    }
}