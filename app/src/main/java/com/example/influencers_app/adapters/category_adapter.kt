package com.example.influencers_app.adapters

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.models.category_welcome

class category_adapter(val datalist: MutableList<category_welcome>,val count_tv: TextView) : RecyclerView.Adapter<category_adapter.viewHolder>() {

    var count = 0;
    val sel_cat_list:ArrayList<String> = ArrayList()
    class viewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var imgv = itemview.findViewById<ImageView>(R.id.cat_img)
        var tv = itemview.findViewById<TextView>(R.id.cat_name)
        var card_sel_lout = itemview.findViewById<LinearLayout>(R.id.border_welcome_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.welcome_cardlout,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var cat_data = datalist.get(position)
        holder.tv.text = cat_data.name
        holder.imgv.setImageResource(cat_data.img)
        holder.itemView.setOnClickListener{
            if(count >= 3){
                if(holder.card_sel_lout.visibility == View.VISIBLE){
                    holder.card_sel_lout.visibility = View.GONE
                    count--
                    sel_cat_list.remove(holder.tv.text.toString())
                }
            }
            else{
                if(holder.card_sel_lout.visibility == View.GONE){
                    holder.card_sel_lout.visibility = View.VISIBLE
                    count++
                    sel_cat_list.add(holder.tv.text.toString())
                }
                else{
                    holder.card_sel_lout.visibility = View.GONE
                    count--
                    sel_cat_list.remove(holder.tv.text.toString())
                }
            }
            count_tv.text = count.toString()
//            Toast.makeText(holder.card_sel_lout.context,sel_cat_list.toString(),Toast.LENGTH_LONG)
//            Log.d("contents of list",sel_cat_list.toString())
        }
    }
}