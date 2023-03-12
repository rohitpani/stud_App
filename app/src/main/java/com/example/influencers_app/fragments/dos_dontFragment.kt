package com.example.influencers_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.rules_adapter
import com.example.influencers_app.models.rules_data_class

class dos_dontFragment : Fragment() {
    lateinit var dos_recv:RecyclerView
    lateinit var dont_recv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_dos_dont, container, false)
        dos_recv = root.findViewById(R.id.dos_recv)
        dont_recv = root.findViewById(R.id.donts_recv)

        var rules_list = mutableListOf<rules_data_class>()
        rules_list.add(0, rules_data_class("Lorem ipsum dolor sit amet consectetur. At"))
        rules_list.add(1, rules_data_class("Lorem ipsum dolor sit amet consectetur. At bi"))
        rules_list.add(2, rules_data_class("Lorem ipsum dolor sit amet consectetur. At bi"))
        rules_list.add(3, rules_data_class("Lorem ipsum dolor sit amet consectetur. At bibe"))
        rules_list.add(4, rules_data_class("Lorem ipsum dolor sit amet consectetur. At biben"))
        rules_list.add(5, rules_data_class("Lorem ipsum dolor sit amet consectetur. A"))
        rules_list.add(6, rules_data_class("Lorem ipsum dolor sit amet consectetur. A"))


        var dos_adapter = rules_adapter(rules_list)
        var donts_adapter = rules_adapter(rules_list)
        val dos_lnout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        val donts_lnout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

        dos_recv.adapter = dos_adapter
        dos_recv.layoutManager = dos_lnout
        dont_recv.adapter = donts_adapter
        dont_recv.layoutManager = donts_lnout

        return root
    }
}