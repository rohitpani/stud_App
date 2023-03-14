package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.curated_home_adapter
import com.example.influencers_app.models.curated_data_home

class CampaignsFragment : Fragment() {
    lateinit var campaigns_recv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_campaigns, container, false)
        campaigns_recv = rootView.findViewById(R.id.campaign_list_recv)

        var campaignList: MutableList<curated_data_home> = mutableListOf()
        campaignList.add(0, curated_data_home(R.drawable.summer_sales,R.drawable.the_ordinary,"Lifestyle, Skincare"))
        campaignList.add(1, curated_data_home(R.drawable.pizza,R.drawable.pizza_logo,"Food"))
        campaignList.add(2, curated_data_home(R.drawable.books_club,R.drawable.peng_books,"Books"))
        campaignList.add(3, curated_data_home(R.drawable.summer_sales,R.drawable.the_ordinary,"Lifestyle, Skincare"))
        campaignList.add(4, curated_data_home(R.drawable.pizza,R.drawable.pizza_logo,"Food"))
        campaignList.add(5, curated_data_home(R.drawable.books_club,R.drawable.peng_books,"Books"))


        campaigns_recv.isNestedScrollingEnabled = false
        val campaignadapter = curated_home_adapter(campaignList)
        val campaign_lout = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)
        campaigns_recv.layoutManager = campaign_lout
        campaigns_recv.adapter = campaignadapter

        return rootView
    }

}