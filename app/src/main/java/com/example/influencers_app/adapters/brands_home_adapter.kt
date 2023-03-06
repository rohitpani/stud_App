package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.brands_list_home

class brands_home_adapter(val datalist:MutableList<brands_list_home>) : RecyclerView.Adapter<brands_home_adapter.viewHolder>() {


    class viewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brand_img : ImageView = itemView.findViewById(R.id.brand_img)
        val active_camp: TextView = itemView.findViewById(R.id.active_camp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brand_cards_home,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.brand_img.setImageResource(data.img)
        holder.active_camp.text = "Campaigns Active : 3"
    }

}