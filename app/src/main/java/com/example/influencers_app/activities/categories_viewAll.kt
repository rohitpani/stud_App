package com.example.influencers_app.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.category_home_adapter
import com.example.influencers_app.models.category_welcome

class categories_viewAll : AppCompatActivity() {
    lateinit var view_all_category_recv:RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories_view_all)
        view_all_category_recv = findViewById(R.id.categories_viewAll_recv)

        var catgList: MutableList<category_welcome> = mutableListOf()
        catgList.add(0, category_welcome(R.drawable.luggage,"Travel"))
        catgList.add(1, category_welcome(R.drawable.fashion,"Fashion"))
        catgList.add(2, category_welcome(R.drawable.health,"Health"))
        catgList.add(3, category_welcome(R.drawable.beauty,"Beauty"))
        catgList.add(4, category_welcome(R.drawable.tech,"Tech"))
        catgList.add(5, category_welcome(R.drawable.photography,"Photography"))
        catgList.add(6, category_welcome(R.drawable.books,"Books"))
        catgList.add(7, category_welcome(R.drawable.food,"Food"))
        catgList.add(8, category_welcome(R.drawable.fitness,"Fitness"))
        catgList.add(9, category_welcome(R.drawable.cinema,"Entertainment"))
        catgList.add(10, category_welcome(R.drawable.education,"Education"))
        catgList.add(11, category_welcome(R.drawable.gaming,"Gaming"))
        catgList.add(12, category_welcome(R.drawable.luggage,"Travel"))
        catgList.add(13, category_welcome(R.drawable.fashion,"Fashion"))
        catgList.add(14, category_welcome(R.drawable.health,"Health"))
        catgList.add(15, category_welcome(R.drawable.beauty,"Beauty"))
        catgList.add(16, category_welcome(R.drawable.tech,"Tech"))

        val catgadapter = category_home_adapter(catgList)
        val cat_lout = GridLayoutManager(this, 3)
        view_all_category_recv.layoutManager = cat_lout
        view_all_category_recv.adapter = catgadapter

    }
}