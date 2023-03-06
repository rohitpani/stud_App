package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brand_campg_adapter
import com.example.influencers_app.models.brands_campaign_details

class Brand_Details : AppCompatActivity() {
    lateinit var brand_campgs_recv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand_details)
        brand_campgs_recv = findViewById(R.id.campg_by_brands_recv)

        val campg_list_of_brands = mutableListOf<brands_campaign_details>()
        campg_list_of_brands.add(0, brands_campaign_details(R.drawable.air_bnb_bg,"ACTIVE"))
        campg_list_of_brands.add(1,brands_campaign_details(R.drawable.airbnb_camp_2,"APPLICATION CLOSED"))
        campg_list_of_brands.add(2,brands_campaign_details(R.drawable.airbnb_camp_3,"APPLICATION CLOSED"))

        val brand_campg_lout = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val brand_campg_adapter = brand_campg_adapter(campg_list_of_brands)
        brand_campgs_recv.layoutManager = brand_campg_lout
        brand_campgs_recv.adapter = brand_campg_adapter

    }
}