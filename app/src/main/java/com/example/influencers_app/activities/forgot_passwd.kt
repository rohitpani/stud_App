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

class forgot_passwd : AppCompatActivity() {
    lateinit var enter_button: LinearLayout
    lateinit var forgot_pass_mobile_no: EditText
    lateinit var forgot_pass_mobile_error: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_passwd)
        enter_button = findViewById(R.id.enter_btn_forgot_passwd)
        forgot_pass_mobile_no = findViewById(R.id.mobile_no_forgot_password)
        forgot_pass_mobile_error = findViewById(R.id.mobile_no_error_forgot_pass)
        enter_button.setOnClickListener {
            if (isValid()) {
                val intent: Intent = Intent(this, verification::class.java)
                intent.putExtra("callingAct", "forgot_password")
                startActivity(intent)
            }
        }
    }

    fun isValid(): Boolean {
        var valid = true
        if (forgot_pass_mobile_no.text.toString().trim().length.equals(0)) {
            forgot_pass_mobile_error.visibility = View.VISIBLE
            forgot_pass_mobile_error.text = "Please enter the Mobile Number"
            valid = false
        } else if (!forgot_pass_mobile_no.text.toString().trim().matches("^[6789]\\d{9}\$".toRegex())
        ) {
            forgot_pass_mobile_error.visibility = View.VISIBLE
            forgot_pass_mobile_error.text = "Error in entered Mobile number"
            valid = false
        } else {
            forgot_pass_mobile_error.visibility = View.GONE
            forgot_pass_mobile_error.text = ""
            //valid = true
        }
        return valid

    }
}