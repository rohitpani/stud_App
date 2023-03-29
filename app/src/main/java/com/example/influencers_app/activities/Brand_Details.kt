package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brand_campg_adapter
import com.example.influencers_app.models.brands_campaign_details

class Brand_Details : AppCompatActivity() {
    lateinit var brand_campgs_recv:RecyclerView
    lateinit var brand_logo: ImageView
    lateinit var brand_name:TextView
    lateinit var brand_active_campg:TextView
    lateinit var brand_overview:TextView
    lateinit var featured_campaign_by_brand:TextView
    lateinit var back_btn:ImageView
    lateinit var viewAll_total_campg:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand_details)
        brand_campgs_recv = findViewById(R.id.campg_by_brands_recv)
        brand_logo = findViewById(R.id.brand_logo_brand_details)
        brand_name = findViewById(R.id.brand_name_brand_details)
        brand_active_campg = findViewById(R.id.brand_active_campg_tv)
        brand_overview = findViewById(R.id.brand_overview_brand_details)
        back_btn = findViewById(R.id.abt_brand_back_btn)
        featured_campaign_by_brand = findViewById(R.id.featured_campaign_brand_details)
        viewAll_total_campg = findViewById(R.id.view_all_total_campg)

        brand_campgs_recv.isNestedScrollingEnabled = false


        back_btn.setOnClickListener {
            finish()
        }

        var b_logo = intent.getIntExtra("brand_logo",R.drawable.air_bnb)
        var b_name = intent.getStringExtra("brand_name")
        var b_active_campg = intent.getStringExtra("brand_active_campg")
        var b_overview = intent.getStringExtra("brand_desc")


        if (b_logo != null) {
            brand_logo.setImageResource(b_logo.toInt())
        }
        brand_name.text = b_name
        brand_active_campg.text = b_active_campg
        brand_overview.text = b_overview
        //featured_campaign_by_brand.text = "Total Campaigns by "+b_name


        val campg_list_of_brands = mutableListOf<brands_campaign_details>()
        campg_list_of_brands.add(0, brands_campaign_details(R.drawable.air_bnb_bg,"ACTIVE"))
        campg_list_of_brands.add(1,brands_campaign_details(R.drawable.airbnb_camp_2,"APPLICATION CLOSED"))
        campg_list_of_brands.add(2,brands_campaign_details(R.drawable.airbnb_camp_3,"APPLICATION CLOSED"))

        val brand_campg_lout = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val brand_campg_adapter = brand_campg_adapter(campg_list_of_brands)
        brand_campgs_recv.layoutManager = brand_campg_lout
        brand_campgs_recv.adapter = brand_campg_adapter

        viewAll_total_campg.setOnClickListener {
            val intent: Intent = Intent(this, all_campaign_list::class.java)
            startActivity(intent)
        }

    }
}