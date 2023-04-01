package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.influencers_app.R
import com.example.influencers_app.fragments.HomeFragment

class login_with_OTP : AppCompatActivity() {
    lateinit var enter_btn:LinearLayout
    lateinit var mobile_no: EditText
    lateinit var mobile_no_error: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_otp)
        enter_btn = findViewById(R.id.enter_btn_otp)
        mobile_no = findViewById(R.id.mobile_no_login_with_OTP)
        mobile_no_error = findViewById(R.id.mobile_no_error_login_OTP)
        enter_btn.setOnClickListener {
            if(isValid()){
                val intent: Intent = Intent(this,verification::class.java)
                intent.putExtra("callingAct","login_with_OTP")
                startActivity(intent)
            }
        }

    }
    fun isValid():Boolean{
        var valid = true
        if(mobile_no.text.toString().trim().length.equals(0)){
            mobile_no_error.visibility = View.VISIBLE
            mobile_no_error.text = "Please enter the Mobile Number"
            valid = false
        }
        else if(!mobile_no.text.toString().trim().matches("^[6789]\\d{9}\$".toRegex())){
            mobile_no_error.visibility = View.VISIBLE
            mobile_no_error.text = "Error in entered Mobile number"
            valid = false
        }
        else{
            mobile_no_error.visibility = View.GONE
            mobile_no_error.text = ""
            //valid = true
        }
        return valid
    }
}