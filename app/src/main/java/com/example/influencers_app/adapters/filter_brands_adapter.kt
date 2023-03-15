package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.models.filter_Brands_Data
import com.example.influencers_app.models.filter_Cards_Data

class filter_brands_adapter(val datalist:MutableList<filter_Brands_Data>) : RecyclerView.Adapter<filter_brands_adapter.viewHolder>() {
    class viewHolder(val item: View):ViewHolder(item) {
        val bimgv: ImageView = itemView.findViewById(R.id.brands_logo_filter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_brands_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       val data = datalist.get(position)
        holder.bimgv.setImageResource(data.brand_img)
    }
}