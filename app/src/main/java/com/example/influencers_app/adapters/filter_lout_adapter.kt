package com.example.influencers_app.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.filter_Cards_Data

class filter_lout_adapter(val datalist:MutableList<filter_Cards_Data>) : RecyclerView.Adapter<filter_lout_adapter.viewHolder>() {
    class viewHolder(val itemView:View) : RecyclerView.ViewHolder(itemView) {
        val ftext: TextView = itemView.findViewById(R.id.f_text)
        val ftext_checked: TextView = itemView.findViewById(R.id.checked_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_cards_lout,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.ftext.text = data.value

        holder.ftext.setOnClickListener {
            if(holder.ftext_checked.text.toString().equals("unchecked")){
                //Toast.makeText(holder.ftext.context,"Inside condition match",Toast.LENGTH_LONG).show()
                holder.ftext.background = holder.ftext.context.getDrawable(R.drawable.campaign_type_blue_bg)
                holder.ftext.setTextColor(holder.ftext.context.resources.getColor(R.color.white))
                holder.ftext_checked.text = "checked"
            }
            else{
                holder.ftext.background = holder.ftext.context.getDrawable(R.drawable.campaign_type_border_bg)
                holder.ftext.setTextColor(holder.ftext.context.resources.getColor(R.color.Nero))
                holder.ftext_checked.text = "unchecked"
            }
        }
    }
}