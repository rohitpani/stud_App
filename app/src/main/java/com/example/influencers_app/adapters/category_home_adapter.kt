package com.example.influencers_app.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.category_welcome

class category_home_adapter(val datalist: MutableList<category_welcome>) : RecyclerView.Adapter<category_home_adapter.viewHolder>() {

    class viewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var imgv = itemview.findViewById<ImageView>(R.id.cat_img)
        var tv = itemview.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.welcome_cardlout,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var cat_data = datalist.get(position)
        holder.tv.text = cat_data.name
        holder.imgv.setImageResource(cat_data.img)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}