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

class register : AppCompatActivity() {
    lateinit var sign_up_btn:LinearLayout
    lateinit var login_tv:TextView
    lateinit var fullname:EditText
    lateinit var email:EditText
    lateinit var mobile_no:EditText
    lateinit var password:EditText
    lateinit var fullname_error:TextView
    lateinit var email_error:TextView
    lateinit var mobile_no_error:TextView
    lateinit var password_error:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        sign_up_btn = findViewById(R.id.sign_up_btn)
        login_tv = findViewById(R.id.login_tv_register)
        fullname = findViewById(R.id.user_fullname)
        email = findViewById(R.id.user_email)
        mobile_no = findViewById(R.id.user_email)
        password = findViewById(R.id.user_password)
        fullname_error = findViewById(R.id.full_name_error)
        mobile_no_error = findViewById(R.id.mobile_no_error)
        email_error = findViewById(R.id.email_id_error)
        password_error = findViewById(R.id.password_error)

        sign_up_btn.setOnClickListener {
            if(isValid()){
                val intent: Intent = Intent(this,verification::class.java)
                startActivity(intent)
            }
        }

        login_tv.setOnClickListener {
            val intent: Intent = Intent(this,login::class.java)
            startActivity(intent)
        }

    }

    fun isValid():Boolean{
        var valid = true
        if(fullname.text.toString().trim().length.equals(0)){
            fullname_error.visibility = View.VISIBLE
            fullname_error.text = "Please enter the Name"
            valid = false
        }
        else if(!fullname.text.toString().trim().matches("^[A-Za-z ]+\$".toRegex())){
            fullname_error.visibility = View.VISIBLE
            fullname_error.text = "Error in entered Full Name"
            valid = false
        }
        else{
            fullname_error.visibility = View.GONE
            fullname_error.text = ""
            valid = true
        }


        if(email.text.toString().trim().length.equals(0)){
            email_error.visibility = View.VISIBLE
            email_error.text = "Please enter the Email"
            valid = false
        }
        else if(!email.text.toString().trim().matches("^[a-zA-Z0-9_!#\$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$".toRegex())){
            email_error.visibility = View.VISIBLE
            email_error.text = "Error in entered Full Name"
            valid = false
        }
        else{
            email_error.visibility = View.GONE
            email_error.text = ""
            valid = true
        }


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
            valid = true
        }

        if(password.text.toString().trim().length.equals(0)){
            password_error.visibility = View.VISIBLE
            password_error.text = "Please enter the Password"
            valid = false
        }
        else if(password.text.toString().trim().length < 8){
            password_error.visibility = View.VISIBLE
            password_error.text = "Minimum 8 characters Expected"
            valid = false
        }
//            else if(password.text.toString().trim().matches("^(?=.*[0-9]).{1,}$".toRegex())){
//                password_error.visibility = View.VISIBLE
//                password_error.text = "Minimum 1 numeric character Expected"
//                valid = false
//            }
//            else if(password.text.toString().trim().matches("^(?=.*[!@#$%^&+=]).{1,}$".toRegex())){
//                password_error.visibility = View.VISIBLE
//                password_error.text = "Minimum 1 special character Expected out of [!@#\$%^&+=]"
//                valid = false
//            }
        else{
            password_error.visibility = View.GONE
            password_error.text = ""
            valid = true
        }
        return valid
    }
}