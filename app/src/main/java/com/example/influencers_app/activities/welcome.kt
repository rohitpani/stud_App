package com.example.influencers_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.category_adapter
import com.example.influencers_app.models.category_welcome

class welcome : AppCompatActivity() {
    lateinit var recv:RecyclerView
    lateinit var skip_tv:TextView
    lateinit var count_tv:TextView
    lateinit var proceed_btn: LinearLayout
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        recv = findViewById(R.id.category_recv)
        skip_tv = findViewById(R.id.skip_tv)
        count_tv = findViewById(R.id.select_count)
        proceed_btn = findViewById(R.id.proceed_btn)
        var dataList: MutableList<category_welcome> = mutableListOf()
        dataList.add(0, category_welcome(R.drawable.luggage,"Travel"))
        dataList.add(1, category_welcome(R.drawable.fashion,"Fashion"))
        dataList.add(2,category_welcome(R.drawable.health,"Health"))
        dataList.add(3,category_welcome(R.drawable.beauty,"Beauty"))
        dataList.add(4,category_welcome(R.drawable.tech,"Tech"))
        dataList.add(5,category_welcome(R.drawable.photography,"Photography"))
        dataList.add(6,category_welcome(R.drawable.books,"Books"))
        dataList.add(7,category_welcome(R.drawable.food,"Food"))
        dataList.add(8,category_welcome(R.drawable.fitness,"Fitness"))
        dataList.add(9,category_welcome(R.drawable.cinema,"Entertainment"))
        dataList.add(10,category_welcome(R.drawable.education,"Education"))
        dataList.add(11,category_welcome(R.drawable.gaming,"Gaming"))

        val adapter = category_adapter(dataList,count_tv)
        recv.layoutManager = GridLayoutManager(this,3)
        recv.adapter = adapter

        skip_tv.setOnClickListener{
            val intent: Intent = Intent(this,homepage::class.java)
            startActivity(intent)
            finishAffinity()
        }

        proceed_btn.setOnClickListener {
            val intent: Intent = Intent(this,homepage::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

}