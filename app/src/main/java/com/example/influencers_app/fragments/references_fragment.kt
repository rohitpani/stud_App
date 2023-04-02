package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.influencers_app.R
import com.example.influencers_app.activities.BrandListing
import com.example.influencers_app.activities.view_images

class references_fragment : Fragment() {
    lateinit var ref_img1: ImageView
    lateinit var ref_img2: ImageView
    lateinit var ref_img3: ImageView
    lateinit var ref_img4: ImageView
    lateinit var ref_img5: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_references_fragment, container, false)
        ref_img1 = rootView.findViewById(R.id.ref_img1)
        ref_img2 = rootView.findViewById(R.id.ref_img2)
        ref_img3 = rootView.findViewById(R.id.ref_img3)
        ref_img4 = rootView.findViewById(R.id.ref_img4)
        ref_img5 = rootView.findViewById(R.id.ref_img5)

        ref_img1.setOnClickListener {
            val intent: Intent = Intent(activity, view_images::class.java)
            intent.putExtra("position",0)
            startActivity(intent)
        }

        ref_img2.setOnClickListener {
            val intent: Intent = Intent(activity, view_images::class.java)
            intent.putExtra("position",1)
            startActivity(intent)
        }

        ref_img3.setOnClickListener {
            val intent: Intent = Intent(activity, view_images::class.java)
            intent.putExtra("position",2)
            startActivity(intent)
        }

        ref_img4.setOnClickListener {
            val intent: Intent = Intent(activity, view_images::class.java)
            intent.putExtra("position",3)
            startActivity(intent)
        }

        ref_img5.setOnClickListener {
            val intent: Intent = Intent(activity, view_images::class.java)
            intent.putExtra("position",4)
            startActivity(intent)
        }
        return rootView
    }
}