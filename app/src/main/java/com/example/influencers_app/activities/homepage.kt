package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.res.Resources.NotFoundException
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.influencers_app.R
import com.example.influencers_app.fragments.CampaignsFragment
import com.example.influencers_app.fragments.EarningsFragment
import com.example.influencers_app.fragments.HomeFragment
import com.example.influencers_app.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class homepage : AppCompatActivity() {
    //lateinit var bnav:BottomNavigationView
    //lateinit var flout:FrameLayout
    var count = 0
    lateinit var home_frag:Fragment
    lateinit var campg_frag:Fragment
    lateinit var earnings_frag:Fragment
    lateinit var profile_frag:Fragment
    lateinit var home_section:RelativeLayout
    lateinit var campg_section:RelativeLayout
    lateinit var earn_section:RelativeLayout
    lateinit var prof_section:RelativeLayout
    lateinit var home_img:ImageView
    lateinit var home_tv:TextView
    lateinit var campg_img:ImageView
    lateinit var campg_tv:TextView
    lateinit var earn_img:ImageView
    lateinit var earn_tv:TextView
    lateinit var profile_img:ImageView
    lateinit var profile_tv:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        //bnav = findViewById<BottomNavigationView>(R.id.btm_nav)
        //flout = findViewById(R.id.frame_lout_homepage)
        //supportFragmentManager.beginTransaction().replace(R.id.constraint,CampaignsFragment()).commit()

        home_section = findViewById(R.id.home_section)
        campg_section = findViewById(R.id.campg_section)
        earn_section = findViewById(R.id.earnings_section)
        prof_section = findViewById(R.id.profile_section)

        home_img = findViewById(R.id.home_frag_icon)
        home_tv = findViewById(R.id.home_tv)

        campg_img = findViewById(R.id.campg_frag_icon)
        campg_tv = findViewById(R.id.campg_tv)

        earn_img = findViewById(R.id.earnings_frag_icon)
        earn_tv = findViewById(R.id.earn_tv)

        profile_img = findViewById(R.id.profile_frag_icon)
        profile_tv = findViewById(R.id.prof_tv)



        home_frag = HomeFragment()
        campg_frag = CampaignsFragment()
        //earnings_frag
        earnings_frag = EarningsFragment()
        profile_frag = ProfileFragment()
        loadFragment(home_frag)
        setSelected("Home")


//        bnav.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.home_frag -> {
//                    loadFragment(home_frag)
//                    true
//                }
//                R.id.campg_frag -> {
//                    loadFragment(campg_frag)
//                    true
//                }
//                R.id.earning_frag -> {
//                    loadFragment(earnings_frag)
//                    true
//                }
//                R.id.profile_frag -> {
//                    loadFragment(profile_frag)
//                    true
//                }
//                else -> {
//                    throw NotFoundException("No Fragment Found")
//                }
//            }
//        }

        home_section.setOnClickListener {
            loadFragment(home_frag)
            setSelected("Home")
        }
        campg_section.setOnClickListener {
            loadFragment(campg_frag)
            setSelected("Campaigns")
        }
        earn_section.setOnClickListener {
            loadFragment(earnings_frag)
            setSelected("Earnings")
        }
        prof_section.setOnClickListener {
            loadFragment(profile_frag)
            setSelected("Profile")
        }
    }
    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_lout_homepage,fragment)
        transaction.commit()
    }

    fun setSelected(frag_name:String){
        if(frag_name.equals("Home")){
            home_img.setImageDrawable(resources.getDrawable(R.drawable.selected_home))
            home_tv.setTextColor(resources.getColor(R.color.blue))
            campg_img.setImageDrawable(resources.getDrawable(R.drawable.campg_icon))
            campg_tv.setTextColor(resources.getColor(R.color.black))
            earn_img.setImageDrawable(resources.getDrawable(R.drawable.earning_icon))
            earn_tv.setTextColor(resources.getColor(R.color.black))
            profile_img.setImageDrawable(resources.getDrawable(R.drawable.profile_icon))
            profile_tv.setTextColor(resources.getColor(R.color.black))
        }
        else if(frag_name.equals("Campaigns")){
            campg_img.setImageDrawable(resources.getDrawable(R.drawable.selected_campg))
            campg_tv.setTextColor(resources.getColor(R.color.blue))
            home_img.setImageDrawable(resources.getDrawable(R.drawable.home_icon))
            home_tv.setTextColor(resources.getColor(R.color.black))
            earn_img.setImageDrawable(resources.getDrawable(R.drawable.earning_icon))
            earn_tv.setTextColor(resources.getColor(R.color.black))
            profile_img.setImageDrawable(resources.getDrawable(R.drawable.profile_icon))
            profile_tv.setTextColor(resources.getColor(R.color.black))
        }
        else if(frag_name.equals("Earnings")){
            earn_img.setImageDrawable(resources.getDrawable(R.drawable.selected_earning))
            earn_tv.setTextColor(resources.getColor(R.color.blue))
            home_img.setImageDrawable(resources.getDrawable(R.drawable.home_icon))
            home_tv.setTextColor(resources.getColor(R.color.black))
            campg_img.setImageDrawable(resources.getDrawable(R.drawable.campg_icon))
            campg_tv.setTextColor(resources.getColor(R.color.black))
            profile_img.setImageDrawable(resources.getDrawable(R.drawable.profile_icon))
            profile_tv.setTextColor(resources.getColor(R.color.black))
        }
        else if(frag_name.equals("Profile")){
            profile_img.setImageDrawable(resources.getDrawable(R.drawable.selected_profile))
            profile_tv.setTextColor(resources.getColor(R.color.blue))
            home_img.setImageDrawable(resources.getDrawable(R.drawable.home_icon))
            home_tv.setTextColor(resources.getColor(R.color.black))
            campg_img.setImageDrawable(resources.getDrawable(R.drawable.campg_icon))
            campg_tv.setTextColor(resources.getColor(R.color.black))
            earn_img.setImageDrawable(resources.getDrawable(R.drawable.earning_icon))
            earn_tv.setTextColor(resources.getColor(R.color.black))
        }
    }

    override fun onBackPressed() {
        count++
        if(count == 1){
            Toast.makeText(this,"Press back Again to Exit !!", Toast.LENGTH_SHORT).show()
        }
        else{
            super.onBackPressed()
        }
    }
}