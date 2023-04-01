package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
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
    lateinit var privy_policy_and_terms_conditions:TextView
    lateinit var view_pswd: ImageView

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        sign_up_btn = findViewById(R.id.sign_up_btn)
        login_tv = findViewById(R.id.login_tv_register)
        fullname = findViewById(R.id.user_fullname)
        email = findViewById(R.id.user_email)
        mobile_no = findViewById(R.id.user_mobile_no)
        password = findViewById(R.id.user_password)
        fullname_error = findViewById(R.id.full_name_error)
        mobile_no_error = findViewById(R.id.mobile_no_error)
        email_error = findViewById(R.id.email_id_error)
        password_error = findViewById(R.id.password_error)
        view_pswd = findViewById(R.id.pswd_toggle_register)
        privy_policy_and_terms_conditions = findViewById(R.id.privy_policy_terms_conditions)

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

        password.addTextChangedListener(object:TextWatcher{
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

        privy_policy_and_terms_conditions.makeLinks(
            Pair("Privacy Policy", View.OnClickListener {
                //Toast.makeText(applicationContext, "Terms of Service Clicked", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, privacy_policy::class.java)
                startActivity(intent)
            }),
            Pair("Term of Use", View.OnClickListener {
                //Toast.makeText(applicationContext, "Privacy Policy Clicked", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, termsAndConditions::class.java)
                startActivity(intent)
            }))

    }

    fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
        val spannableString = SpannableString(this.text)
        var startIndexOfLink = -1
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun updateDrawState(textPaint: TextPaint) {
                    // use this to change the link color
                    textPaint.color = textPaint.linkColor
                    // toggle below value to enable/disable
                    // the underline shown below the clickable text
                    textPaint.isUnderlineText = true
                }

                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }
            }
            startIndexOfLink = this.text.toString().indexOf(link.first, startIndexOfLink + 1)
//      if(startIndexOfLink == -1) continue // todo if you want to verify your texts contains links text
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        this.movementMethod = LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
        this.setText(spannableString, TextView.BufferType.SPANNABLE)
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
            //valid = true
        }


        if(email.text.toString().trim().length.equals(0)){
            email_error.visibility = View.VISIBLE
            email_error.text = "Please enter the Email"
            valid = false
        }
        else if(!email.text.toString().trim().matches("^[a-zA-Z0-9_!#\$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$".toRegex())){
            email_error.visibility = View.VISIBLE
            email_error.text = "Error in entered Email"
            valid = false
        }
        else{
            email_error.visibility = View.GONE
            email_error.text = ""
            //valid = true
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
            //valid = true
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
            //valid = true
        }
        return valid
    }
}