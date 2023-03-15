package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.filter_Cards_Data

class filter_lout_adapter(val datalist:MutableList<filter_Cards_Data>) : RecyclerView.Adapter<filter_lout_adapter.viewHolder>() {
    class viewHolder(val itemView:View) : RecyclerView.ViewHolder(itemView) {
        val ftext: TextView = itemView.findViewById(R.id.f_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_cards_lout,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.ftext.text = data.value
    }
}