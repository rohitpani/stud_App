package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
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
    lateinit var old_pswd_view_pswd: ImageView
    lateinit var new_pswd_view_pswd: ImageView
    lateinit var confirm_pswd_view_pswd: ImageView
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
        old_pswd_view_pswd = findViewById(R.id.old_pswd_toggle_change_pswd)
        new_pswd_view_pswd = findViewById(R.id.new_pswd_toggle_change_pswd)
        confirm_pswd_view_pswd = findViewById(R.id.confirm_pswd_toggle_change_pswd)

        back_btn.setOnClickListener {
            finish()
        }

        confirm_btn.setOnClickListener {

            if(isValid()){

            }

        }

        old_password.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    old_pswd_view_pswd.setVisibility(View.GONE)
                } else {
                    old_pswd_view_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        old_pswd_view_pswd.setOnClickListener(View.OnClickListener {
            if (old_pswd_view_pswd.getTag().toString() == "1") {
                old_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                old_password.typeface = typeface
                old_pswd_view_pswd.setImageResource(R.drawable.views_on)
                old_pswd_view_pswd.setTag("2")
                old_password.setSelection(old_password.length())
            } else if (old_pswd_view_pswd.getTag().toString() == "2") {
                old_password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                old_password.typeface = typeface
                old_pswd_view_pswd.setImageResource(R.drawable.view_off)
                old_pswd_view_pswd.setTag("1")
                old_password.setSelection(old_password.length())
            }
        })

        new_password.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    new_pswd_view_pswd.setVisibility(View.GONE)
                } else {
                    new_pswd_view_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        new_pswd_view_pswd.setOnClickListener(View.OnClickListener {
            if (new_pswd_view_pswd.getTag().toString() == "1") {
                new_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                new_password.typeface = typeface
                new_pswd_view_pswd.setImageResource(R.drawable.views_on)
                new_pswd_view_pswd.setTag("2")
                new_password.setSelection(new_password.length())
            } else if (new_pswd_view_pswd.getTag().toString() == "2") {
                new_password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                new_password.typeface = typeface
                new_pswd_view_pswd.setImageResource(R.drawable.view_off)
                new_pswd_view_pswd.setTag("1")
                new_password.setSelection(new_password.length())
            }
        })

        confirm_password.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString() == "") {
                    confirm_pswd_view_pswd.setVisibility(View.GONE)
                } else {
                    confirm_pswd_view_pswd.setVisibility(View.VISIBLE)
                }
            }

        })

        confirm_pswd_view_pswd.setOnClickListener(View.OnClickListener {
            if (confirm_pswd_view_pswd.getTag().toString() == "1") {
                confirm_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                confirm_password.typeface = typeface
                confirm_pswd_view_pswd.setImageResource(R.drawable.views_on)
                confirm_pswd_view_pswd.setTag("2")
                confirm_password.setSelection(confirm_password.length())
            } else if (confirm_pswd_view_pswd.getTag().toString() == "2") {
                confirm_password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                var typeface = ResourcesCompat.getFont(this,R.font.poppins)
                confirm_password.typeface = typeface
                confirm_pswd_view_pswd.setImageResource(R.drawable.view_off)
                confirm_pswd_view_pswd.setTag("1")
                confirm_password.setSelection(confirm_password.length())
            }
        })
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