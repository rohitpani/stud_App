package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.influencers_app.R
import com.example.influencers_app.fragments.CampaignsFragment

class all_campaign_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_campaign_list)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.all_campg_frame_lnout,CampaignsFragment())
        transaction.commit()
    }
}