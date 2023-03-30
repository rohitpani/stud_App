package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.influencers_app.R


class complete_campaign : AppCompatActivity() {
    lateinit var insta_plus_imgv:ImageView
    lateinit var insta_lout:LinearLayout
    lateinit var youtube_plus_imgv:ImageView
    lateinit var youtube_lout:LinearLayout
    lateinit var submit_btn:AppCompatButton
    lateinit var successDialog:AlertDialog
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_campaign)
        insta_plus_imgv = findViewById(R.id.plus_btn_insta_cont_add)
        insta_lout = findViewById(R.id.insta_content_lnout)
        youtube_plus_imgv = findViewById(R.id.plus_btn_utube_cont_add)
        youtube_lout = findViewById(R.id.utube_content_lnout)
        submit_btn = findViewById(R.id.submit_btn_complete_campaign)

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

        submit_btn.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val inflater:LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.successfully_applied_dialog,null)
            builder.setView(view)
            successDialog = builder.create()
            successDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            successDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val cancel_btn = view.findViewById<ImageView>(R.id.cancel_btn_successfully_applied_dialog)

            cancel_btn.setOnClickListener{
                successDialog.dismiss()
            }


            successDialog.show()
        }
    }
}