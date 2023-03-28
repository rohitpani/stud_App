package com.example.influencers_app.adapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.influencers_app.R

class brand_filter_adapter(val brand_List: MutableList<String>,val letters_lnout: LinearLayout):RecyclerView.Adapter<brand_filter_adapter.viewHolder>() {
    var positionlist:ArrayList<Int> = ArrayList()
    var selectedlist:ArrayList<String> = ArrayList()

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
        val brand_name = brand_List.get(position)
        holder.bname.text = brand_name

        holder.brand_chk_box.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                if(!positionlist.contains(position)) {
                    positionlist.add(position)
                }
                if(!selectedlist.contains(holder.bname.text.toString())){
                    selectedlist.add(holder.bname.text.toString())
                }
            }
            else{
                if(!positionlist.isEmpty()){
                    if(positionlist.contains(position)){
                        positionlist.remove(position)
                    }
                }
                if(!selectedlist.isEmpty()){
                    if(selectedlist.contains(holder.bname.text.toString())){
                        selectedlist.remove(holder.bname.text.toString())
                    }
                }
            }
        }

        if(!positionlist.isEmpty()){
            if(positionlist.contains(position)){
                holder.brand_chk_box.isChecked = true
            }
            else{
                holder.brand_chk_box.isChecked = false
            }
        }


        
//        Log.d("positionlist",positionlist.toString())
//        Log.d("selectionlist",selectedlist.toString())
//        Toast.makeText(holder.bname.context,positionlist.toString(),Toast.LENGTH_SHORT).show()
//        Toast.makeText(holder.bname.context,selectedlist.toString(),Toast.LENGTH_SHORT).show()
    }
}