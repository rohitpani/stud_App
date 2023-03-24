package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.influencers_app.R
import com.example.influencers_app.activities.Deliverables_details
import com.example.influencers_app.activities.FAQ_Activity

class deliverablesFragment : Fragment() {
    lateinit var insta_post:LinearLayout
    lateinit var youtube_post:LinearLayout
    lateinit var faQ_lout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_deliverables, container, false)
        insta_post = rootView.findViewById(R.id.insta_post)
        youtube_post = rootView.findViewById(R.id.youtube_post)
        faQ_lout = rootView.findViewById(R.id.faq_btn_deliverables)

        insta_post.setOnClickListener {
            val intent:Intent = Intent(activity,Deliverables_details::class.java)
            startActivity(intent)
        }

        youtube_post.setOnClickListener {
            val intent:Intent = Intent(activity,Deliverables_details::class.java)
            startActivity(intent)
        }

        faQ_lout.setOnClickListener {
            val intent:Intent = Intent(activity,FAQ_Activity::class.java)
            startActivity(intent)
        }

        return rootView
    }
}