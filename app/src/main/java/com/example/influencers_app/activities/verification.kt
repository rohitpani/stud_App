package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.influencers_app.R

class verification : AppCompatActivity() {
    lateinit var verify_button: Button
    lateinit var resend_otp: TextView
    lateinit var back_btn:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        verify_button = findViewById(R.id.verify_btn)
        resend_otp = findViewById(R.id.resend_OTP_tv)
        back_btn = findViewById(R.id.verification_back_btn)

        back_btn.setOnClickListener {
            finish()
        }

        verify_button.setOnClickListener {

            val act_name = intent.getStringExtra("callingAct")
            if(act_name.equals("login_with_OTP")){
                val intent:Intent = Intent(this,homepage::class.java)
                startActivity(intent)
            }
            else if(act_name.equals("forgot_password")){
                val intent:Intent = Intent(this,reset_password::class.java)
                startActivity(intent)
            }
            else{
                val intent:Intent = Intent(this,approval::class.java)
                startActivity(intent)
            }
        }
    }
}