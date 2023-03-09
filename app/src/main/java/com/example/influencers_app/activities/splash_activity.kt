package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.influencers_app.R

class splash_activity : AppCompatActivity() {
    lateinit var splash_imgv:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splash_imgv = findViewById(R.id.splash_gif_imgv)
        var runnable = object: Runnable{
            override fun run() {
                val intent: Intent = Intent(applicationContext,get_started::class.java)
                startActivity(intent)
                finish()
            }
        }
        var handler = Handler()
        handler.postDelayed(runnable,2000)
    }
}