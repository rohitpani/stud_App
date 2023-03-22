package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.influencers_app.R


class complete_campaign : AppCompatActivity() {
    lateinit var insta_plus_imgv:ImageView
    lateinit var insta_lout:LinearLayout
    lateinit var youtube_plus_imgv:ImageView
    lateinit var youtube_lout:LinearLayout
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_campaign)
        insta_plus_imgv = findViewById(R.id.plus_btn_insta_cont_add)
        insta_lout = findViewById(R.id.insta_content_lnout)
        youtube_plus_imgv = findViewById(R.id.plus_btn_utube_cont_add)
        youtube_lout = findViewById(R.id.utube_content_lnout)

        insta_plus_imgv.setOnClickListener {

            val vi = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v: View = vi.inflate(R.layout.insta_inputs, null)
            insta_lout.addView(v)

        }

        youtube_plus_imgv.setOnClickListener {

            val vi = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v: View = vi.inflate(R.layout.youtube_inputs, null)
            youtube_lout.addView(v)

        }
    }
}