package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.curated_home_adapter
import com.example.influencers_app.models.curated_data_home
import com.example.influencers_app.utils.BottomSheetDialogCampgFilter


class CampaignsFragment : Fragment() {
    lateinit var campaigns_recv: RecyclerView
    lateinit var filter_imgv:ImageView
    //lateinit var dialog:AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_campaigns, container, false)
        campaigns_recv = rootView.findViewById(R.id.campaign_list_recv)
        filter_imgv = rootView.findViewById(R.id.filter_btn_campaign_listing)

        var campaignList: MutableList<curated_data_home> = mutableListOf()
        campaignList.add(0, curated_data_home(R.drawable.summer_sales,R.drawable.the_ordinary,"Lifestyle, Skincare"))
        campaignList.add(1, curated_data_home(R.drawable.pizza,R.drawable.pizza_logo,"Food"))
        campaignList.add(2, curated_data_home(R.drawable.books_club,R.drawable.peng_books,"Books"))
        campaignList.add(3, curated_data_home(R.drawable.summer_sales,R.drawable.the_ordinary,"Lifestyle, Skincare"))
        campaignList.add(4, curated_data_home(R.drawable.pizza,R.drawable.pizza_logo,"Food"))
        campaignList.add(5, curated_data_home(R.drawable.books_club,R.drawable.peng_books,"Books"))


        campaigns_recv.isNestedScrollingEnabled = false
        val campaignadapter = curated_home_adapter(campaignList)
        val campaign_lout = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)
        campaigns_recv.layoutManager = campaign_lout
        campaigns_recv.adapter = campaignadapter

        filter_imgv.setOnClickListener{
//            val builder:AlertDialog.Builder = AlertDialog.Builder(activity)
//            var inflater:LayoutInflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val myview:View = inflater.inflate(R.layout.filter_lout,null)
//            builder.setView(myview)
//            dialog = builder.create();
//            var window: Window? = dialog.getWindow();
//            if (window != null) {
//                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
//            }
//            val params: ViewGroup.LayoutParams = dialog.getWindow()!!.getAttributes()
//            params.width = WindowManager.LayoutParams.MATCH_PARENT
//            params.height = WindowManager.LayoutParams.MATCH_PARENT
//            dialog.getWindow()?.setAttributes(params as WindowManager.LayoutParams)
//            dialog.getWindow()?.setGravity(Gravity.BOTTOM);
//            dialog.getWindow()?.setBackgroundDrawableResource(R.drawable.campg_filter_dialog_bg)
//            val cancel_btn = myview.findViewById<ImageView>(R.id.filter_cancel)
//            cancel_btn.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.show()

            val btmsheet:BottomSheetDialogCampgFilter = BottomSheetDialogCampgFilter()
            activity?.let { it1 -> btmsheet.show(it1.supportFragmentManager,"FilterSheet") }
        }



        return rootView
    }

}