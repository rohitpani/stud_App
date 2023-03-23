package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.influencers_app.R

class edit_profile : AppCompatActivity() {
    lateinit var influencer_catg: Spinner
    lateinit var lang_catg: Spinner
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        influencer_catg = findViewById(R.id.influencer_catg)
        lang_catg = findViewById(R.id.languge_catg)

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
    }
}