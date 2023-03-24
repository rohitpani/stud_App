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
import com.example.influencers_app.models.brands_list_home

class brands_home_adapter(val datalist:MutableList<brands_list_home>) : RecyclerView.Adapter<brands_home_adapter.viewHolder>() {


    class viewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brand_img : ImageView = itemView.findViewById(R.id.brand_img)
        val active_camp: TextView = itemView.findViewById(R.id.active_camp)
        val brands_cardv: CardView = itemView.findViewById(R.id.brands_card_home)
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
        holder.active_camp.text = "Campaigns Active : "+data.active_camp
        holder.brands_cardv.setOnClickListener{
            val intent: Intent = Intent(holder.brand_img.context, Brand_Details::class.java)
            intent.putExtra("brand_logo",data.img)
            intent.putExtra("brand_name",data.name)
            intent.putExtra("brand_active_campg",data.active_camp.toString())
            intent.putExtra("brand_desc",data.b_desc)
            holder.brand_img.context.startActivity(intent)
        }
    }

}