package com.example.influencers_app.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.influencers_app.R
import com.example.influencers_app.utils.pageAdapter
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class campaign_details : AppCompatActivity() {
    lateinit var tablout:TabLayout
    lateinit var details_tab: TabItem
    lateinit var deliverables_tab: TabItem
    lateinit var criteria_tab: TabItem
    lateinit var dos_dont_tab: TabItem
    lateinit var references_tab: TabItem
    lateinit var viewpager: ViewPager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign_details)
        tablout = findViewById(R.id.tablout1)
//        details_tab = findViewById<TabItem>(R.id.detail_tab)
//        criteria_tab = findViewById(R.id.influencer_criteria_tab)
//        deliverables_tab = findViewById(R.id.deliverables_tab)
//        dos_dont_tab = findViewById(R.id.dos_donts_tab)
//        references_tab = findViewById(R.id.references_tab)
        viewpager = findViewById(R.id.viewpager1)

        var pageadapter = pageAdapter(supportFragmentManager,tablout.tabCount)
        viewpager.adapter = pageadapter

        tablout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager.currentItem = tab.position
                if(tab.position == 0 || tab.position == 1 || tab.position == 2|| tab.position == 3 || tab.position == 4){
                    pageadapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab){
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }


        })

        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablout))

    }
}