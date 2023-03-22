package com.example.influencers_app.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.activities.application_status
import com.example.influencers_app.activities.campaign_details
import com.example.influencers_app.activities.my_applications
import com.example.influencers_app.models.my_applications_data

class my_applications_adapter(val datalist:MutableList<my_applications_data>):RecyclerView.Adapter<my_applications_adapter.viewHolder>() {

    class viewHolder(val itemView: View):ViewHolder(itemView){
        var brand_img = itemView.findViewById<ImageView>(R.id.my_appli_brand_logo)
        var brand_name = itemView.findViewById<TextView>(R.id.brand_name_my_application_card)
        var application_date  = itemView.findViewById<TextView>(R.id.application_date_in_my_appication_card)
        var application_status = itemView.findViewById<TextView>(R.id.my_application_status)
        var chat_icon = itemView.findViewById<ImageView>(R.id.chat_icon_my_application_card)
        var view_brief = itemView.findViewById<TextView>(R.id.view_brief_my_application)
        var cardv = itemView.findViewById<CardView>(R.id.my_application_cardv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_application_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.brand_img.setImageResource(data.img)
        holder.brand_name.text = data.brand_name
        holder.application_date.text = data.application_date
        holder.application_status.text = data.application_status
        if(data.application_status.equals("Rejected")){
            holder.chat_icon.visibility = View.VISIBLE
            holder.view_brief.visibility = View.VISIBLE
            holder.application_status.setTextColor(holder.application_status.context.resources.getColor(R.color.red))
        }
        else if(data.application_status.equals("In Progress")){
            holder.chat_icon.visibility = View.VISIBLE
            holder.view_brief.visibility = View.VISIBLE
            holder.application_status.setTextColor(holder.application_status.context.resources.getColor(R.color.yellow))
        }
        else if(data.application_status.equals("Pending")){
            holder.chat_icon.visibility = View.VISIBLE
            holder.view_brief.visibility = View.VISIBLE
            holder.application_status.setTextColor(holder.application_status.context.resources.getColor(R.color.orange))
        }
        else if(data.application_status.equals("Completed")){
            holder.application_status.setTextColor(holder.application_status.context.resources.getColor(R.color.green))
            holder.application_status.background = holder.application_status.context.resources.getDrawable(R.drawable.green_bg_application_status)
        }

        holder.cardv.setOnClickListener {
            val intent: Intent = Intent(holder.cardv.context, application_status::class.java)
            intent.putExtra("brand_name",data.brand_name)
            intent.putExtra("brand_logo",data.img)
            intent.putExtra("application_status",data.application_status)
            intent.putExtra("application_date",data.application_date)
            holder.cardv.context.startActivity(intent)
        }

    }

}