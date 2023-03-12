package com.example.influencers_app.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.activities.Brand_Details
import com.example.influencers_app.activities.campaign_details
import com.example.influencers_app.models.brands_campaign_details

class brand_campg_adapter(val datalist:MutableList<brands_campaign_details>) : RecyclerView.Adapter<brand_campg_adapter.viewHolder>() {
    class viewHolder(val itemview: View) : ViewHolder(itemview) {
        var back_img: ImageView = itemView.findViewById(R.id.campg_cover)
        var status_tv: TextView = itemView.findViewById(R.id.campg_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brand_campaign_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var data = datalist.get(position)
        holder.back_img.setImageResource(data.campg_cover)
        holder.status_tv.text = data.campg_status
        if (holder.status_tv.text.equals("ACTIVE")){
            holder.status_tv.background = ContextCompat.getDrawable(holder.status_tv.context,R.drawable.green_bg)
        }
        else{
            holder.status_tv.background = ContextCompat.getDrawable(holder.status_tv.context,R.drawable.red_bg)
        }
        holder.itemview.setOnClickListener{
            val intent: Intent = Intent(holder.back_img.context, campaign_details::class.java)
            holder.back_img.context.startActivity(intent)
        }
    }
}