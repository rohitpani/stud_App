package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import com.example.influencers_app.R

class login : AppCompatActivity() {
    lateinit var login_btn: LinearLayout
    lateinit var login_wth_otp:AppCompatButton
    lateinit var forgot_pswd_tv:TextView
    lateinit var mobile_no:EditText
    lateinit var password:EditText
    lateinit var mobile_no_error:TextView
    lateinit var password_error:TextView
    lateinit var view_pswd: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn = findViewById(R.id.login_btn)
        login_wth_otp = findViewById(R.id.login_with_OTP)
        forgot_pswd_tv = findViewById(R.id.forgot_password_tv)
        mobile_no = findViewById(R.id.login_mobile_no)
        password =  findViewById(R.id.login_Password)
        mobile_no_error = findViewById(R.id.mobile_no_error_login)
        password_error = findViewById(R.id.password_error_login)
        view_pswd = findViewById(R.id.pswd_toggle_login)

        forgot_pswd_tv.setOnClickListener {
            val intent: Intent = Intent(this,forgot_passwd::class.java)
            startActivity(intent)
        }

        login_wth_otp.setOnClickListener {
            val intent: Intent = Intent(this,login_with_OTP::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {
            if(isValid()){
                val intent: Intent = Intent(this,under_review::class.java)
                startActivity(intent)
            }
        }

        password.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    view_pswd.setVisibility(View.GONE)
                } else {
                    view_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        view_pswd.setOnClickListener(View.OnClickListener {
            if (view_pswd.getTag().toString() == "1") {
                password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                password.typeface = typeface
                view_pswd.setImageResource(R.drawable.views_on)
                view_pswd.setTag("2")
                password.setSelection(password.length())
            } else if (view_pswd.getTag().toString() == "2") {
                password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                password.typeface = typeface
                view_pswd.setImageResource(R.drawable.view_off)
                view_pswd.setTag("1")
                password.setSelection(password.length())
            }
        })

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

        if(password.text.toString().trim().length.equals(0)){
            password_error.visibility = View.VISIBLE
            password_error.text = "Please enter the Password"
            valid = false
        }
//        else if(password.text.toString().trim().length < 8){
//            password_error.visibility = View.VISIBLE
//            password_error.text = "Minimum 8 characters Expected"
//            isvalid = false
//        }
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
            //valid = true
        }
        return valid
    }
}