package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.influencers_app.R

class termsAndConditions : AppCompatActivity() {
    lateinit var back_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_conditions)
        back_btn = findViewById(R.id.terms_conditions_back_btn)

        back_btn.setOnClickListener {
            finish()
        }
    }
}