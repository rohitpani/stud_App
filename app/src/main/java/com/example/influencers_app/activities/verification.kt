package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.influencers_app.R

class verification : AppCompatActivity() {
    lateinit var verify_button: LinearLayout
    lateinit var resend_otp: TextView
    lateinit var back_btn:ImageView
    lateinit var et1: EditText
    lateinit var et2:EditText
    lateinit var et3:EditText
    lateinit var et4:EditText
    lateinit var timer_tv:TextView
    lateinit var countdownTimer:CountDownTimer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        verify_button = findViewById(R.id.verify_btn)
        resend_otp = findViewById(R.id.resend_OTP_tv)
        back_btn = findViewById(R.id.verification_back_btn)
        et1 = findViewById(R.id.otp_digit1)
        et2 = findViewById(R.id.otp_digit2)
        et3 = findViewById(R.id.otp_digit3)
        et4 = findViewById(R.id.otp_digit4)
        timer_tv = findViewById(R.id.timer_tv)

        back_btn.setOnClickListener {
            finish()
        }

        verify_button.setOnClickListener {

            val act_name = intent.getStringExtra("callingAct")
            if(act_name.equals("login_with_OTP")){
                val intent:Intent = Intent(this,homepage::class.java)
                startActivity(intent)
                finishAffinity()
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



        et1.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(et1.text.toString().length == 1){
                    et2.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        et1.setOnFocusChangeListener{view,hasFocus ->
            if(hasFocus){
                et1.background = resources.getDrawable(R.drawable.otp_selected_bg)
            }
            else{
                et1.background = resources.getDrawable(R.drawable.otp_bg)
            }

        }

        et2.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(et2.text.toString().length == 1){
                    et3.requestFocus()
                }
                else{
                    if(et2.text.toString().length == 0){
                        et1.requestFocus()
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        et2.setOnFocusChangeListener{view,hasFocus ->
            if(hasFocus){
                et2.background = resources.getDrawable(R.drawable.otp_selected_bg)
            }
            else{
                et2.background = resources.getDrawable(R.drawable.otp_bg)
            }
        }

        et3.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(et3.text.toString().length == 1){
                    et4.requestFocus()
                }
                else{
                    if(et3.text.toString().length == 0){
                        et2.requestFocus()
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                
            }
        })
        et3.setOnFocusChangeListener{view,hasFocus ->
            if(hasFocus){
                et3.background = resources.getDrawable(R.drawable.otp_selected_bg)
            }
            else{
                et3.background = resources.getDrawable(R.drawable.otp_bg)
            }

        }

        et4.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(et4.text.toString().length == 1){
//                    et2.requestFocus()
//                    et1.background = resources.getDrawable(R.drawable.otp_bg)
                    et4.clearFocus()
                }
                else{
                    if(et4.text.toString().length == 0){
                        et3.requestFocus()
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                
            }
        })
        et4.setOnFocusChangeListener{view,hasFocus ->
            if(hasFocus){
                et4.background = resources.getDrawable(R.drawable.otp_selected_bg)
            }
            else{
                et4.background = resources.getDrawable(R.drawable.otp_bg)
            }

        }

        countdownTimer = object:CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timer_tv.text = "00 : "+millisUntilFinished/1000
            }

            override fun onFinish() {
                timer_tv.setText("00 : 00")
            }
        }
        countdownTimer.start()

        resend_otp.setOnClickListener {
            countdownTimer.start()
        }

    }
}