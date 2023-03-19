package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.influencers_app.R
import com.example.influencers_app.utils.LogoutDialog
import com.example.influencers_app.utils.deleteAccountDialog

class settings : AppCompatActivity() {
    lateinit var faq_btn: LinearLayout
    lateinit var terms_and_condition_btn: LinearLayout
    lateinit var privacy_policy_btn: LinearLayout
    lateinit var about_us: LinearLayout
    lateinit var delete_account: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        faq_btn = findViewById(R.id.faq_button_settings)
        terms_and_condition_btn = findViewById(R.id.terms_and_condition_button)
        privacy_policy_btn = findViewById(R.id.privacy_policy_button_settings)
        about_us = findViewById(R.id.about_us_button_settings)
        delete_account = findViewById(R.id.delete_account_button_settings)

        delete_account.setOnClickListener {
            val delete_sheet: deleteAccountDialog = deleteAccountDialog()
            this?.let { it1 -> delete_sheet.show(it1.supportFragmentManager,"FilterSheet") }
        }

        terms_and_condition_btn.setOnClickListener {
            val intent: Intent = Intent(this, termsAndConditions::class.java)
            startActivity(intent)
        }
        privacy_policy_btn.setOnClickListener {
            val intent: Intent = Intent(this, privacy_policy::class.java)
            startActivity(intent)
        }
        about_us.setOnClickListener {
            val intent: Intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }
        faq_btn.setOnClickListener {
            val intent: Intent = Intent(this, FAQ_Activity::class.java)
            startActivity(intent)
        }

    }


}