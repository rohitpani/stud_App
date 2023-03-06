package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.influencers_app.R
import com.example.influencers_app.fragments.HomeFragment

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        supportFragmentManager.beginTransaction().replace(R.id.constraint,HomeFragment()).commit()
    }
}