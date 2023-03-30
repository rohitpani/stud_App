package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.influencers_app.R
import com.example.influencers_app.fragments.HomeFragment

class login_with_OTP : AppCompatActivity() {
    lateinit var enter_btn:LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_otp)
        enter_btn = findViewById(R.id.enter_btn_otp)
        enter_btn.setOnClickListener {
            val intent: Intent = Intent(this,verification::class.java)
            intent.putExtra("callingAct","login_with_OTP")
            startActivity(intent)
        }
    }
}