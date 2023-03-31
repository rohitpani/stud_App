package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.influencers_app.R

class reset_password : AppCompatActivity() {
    lateinit var confirm_btn: LinearLayout
    lateinit var new_pswd:EditText
    lateinit var cofirm_pswd:EditText
    lateinit var new_pswd_error:TextView
    lateinit var confirm_pswd_error:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        new_pswd = findViewById(R.id.new_pswd_reset)
        cofirm_pswd = findViewById(R.id.confirm_pswd_reset)
        new_pswd_error = findViewById(R.id.new_pswd_error_reset)
        confirm_pswd_error = findViewById(R.id.confirm_pswd_error_reset)

        confirm_btn = findViewById(R.id.confirm_button)
        confirm_btn.setOnClickListener {
            if(isValid()){
                val intent: Intent = Intent(this,login::class.java)
                startActivity(intent)
            }
        }
    }

    fun isValid():Boolean{
        var valid = true
        if(new_pswd.text.toString().trim().length.equals(0)){
            new_pswd_error.visibility = View.VISIBLE
            new_pswd_error.text = "Please enter the Password"
            valid = false
        }
        else if(new_pswd.text.toString().trim().length < 8){
            new_pswd_error.visibility = View.VISIBLE
            new_pswd_error.text = "Minimum 8 characters Expected"
            valid = false
        }
        else{
            new_pswd_error.visibility = View.GONE
            new_pswd_error.text = ""
            valid = true
        }

        if(cofirm_pswd.text.toString().trim().length.equals(0)){
            confirm_pswd_error.visibility = View.VISIBLE
            confirm_pswd_error.text = "Please enter the Password"
            valid = false
        }
        else if(cofirm_pswd.text.toString().trim().length < 8){
            confirm_pswd_error.visibility = View.VISIBLE
            confirm_pswd_error.text = "Minimum 8 characters Expected"
            valid = false
        }
        else{
            confirm_pswd_error.visibility = View.GONE
            confirm_pswd_error.text = ""
            valid = true
        }

        if(!new_pswd.text.toString().trim().length.equals(0) && !cofirm_pswd.text.toString().trim().length.equals(0)){
            if(!new_pswd.text.toString().equals(cofirm_pswd.text)){
                valid = false
                Toast.makeText(this,"Entered Password doesn't matched Confirm Password",Toast.LENGTH_SHORT).show()
            }
        }
        return valid
    }
}