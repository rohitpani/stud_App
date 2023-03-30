package com.example.influencers_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.influencers_app.R

class approval : AppCompatActivity() {
    lateinit var login_btn:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_approval)
        login_btn = findViewById(R.id.login_btn_approval)
        login_btn.setOnClickListener {
            val intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}