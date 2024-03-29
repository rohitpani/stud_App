package com.example.influencers_app.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.activities.campaign_details
import com.example.influencers_app.models.campaign_list_home

class campaign_home_adapter(val datalist: MutableList<campaign_list_home>):RecyclerView.Adapter<campaign_home_adapter.viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.campaign_cards,parent,false)
        return  viewholder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var data_val = datalist.get(position)
        holder.bg_img.setImageResource(data_val.bg_img)
        holder.small_img.setImageResource(data_val.small_img)

        holder.campg_cards.setOnClickListener {
            val intent: Intent = Intent(holder.bg_img.context, campaign_details::class.java)
            holder.bg_img.context.startActivity(intent)
        }
    }

    class viewholder(val itemView:View) : ViewHolder(itemView) {
        var bg_img : ImageView = itemView.findViewById(R.id.bg_imgView)
        var small_img : ImageView = itemView.findViewById(R.id.small_imgView)
        var campg_cards:ConstraintLayout = itemView.findViewById(R.id.campaign_cards)
    }
}