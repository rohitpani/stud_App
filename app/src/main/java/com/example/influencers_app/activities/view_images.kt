package com.example.influencers_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.influencers_app.R
import com.example.influencers_app.utils.image_Slider_Adapter

class view_images : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: image_Slider_Adapter
    private lateinit var image_list: ArrayList<Int>
    var position:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_images)

        viewPager = findViewById(R.id.vpg1)
        image_list = ArrayList()
        image_list.add(R.drawable.ref_img1)
        image_list.add(R.drawable.ref_img2)
        image_list.add(R.drawable.ref_img3)
        image_list.add(R.drawable.ref_img4)
        image_list.add(R.drawable.ref_img5)

        position = intent.getIntExtra("position",0)

        viewPagerAdapter = image_Slider_Adapter(this,image_list)
        viewPager.adapter = viewPagerAdapter
        viewPager.currentItem =position

    }
}