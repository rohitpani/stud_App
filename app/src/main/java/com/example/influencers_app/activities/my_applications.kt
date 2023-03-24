package com.example.influencers_app.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brand_campg_adapter
import com.example.influencers_app.adapters.my_applications_adapter
import com.example.influencers_app.models.my_applications_data
import com.example.influencers_app.utils.earningsFilterDialog
import com.example.influencers_app.utils.myApplicationsFilterDialog

class my_applications : AppCompatActivity() {
    lateinit var my_applications_recv:RecyclerView
    lateinit var filter_btn:ImageView
    lateinit var back_btn:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_applications)
        my_applications_recv = findViewById(R.id.my_applications_recv)
        filter_btn = findViewById(R.id.filter_btn_my_applications)
        back_btn = findViewById(R.id.my_allications_back_btn)

        val my_applications_list = mutableListOf<my_applications_data>()
        my_applications_list.add(0, my_applications_data(R.drawable.the_ordinary,"The Ordinary","20 January, 2019","Completed"))
        my_applications_list.add(1, my_applications_data(R.drawable.michael_kors,"Michael Kors","20 January, 2019","Pending"))
        my_applications_list.add(2, my_applications_data(R.drawable.air_bnb,"AirBnb","20 January, 2019","In Progress"))
        my_applications_list.add(3, my_applications_data(R.drawable.myglamm,"Myglamm","20 January, 2019","Rejected"))
        my_applications_list.add(4, my_applications_data(R.drawable.the_ordinary,"The Ordinary","20 January, 2019","Rejected"))
        my_applications_list.add(5, my_applications_data(R.drawable.michael_kors,"Michael Kors","20 January, 2019","Completed"))
        my_applications_list.add(6, my_applications_data(R.drawable.air_bnb,"AirBnb","20 January, 2019","In Progress"))
        my_applications_list.add(7, my_applications_data(R.drawable.myglamm,"Myglamm","20 January, 2019","Pending"))
        my_applications_list.add(8, my_applications_data(R.drawable.the_ordinary,"The Ordinary","20 January, 2019","Completed"))

        val my_application_lout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val my_application_adapter = my_applications_adapter(my_applications_list)
        my_applications_recv.layoutManager = my_application_lout
        my_applications_recv.adapter = my_application_adapter

        filter_btn.setOnClickListener {
            val btmsheet: myApplicationsFilterDialog = myApplicationsFilterDialog()
            this?.let { it1 -> btmsheet.show(it1.supportFragmentManager,"FilterSheet") }
        }

        back_btn.setOnClickListener {
            finish()
        }

    }
}