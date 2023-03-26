package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brand_filter_adapter
import com.example.influencers_app.adapters.category_adapter
import com.example.influencers_app.models.brand_filter_data

class brands_filter : AppCompatActivity() {
    lateinit var brands_recv_filter: RecyclerView
    lateinit var J : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brands_filter)
        brands_recv_filter = findViewById(R.id.brands_name_recv_filter)
        J = findViewById(R.id.letter_J)

        val brands_name_list_filter = mutableListOf<brand_filter_data>()

        brands_name_list_filter.add(0, brand_filter_data("AirBnb"))
        brands_name_list_filter.add(1,brand_filter_data("Ajio"))
        brands_name_list_filter.add(2,brand_filter_data("Asolo"))
        brands_name_list_filter.add(3,brand_filter_data("Beyoung"))
        brands_name_list_filter.add(4,brand_filter_data("Brighton"))
        brands_name_list_filter.add(5,brand_filter_data("Cole"))
        brands_name_list_filter.add(6,brand_filter_data("Callaway"))
        brands_name_list_filter.add(7,brand_filter_data("Colgate"))
        brands_name_list_filter.add(8,brand_filter_data("Diamont"))
        brands_name_list_filter.add(9,brand_filter_data("Daniels"))
        brands_name_list_filter.add(10,brand_filter_data("Deloitte"))
        brands_name_list_filter.add(11,brand_filter_data("Dell"))
        brands_name_list_filter.add(12,brand_filter_data("Diageo"))
        brands_name_list_filter.add(13,brand_filter_data("Element"))
        brands_name_list_filter.add(14,brand_filter_data("Edge"))
        brands_name_list_filter.add(15,brand_filter_data("Exame"))
        brands_name_list_filter.add(16,brand_filter_data("Ericsson"))
        brands_name_list_filter.add(17,brand_filter_data("Federal"))
        brands_name_list_filter.add(18,brand_filter_data("Fil"))
        brands_name_list_filter.add(19,brand_filter_data("Free People"))
        brands_name_list_filter.add(20,brand_filter_data("Fitbit"))
        brands_name_list_filter.add(21, brand_filter_data("Garmin"))
        brands_name_list_filter.add(22,brand_filter_data("Gatorade"))
        brands_name_list_filter.add(23,brand_filter_data("Guchhi"))
        brands_name_list_filter.add(24,brand_filter_data("Google"))
        brands_name_list_filter.add(25,brand_filter_data("Goldman Sachs"))
        brands_name_list_filter.add(26,brand_filter_data("GenPact"))
        brands_name_list_filter.add(27,brand_filter_data("GitHub"))
        brands_name_list_filter.add(28,brand_filter_data("Git"))
        brands_name_list_filter.add(29,brand_filter_data("GE Power"))
        brands_name_list_filter.add(30,brand_filter_data("HummingBird"))
        brands_name_list_filter.add(31,brand_filter_data("Honda Super"))
        brands_name_list_filter.add(32,brand_filter_data("H&M"))
        brands_name_list_filter.add(33,brand_filter_data("Hays"))
        brands_name_list_filter.add(34,brand_filter_data("Huawei"))
        brands_name_list_filter.add(35,brand_filter_data("Honeywell"))
        brands_name_list_filter.add(36,brand_filter_data("Iceberg"))
        brands_name_list_filter.add(37,brand_filter_data("IvyPark"))
        brands_name_list_filter.add(38,brand_filter_data("Inamorata"))
        brands_name_list_filter.add(39,brand_filter_data("ISKO"))
        brands_name_list_filter.add(40,brand_filter_data("Ike Behar"))
        brands_name_list_filter.add(41,brand_filter_data("Ignik"))
        brands_name_list_filter.add(42,brand_filter_data("Jet Airways"))
        brands_name_list_filter.add(43,brand_filter_data("Jetty"))
        brands_name_list_filter.add(44,brand_filter_data("Jack Rogers"))
        brands_name_list_filter.add(45,brand_filter_data("Jag"))
        brands_name_list_filter.add(46,brand_filter_data("Jack Kids"))
        brands_name_list_filter.add(47,brand_filter_data("kellog"))
        brands_name_list_filter.add(48,brand_filter_data("KingFisher"))
        brands_name_list_filter.add(49,brand_filter_data("K Wah"))
        brands_name_list_filter.add(50,brand_filter_data("Lavie"))
        brands_name_list_filter.add(51,brand_filter_data("Levesu"))
        brands_name_list_filter.add(52,brand_filter_data("H&M"))
        brands_name_list_filter.add(53,brand_filter_data("Hays"))
        brands_name_list_filter.add(54,brand_filter_data("Huawei"))
        brands_name_list_filter.add(55,brand_filter_data("Honeywell"))
        brands_name_list_filter.add(56,brand_filter_data("Iceberg"))
        brands_name_list_filter.add(57,brand_filter_data("IvyPark"))
        brands_name_list_filter.add(58,brand_filter_data("Inamorata"))
        brands_name_list_filter.add(59,brand_filter_data("ISKO"))
        brands_name_list_filter.add(60,brand_filter_data("Ike Behar"))

        val brands_filter_adapter = brand_filter_adapter(brands_name_list_filter)
        brands_recv_filter.layoutManager = GridLayoutManager(this,2)
        brands_recv_filter.adapter = brands_filter_adapter

        J.setOnClickListener {
            brands_recv_filter.scrollToPosition(60)
            //brands_recv_filter.smoothSnapToPosition(60)
            J.setTextColor(Color.BLUE)
        }

    }
    fun RecyclerView.smoothSnapToPosition(position: Int, snapMode: Int = LinearSmoothScroller.SNAP_TO_START) {
        val smoothScroller = object : LinearSmoothScroller(this.context) {
            override fun getVerticalSnapPreference(): Int = snapMode
            override fun getHorizontalSnapPreference(): Int = snapMode
        }
        smoothScroller.targetPosition = position
        layoutManager?.startSmoothScroll(smoothScroller)
    }
}