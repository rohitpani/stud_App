package com.example.influencers_app.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.influencers_app.R
import java.io.File
import java.io.FileInputStream
import java.util.*

class image_Slider_Adapter(val context: Context, val imageList: ArrayList<Int>) : PagerAdapter() {
    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = mLayoutInflater.inflate(R.layout.img_slider_item,container,false)
        val imageView = itemView.findViewById<View>(R.id.imgv) as ImageView
        imageView.setImageResource(imageList.get(position))
        Objects.requireNonNull(container).addView(itemView)
//        views.put(position,imageList.get(position))
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
//        views.put(position,imageList.get(position))
    }
}