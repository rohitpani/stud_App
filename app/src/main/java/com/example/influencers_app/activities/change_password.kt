package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.influencers_app.R

class change_password : AppCompatActivity() {
    lateinit var back_btn: ImageView
    lateinit var old_password: EditText
    lateinit var new_password: EditText
    lateinit var confirm_password:EditText
    lateinit var old_pswd_error:TextView
    lateinit var new_pswd_error:TextView
    lateinit var confirm_pswd_error:TextView
    lateinit var confirm_btn:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        back_btn = findViewById(R.id.change_pswd_back_btn)
        old_password = findViewById(R.id.old_pswd_change_pswd)
        old_pswd_error = findViewById(R.id.old_pswd_change_pswd_error)
        new_password = findViewById(R.id.new_pswd_change_pswd)
        new_pswd_error = findViewById(R.id.new_pswd_change_pswd_error)
        confirm_password = findViewById(R.id.confirm_pswd_change_pswd)
        confirm_pswd_error = findViewById(R.id.confirm_pswd_change_pswd_error)
        confirm_btn = findViewById(R.id.confirm_btn_change_password)

        back_btn.setOnClickListener {
            finish()
        }

        confirm_btn.setOnClickListener {

            if(isValid()){

            }

        }
    }

    fun isValid():Boolean{
        var valid = true

        if(old_password.text.toString().trim().length.equals(0)){
            old_pswd_error.visibility = View.VISIBLE
            old_pswd_error.text = "Please enter the Password"
            valid = false
        }
        else if(old_password.text.toString().trim().length < 8){
            old_pswd_error.visibility = View.VISIBLE
            old_pswd_error.text = "Minimum 8 characters Expected"
            valid = false
        }
        else{
            old_pswd_error.visibility = View.GONE
            old_pswd_error.text = ""
            valid = true
        }

        if(new_password.text.toString().trim().length.equals(0)){
            new_pswd_error.visibility = View.VISIBLE
            new_pswd_error.text = "Please enter the Password"
            valid = false
        }
        else if(new_password.text.toString().trim().length < 8){
            new_pswd_error.visibility = View.VISIBLE
            new_pswd_error.text = "Minimum 8 characters Expected"
            valid = false
        }
        else{
            new_pswd_error.visibility = View.GONE
            new_pswd_error.text = ""
            valid = true
        }

        if(confirm_password.text.toString().trim().length.equals(0)){
            confirm_pswd_error.visibility = View.VISIBLE
            confirm_pswd_error.text = "Please enter the Password"
            valid = false
        }
        else if(confirm_password.text.toString().trim().length < 8){
            confirm_pswd_error.visibility = View.VISIBLE
            confirm_pswd_error.text = "Minimum 8 characters Expected"
            valid = false
        }
        else{
            confirm_pswd_error.visibility = View.GONE
            confirm_pswd_error.text = ""
            valid = true
        }

        if(!new_password.text.toString().trim().length.equals(0) && !confirm_password.text.toString().trim().length.equals(0)){
            if(!new_password.text.toString().equals(confirm_password.text)){
                valid = false
                Toast.makeText(this,"Entered Password doesn't matched Confirm Password", Toast.LENGTH_SHORT).show()
            }
        }

        return valid
    }
}