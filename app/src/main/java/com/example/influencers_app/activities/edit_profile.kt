package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.influencers_app.R
import java.text.SimpleDateFormat
import java.util.*

class edit_profile : AppCompatActivity() {
    lateinit var influencer_catg: Spinner
    lateinit var lang_catg: Spinner
    lateinit var back_btn:ImageView
    lateinit var user_dob: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        influencer_catg = findViewById(R.id.influencer_catg)
        lang_catg = findViewById(R.id.languge_catg)
        back_btn = findViewById(R.id.edit_profile_back_btn)
        user_dob = findViewById(R.id.user_dob)

        val catglist:ArrayList<String> = ArrayList()
        catglist.add("Travel")
        catglist.add("Fashion")
        catglist.add("Health")
        catglist.add("Beauty")
        catglist.add("Tech")
        catglist.add("Photography")
        catglist.add("Books")
        catglist.add("Food")
        catglist.add("Fitness")
        catglist.add("Entertainment")
        catglist.add("Education")
        catglist.add("Gaming")

        val inf_cat_arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.spinner_item, catglist)
        inf_cat_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        influencer_catg.adapter = inf_cat_arrayAdapter

        val langlist:ArrayList<String> = ArrayList()
        langlist.add("English, Hindi")
        langlist.add("Marathi")
        langlist.add("Odia")
        langlist.add("Tulu")
        langlist.add("Telugu")
        langlist.add("Punjabi")
        langlist.add("Gujrati")

//        catglist.add("Photography")
//        catglist.add("Books")
//        catglist.add("Food")
//        catglist.add("Fitness")
//        catglist.add("Entertainment")
//        catglist.add("Education")
//        catglist.add("Gaming")

        val  lang_cat_arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.spinner_item, langlist)
        lang_cat_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        lang_catg.adapter = lang_cat_arrayAdapter

        back_btn.setOnClickListener {
            finish()
        }

        user_dob.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    var formatter = SimpleDateFormat("dd'th' MMM yyyy")
                    var cal = Calendar.getInstance()
                    cal.set(year,monthOfYear,dayOfMonth)
                    var dateString: String = formatter.format(cal.time)
                    user_dob.setText(dateString)
                }, year, month, day)
            datePickerDialog.show()
        }

    }

}