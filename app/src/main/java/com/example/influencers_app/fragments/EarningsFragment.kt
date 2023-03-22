package com.example.influencers_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.my_earnings_data_adapter
import com.example.influencers_app.models.my_earning_Data
import com.example.influencers_app.utils.BottomSheetDialogCampgFilter
import com.example.influencers_app.utils.earningsFilterDialog

class EarningsFragment : Fragment() {
    lateinit var earnings_recv:RecyclerView
    lateinit var earnings_filter_btn:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_earnings, container, false)
        earnings_recv = view.findViewById(R.id.my_earnings_recv)
        earnings_filter_btn = view.findViewById(R.id.filter_btn_my_earnings)

        val earnings_list : MutableList<my_earning_Data> = mutableListOf()
        earnings_list.add(0, my_earning_Data(R.drawable.myglamm,"Myglamm","#ID890760","20 January, 2019","₹ 5000","Today"))
        earnings_list.add(1, my_earning_Data(R.drawable.michael_kors,"Michael Kors","#ID890760","20 January, 2019","₹ 200","Today"))
        earnings_list.add(2, my_earning_Data(R.drawable.the_ordinary,"The Ordinary","#ID890760","20 January, 2019","₹ 120000","Today"))
        earnings_list.add(3, my_earning_Data(R.drawable.air_bnb,"AirBnb","#ID890760","20 January, 2019","₹ 900000","Yesterday"))
        earnings_list.add(4, my_earning_Data(R.drawable.mamas_earth,"MamasEarth","#ID890760","20 January, 2019","₹ 10000","Yesterday"))
        earnings_list.add(5, my_earning_Data(R.drawable.wendys,"Wendy's","#ID890760","20 January, 2019","₹ 8000","Yesterday"))
        earnings_list.add(6, my_earning_Data(R.drawable.nike,"Nike","#ID890760","20 January, 2019","₹ 600000","Yesterday"))
        earnings_list.add(7, my_earning_Data(R.drawable.peng_books,"Books","#ID890760","20 January, 2019","₹ 7000","Yesterday"))

        val earnings_adapter = my_earnings_data_adapter(earnings_list)
        earnings_recv.adapter = earnings_adapter
        val earnings_lnout = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        earnings_recv.layoutManager = earnings_lnout

        earnings_filter_btn.setOnClickListener {

            val btmsheet: earningsFilterDialog = earningsFilterDialog()
            activity?.let { it1 -> btmsheet.show(it1.supportFragmentManager,"FilterSheet") }

        }

        return view
    }

}