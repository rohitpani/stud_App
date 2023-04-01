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
import androidx.core.content.res.ResourcesCompat
import com.example.influencers_app.R

class reset_password : AppCompatActivity() {
    lateinit var confirm_btn: LinearLayout
    lateinit var new_pswd:EditText
    lateinit var cofirm_pswd:EditText
    lateinit var new_pswd_error:TextView
    lateinit var confirm_pswd_error:TextView
    lateinit var view_pswd_new_pswd: ImageView
    lateinit var view_pswd_confirm_pswd: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        new_pswd = findViewById(R.id.new_pswd_reset)
        cofirm_pswd = findViewById(R.id.confirm_pswd_reset)
        new_pswd_error = findViewById(R.id.new_pswd_error_reset)
        confirm_pswd_error = findViewById(R.id.confirm_pswd_error_reset)
        view_pswd_new_pswd = findViewById(R.id.new_pswd_toggle_reset)
        view_pswd_confirm_pswd = findViewById(R.id.confirm_pswd_toggle_reset)

        confirm_btn = findViewById(R.id.confirm_button)
        confirm_btn.setOnClickListener {
            if(isValid()){
                val intent: Intent = Intent(this,login::class.java)
                startActivity(intent)
            }
        }

        new_pswd.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    view_pswd_new_pswd.setVisibility(View.GONE)
                } else {
                    view_pswd_new_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        view_pswd_new_pswd.setOnClickListener(View.OnClickListener {
            if (view_pswd_new_pswd.getTag().toString() == "1") {
                new_pswd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                new_pswd.typeface = typeface
                view_pswd_new_pswd.setImageResource(R.drawable.views_on)
                view_pswd_new_pswd.setTag("2")
                new_pswd.setSelection(new_pswd.length())
            } else if (view_pswd_new_pswd.getTag().toString() == "2") {
                new_pswd.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                new_pswd.typeface = typeface
                view_pswd_new_pswd.setImageResource(R.drawable.view_off)
                view_pswd_new_pswd.setTag("1")
                new_pswd.setSelection(new_pswd.length())
            }
        })

        cofirm_pswd.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    view_pswd_confirm_pswd.setVisibility(View.GONE)
                } else {
                    view_pswd_confirm_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        view_pswd_confirm_pswd.setOnClickListener(View.OnClickListener {
            if (view_pswd_confirm_pswd.getTag().toString() == "1") {
                cofirm_pswd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                cofirm_pswd.typeface = typeface
                view_pswd_confirm_pswd.setImageResource(R.drawable.views_on)
                view_pswd_confirm_pswd.setTag("2")
                cofirm_pswd.setSelection(cofirm_pswd.length())
            } else if (view_pswd_confirm_pswd.getTag().toString() == "2") {
                cofirm_pswd.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                cofirm_pswd.typeface = typeface
                view_pswd_confirm_pswd.setImageResource(R.drawable.view_off)
                view_pswd_confirm_pswd.setTag("1")
                cofirm_pswd.setSelection(cofirm_pswd.length())
            }
        })
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
            //valid = true
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
            //valid = true
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