package com.example.influencers_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.influencers_app.R

class under_review : AppCompatActivity() {
    lateinit var refresh_btn_under_review:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_under_review)
        refresh_btn_under_review = findViewById(R.id.refresh_btn_approval)
//        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
//
//        // Refresh function for the layout
//        swipeRefreshLayout.setOnRefreshListener{
//
//            val intent: Intent = Intent(this,welcome::class.java)
//            startActivity(intent)
//
//            // This line is important as it explicitly refreshes only once
//            // If "true" it implicitly refreshes forever
//            swipeRefreshLayout.isRefreshing = false
//        }
        refresh_btn_under_review.setOnClickListener {
            val intent: Intent = Intent(this,welcome::class.java)
            startActivity(intent)
        }

    }
}