package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.rules_data_class

class rules_adapter(var datalist: MutableList<rules_data_class>): RecyclerView.Adapter<rules_adapter.viewHolder>() {
    class viewHolder (val itemView: View): RecyclerView.ViewHolder(itemView) {
        var rule_tv = itemView.findViewById<TextView>(R.id.rule)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rules_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var data = datalist.get(position)
        holder.rule_tv.text = data.rule.toString()
    }
}