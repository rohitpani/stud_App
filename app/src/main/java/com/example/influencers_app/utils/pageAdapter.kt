package com.example.influencers_app.utils

import android.content.res.Resources.NotFoundException
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.influencers_app.fragments.*

class pageAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    var tabcount =0;
    init{
        tabcount = behavior
    }
    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return details_fragment()
            1 -> return influencersCriteriaFragment()
            2 -> return deliverablesFragment()
            3 -> return dos_dontFragment()
            4 -> return references_fragment()
            else -> {
                throw NotFoundException("No position Found")
            }
        }
    }
}