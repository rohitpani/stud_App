package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.curated_data_home

class curated_home_adapter(val datalist:MutableList<curated_data_home>): RecyclerView.Adapter<curated_home_adapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.curated_card_home,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var data = datalist.get(position)
        holder.bgimg.setImageResource(data.bg_img)
        holder.logoimg.setImageResource(data.logo_img)
        holder.catg_name.text = data.catg_name
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    class viewHolder( var itemview: View): RecyclerView.ViewHolder(itemview) {

        var bgimg = itemview.findViewById<ImageView>(R.id.banner_curated)
        var logoimg = itemview.findViewById<ImageView>(R.id.logo_curated_lnout)
        var catg_name = itemview.findViewById<TextView>(R.id.camp_catg)

    }
}