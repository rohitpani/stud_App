package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.influencers_app.R

class login : AppCompatActivity() {
    lateinit var login_btn: Button
    lateinit var login_wth_otp:AppCompatButton
    lateinit var forgot_pswd_tv:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn = findViewById(R.id.login_btn)
        login_wth_otp = findViewById(R.id.login_with_OTP)
        forgot_pswd_tv = findViewById(R.id.forgot_password_tv)

        forgot_pswd_tv.setOnClickListener {
            val intent: Intent = Intent(this,forgot_passwd::class.java)
            startActivity(intent)
        }

        login_wth_otp.setOnClickListener {
            val intent: Intent = Intent(this,login_with_OTP::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {
            val intent: Intent = Intent(this,under_review::class.java)
            startActivity(intent)
        }
    }
}