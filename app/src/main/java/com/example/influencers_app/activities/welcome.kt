package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.category_adapter
import com.example.influencers_app.models.category_welcome

class welcome : AppCompatActivity() {
    lateinit var recv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        recv = findViewById(R.id.category_recv)
        var dataList: MutableList<category_welcome> = mutableListOf()
        dataList.add(0, category_welcome(R.drawable.luggage,"Travel"))
        dataList.add(1, category_welcome(R.drawable.fashion,"Fashion"))
        dataList.add(2,category_welcome(R.drawable.health,"Health"))
        dataList.add(3,category_welcome(R.drawable.beauty,"Beauty"))
        dataList.add(4,category_welcome(R.drawable.tech,"Tech"))
        dataList.add(5,category_welcome(R.drawable.photography,"Photography"))
        dataList.add(6,category_welcome(R.drawable.books,"Books"))
        dataList.add(7,category_welcome(R.drawable.food,"Food"))

        val adapter = category_adapter(dataList)
        recv.layoutManager = GridLayoutManager(this,3)
        recv.adapter = adapter
    }
}