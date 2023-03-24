package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.influencers_app.R

class AboutUs : AppCompatActivity() {
    lateinit var back_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        back_btn = findViewById(R.id.about_us_back_btn)
        back_btn.setOnClickListener {
            finish()
        }
    }
}