package com.example.influencers_app.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.activities.Brand_Details
import com.example.influencers_app.models.brands_listing_data

class brands_list_adapter(var datalist : MutableList<brands_listing_data>): RecyclerView.Adapter<brands_list_adapter.viewHolder>() {
    class viewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var brand_logo = itemView.findViewById<ImageView>(R.id.brand_list_card_logo)
        var brand_name = itemView.findViewById<TextView>(R.id.brand_name)
        var active_camp_count = itemView.findViewById<TextView>(R.id.active_camp_no)
        var brandlistcard = itemView.findViewById<CardView>(R.id.brand_list_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brand_listing_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var data = datalist.get(position)
        holder.brand_logo.setImageResource(data.brand_img)
        holder.brand_name.text = data.brand_name
        holder.active_camp_count.text = data.active_brand_camp.toString()
        holder.brandlistcard.setOnClickListener {
            val intent: Intent = Intent(holder.brand_logo.context,Brand_Details::class.java)
            intent.putExtra("brand_logo",data.brand_img)
            intent.putExtra("brand_name",data.brand_name)
            intent.putExtra("brand_active_campg",data.active_brand_camp.toString())
            intent.putExtra("brand_desc",data.brand_desc)
            holder.brand_logo.context.startActivity(intent)
        }
    }
}