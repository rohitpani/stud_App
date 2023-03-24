package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.faq_adapter
import com.example.influencers_app.models.faq_data

class FAQ_Activity : AppCompatActivity() {
    lateinit var faq_recv:RecyclerView
    lateinit var back_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)
        faq_recv = findViewById(R.id.faq_recv)
        back_btn = findViewById(R.id.faq_actvt_back_btn)

        val faqlist:MutableList<faq_data> = mutableListOf()
        faqlist.add(0, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(1, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(2, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(3, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(4, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(5, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(6, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))
        faqlist.add(7, faq_data("Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum","Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum.Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum"))

        val faq_adapter = faq_adapter(faqlist)
        var faq_lout = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        faq_recv.layoutManager = faq_lout
        faq_recv.adapter = faq_adapter

        back_btn.setOnClickListener {
            finish()
        }

    }
}