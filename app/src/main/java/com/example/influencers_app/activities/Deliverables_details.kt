package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.devs.readmoreoption.ReadMoreOption
import com.example.influencers_app.R

class Deliverables_details : AppCompatActivity() {
    lateinit var back_btn:ImageView
    lateinit var script1:LinearLayout
    lateinit var script2:LinearLayout
    lateinit var d_1_reel:TextView
    lateinit var d_content_flow:TextView
    lateinit var d_1_post:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliverables_details)
        back_btn = findViewById(R.id.deliverable_details_back_btn)
        script1 = findViewById(R.id.script1)
        script2 = findViewById(R.id.script2)
        d_1_reel = findViewById(R.id.deliverable_1_reel)
        d_content_flow = findViewById(R.id.deliverable_content_flow)
        d_1_post = findViewById(R.id.delivarable_1_post)
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

        var readMoreOption = ReadMoreOption.Builder(this)
            .textLength(235)
            .moreLabel("Read More")
            .lessLabel("Read Less")
            .moreLabelColor(Color.BLUE)
            .lessLabelColor(Color.BLUE)
            .labelUnderLine(false)
            .build();
        readMoreOption.addReadMoreTo(d_1_reel,d_1_reel.text.toString())
        readMoreOption.addReadMoreTo(d_content_flow,d_content_flow.text.toString())
        readMoreOption.addReadMoreTo(d_1_post,d_1_post.text.toString())

    }
}