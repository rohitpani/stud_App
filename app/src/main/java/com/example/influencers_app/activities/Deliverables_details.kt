package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.influencers_app.R

class Deliverables_details : AppCompatActivity() {
    lateinit var back_btn:ImageView
    lateinit var script1:LinearLayout
    lateinit var script2:LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliverables_details)
        back_btn = findViewById(R.id.deliverable_details_back_btn)
        script1 = findViewById(R.id.script1)
        script2 = findViewById(R.id.script2)
        back_btn.setOnClickListener {
            finish()
        }
        script1.setOnClickListener {
            val intent: Intent = Intent(this,doc_viewer::class.java)
            startActivity(intent)
        }

        script2.setOnClickListener {
            val intent: Intent = Intent(this,doc_viewer::class.java)
            startActivity(intent)
        }

    }
}