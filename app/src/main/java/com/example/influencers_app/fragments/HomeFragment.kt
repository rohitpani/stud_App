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
import com.example.influencers_app.adapters.brands_home_adapter
import com.example.influencers_app.adapters.campaign_home_adapter
import com.example.influencers_app.adapters.category_adapter
import com.example.influencers_app.adapters.curated_home_adapter
import com.example.influencers_app.models.brands_list_home
import com.example.influencers_app.models.campaign_list_home
import com.example.influencers_app.models.category_welcome
import com.example.influencers_app.models.curated_data_home

class HomeFragment : Fragment() {

    lateinit var camp_recv_home:RecyclerView
    lateinit var brands_recv_home:RecyclerView
    lateinit var cat_recv_home:RecyclerView
    lateinit var curated_recv_home:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        camp_recv_home = rootView.findViewById(R.id.featured_campaign_recv_home)
        brands_recv_home = rootView.findViewById(R.id.brands_recv_home)
        cat_recv_home = rootView.findViewById(R.id.cat_recv_home)
        curated_recv_home = rootView.findViewById(R.id.curated_recv_home)

        val campaignlist:MutableList<campaign_list_home> = mutableListOf()
        campaignlist.add(0, campaign_list_home(R.drawable.air_bnb_bg,R.drawable.air_bnb))
        campaignlist.add(1, campaign_list_home(R.drawable.mamas_earth_bg,R.drawable.mamas_earth))
        campaignlist.add(2,campaign_list_home(R.drawable.nike_bg,R.drawable.nike))
        campaignlist.add(3,campaign_list_home(R.drawable.coca_cola_bg,R.drawable.coca_cola))

        val campaign_adapter = campaign_home_adapter(campaignlist)
        val campaign_lout = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        camp_recv_home.layoutManager = campaign_lout
        camp_recv_home.adapter = campaign_adapter


        val brandslist:MutableList<brands_list_home> = mutableListOf()
        brandslist.add(0, brands_list_home(R.drawable.wendys,3))
        brandslist.add(1,brands_list_home(R.drawable.air_bnb,3))
        brandslist.add(2,brands_list_home(R.drawable.handm,3))
        brandslist.add(3,brands_list_home(R.drawable.nike,3))
        brandslist.add(4,brands_list_home(R.drawable.the_ordinary,3))

        val brands_adapter = brands_home_adapter(brandslist)
        val brands_lout = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        brands_recv_home.layoutManager = brands_lout
        brands_recv_home.adapter = brands_adapter

        var catgList: MutableList<category_welcome> = mutableListOf()
        catgList.add(0, category_welcome(R.drawable.luggage,"Travel"))
        catgList.add(1, category_welcome(R.drawable.fashion,"Fashion"))
        catgList.add(2,category_welcome(R.drawable.health,"Health"))
        catgList.add(3,category_welcome(R.drawable.beauty,"Beauty"))
        catgList.add(4,category_welcome(R.drawable.tech,"Tech"))
        catgList.add(5,category_welcome(R.drawable.photography,"Photography"))
        catgList.add(6,category_welcome(R.drawable.books,"Books"))
        catgList.add(7,category_welcome(R.drawable.food,"Food"))

        val catgadapter = category_adapter(catgList)
        val cat_lout = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        cat_recv_home.layoutManager = cat_lout
        cat_recv_home.adapter = catgadapter

        var curatedList: MutableList<curated_data_home> = mutableListOf()
        curatedList.add(0, curated_data_home(R.drawable.summer_sales,R.drawable.the_ordinary,"Lifestyle, Skincare"))
        curatedList.add(1, curated_data_home(R.drawable.pizza,R.drawable.pizza_logo,"Food"))
        curatedList.add(2,curated_data_home(R.drawable.books_club,R.drawable.peng_books,"Books"))

        val curatedadapter = curated_home_adapter(curatedList)
        val curated_lout = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        curated_recv_home.layoutManager = curated_lout
        curated_recv_home.adapter = curatedadapter

        return rootView
    }



}