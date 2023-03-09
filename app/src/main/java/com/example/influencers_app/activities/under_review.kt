package com.example.influencers_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.influencers_app.R

class under_review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_under_review)
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayout)

        // Refresh function for the layout
        swipeRefreshLayout.setOnRefreshListener{

            val intent: Intent = Intent(this,welcome::class.java)
            startActivity(intent)

            // This line is important as it explicitly refreshes only once
            // If "true" it implicitly refreshes forever
            swipeRefreshLayout.isRefreshing = false
        }
    }
}