package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.res.Resources.NotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.influencers_app.R
import com.example.influencers_app.fragments.CampaignsFragment
import com.example.influencers_app.fragments.EarningsFragment
import com.example.influencers_app.fragments.HomeFragment
import com.example.influencers_app.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class homepage : AppCompatActivity() {
    lateinit var bnav:BottomNavigationView
    //lateinit var flout:FrameLayout
    lateinit var home_frag:Fragment
    lateinit var campg_frag:Fragment
    lateinit var earnings_frag:Fragment
    lateinit var profile_frag:Fragment
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        bnav = findViewById<BottomNavigationView>(R.id.btm_nav)
        //flout = findViewById(R.id.frame_lout_homepage)
        //supportFragmentManager.beginTransaction().replace(R.id.constraint,CampaignsFragment()).commit()

        home_frag = HomeFragment()
        campg_frag = CampaignsFragment()
        //earnings_frag
        earnings_frag = EarningsFragment()
        profile_frag = ProfileFragment()
        loadFragment(home_frag)

        bnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_frag -> {
                    loadFragment(home_frag)
                    true
                }
                R.id.campg_frag -> {
                    loadFragment(campg_frag)
                    true
                }
                R.id.earning_frag -> {
                    loadFragment(earnings_frag)
                    true
                }
                R.id.profile_frag -> {
                    loadFragment(profile_frag)
                    true
                }
                else -> {
                    throw NotFoundException("No Fragment Found")
                }
            }
        }
    }
    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_lout_homepage,fragment)
        transaction.commit()
    }
}