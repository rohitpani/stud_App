package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.models.my_earning_Data
import org.w3c.dom.Text

class my_earnings_data_adapter(val datalist:MutableList<my_earning_Data>):RecyclerView.Adapter<my_earnings_data_adapter.viewHolder>() {
    class viewHolder(val itemView: View):ViewHolder(itemView) {
        val brand_logo:ImageView = itemView.findViewById(R.id.earning_brand_logo)
        var brand_id:TextView = itemView.findViewById(R.id.brand_id_my_earning_card)
        var brand_name:TextView = itemView.findViewById(R.id.brand_name_my_earning_card)
        var pay_date:TextView = itemView.findViewById(R.id.pay_date_in_my_earning_card)
        var pay_amt:TextView = itemView.findViewById(R.id.earning_amt_in_card)
        val day:TextView = itemView.findViewById(R.id.transaction_day_transaction_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_earnings_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.brand_logo.setImageResource(data.brand_img)
        holder.brand_id.text = data.brand_id
        holder.brand_name.text = data.brand_name
        holder.pay_amt.text = data.pay_amt
        holder.pay_date.text = data.pay_date
        if(position == 0){
            holder.day.visibility = View.VISIBLE
            holder.day.text = data.pay_day
        }
        else{
            val data_prev = datalist.get(position-1)
            if(data_prev.pay_day != data.pay_day){
                holder.day.visibility = View.VISIBLE
                holder.day.text = data.pay_day
            }
        }
    }
}
