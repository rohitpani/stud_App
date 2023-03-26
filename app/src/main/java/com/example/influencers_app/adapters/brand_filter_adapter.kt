package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.models.brand_filter_data

class brand_filter_adapter(val brand_List : MutableList<brand_filter_data>):RecyclerView.Adapter<brand_filter_adapter.viewHolder>() {
    class viewHolder(val itmview: View): ViewHolder(itmview){
        var bname: TextView = itmview.findViewById(R.id.brand_name_filter_card)
        var brand_chk_box:CheckBox = itmview.findViewById(R.id.chkbox_brand_selection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brand_flter_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return brand_List.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val brand_data = brand_List.get(position)
        holder.bname.text = brand_data.brand_name
        holder.brand_chk_box.isChecked = false
    }
}