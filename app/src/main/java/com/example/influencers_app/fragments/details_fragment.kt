package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devs.readmoreoption.ReadMoreOption
import com.example.influencers_app.R

class details_fragment : Fragment() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootv =  inflater.inflate(R.layout.fragment_details_fragment, container, false)
        tv = rootv.findViewById(R.id.campg_overview)
        var readMoreOption = ReadMoreOption.Builder(activity)
            .textLength(235)
            .moreLabel("Read More")
            .lessLabel("Read Less")
            .moreLabelColor(Color.BLUE)
            .lessLabelColor(Color.BLUE)
            .labelUnderLine(false)
            .build();
        readMoreOption.addReadMoreTo(tv,tv.text.toString())
        return rootv
    }
}