package com.example.influencers_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R
import com.example.influencers_app.models.faq_data

class faq_adapter(val datalist: MutableList<faq_data>,val faq_recv: RecyclerView):RecyclerView.Adapter<faq_adapter.viewHolder>() {
    class viewHolder(val itemView: View):ViewHolder(itemView) {
        val ques_tv:TextView = itemView.findViewById(R.id.faq_question)
        val ques_ans:TextView = itemView.findViewById(R.id.faq_answer)
        val plus_btn:ImageButton = itemView.findViewById(R.id.faq_plus_btn)
        val minus_btn:ImageButton = itemView.findViewById(R.id.faq_minus_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.faq_card,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int{
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = datalist.get(position)
        holder.ques_tv.text = data.faq_ques
        holder.ques_ans.text = data.ques_ans


        holder.plus_btn.setOnClickListener{
                val x: Int = getItemCount()
                var i = 0
                while (i < x) {
                    val temp_hold: viewHolder = faq_recv.getChildViewHolder(faq_recv.getChildAt(i)) as viewHolder
                    if(temp_hold.minus_btn.visibility == View.VISIBLE){
                        temp_hold.minus_btn.visibility = View.GONE
                        temp_hold.plus_btn.visibility = View.VISIBLE
                        temp_hold.ques_ans.visibility = View.GONE
                    }
                    ++i
                }


            holder.plus_btn.visibility = View.GONE
            holder.minus_btn.visibility = View.VISIBLE
            holder.ques_ans.visibility = View.VISIBLE
        }

        holder.minus_btn.setOnClickListener{
            holder.minus_btn.visibility = View.GONE
            holder.plus_btn.visibility = View.VISIBLE
            holder.ques_ans.visibility = View.GONE
        }
    }
}