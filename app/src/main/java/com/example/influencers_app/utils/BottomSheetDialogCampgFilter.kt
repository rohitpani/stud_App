package com.example.influencers_app.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.activities.brands_filter
import com.example.influencers_app.activities.get_started
import com.example.influencers_app.adapters.brands_list_adapter
import com.example.influencers_app.adapters.filter_brands_adapter
import com.example.influencers_app.adapters.filter_lout_adapter
import com.example.influencers_app.models.brands_listing_data
import com.example.influencers_app.models.filter_Brands_Data
import com.example.influencers_app.models.filter_Cards_Data
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.RangeSlider

class BottomSheetDialogCampgFilter: BottomSheetDialogFragment() {
    lateinit var campg_type_recv:RecyclerView
    lateinit var pricing_type_recv:RecyclerView
    lateinit var brands_recv:RecyclerView
    lateinit var interests_recv:RecyclerView
    lateinit var language_recv:RecyclerView
    lateinit var cancel:ImageView
    lateinit var insta_lnout:LinearLayout
    lateinit var youtube_lnout:LinearLayout
    lateinit var brands_filter_viewAll:TextView
    lateinit var instag_chckd_status:TextView
    lateinit var youtube_chckd_status:TextView
    lateinit var start_range:TextView
    lateinit var end_range:TextView
    lateinit var age_range_slider:RangeSlider
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.filter_lout,container,false)
        cancel = v.findViewById(R.id.filter_cancel)
        campg_type_recv = v.findViewById(R.id.campg_type_filter_recv)
        pricing_type_recv = v.findViewById(R.id.pricing_type_filter_recv)
        brands_recv = v.findViewById(R.id.brands_filter_recv)
        interests_recv = v.findViewById(R.id.interests_filter_recv)
        language_recv = v.findViewById(R.id.language_filter_recv)
        insta_lnout = v.findViewById(R.id.insta_lnout_filter)
        youtube_lnout = v.findViewById(R.id.youtube_lnout_filter)
        brands_filter_viewAll = v.findViewById(R.id.brands_filter_view_All)
        instag_chckd_status = v.findViewById(R.id.insta_chekd_status)
        youtube_chckd_status = v.findViewById(R.id.utube_chekd_status)
        start_range = v.findViewById(R.id.start_range)
        end_range = v.findViewById(R.id.end_range)
        age_range_slider = v.findViewById(R.id.age_seek)

        cancel.setOnClickListener {
            dismiss()
        }

        brands_filter_viewAll.setOnClickListener {
            val intent: Intent = Intent(activity, brands_filter::class.java)
            startActivity(intent)
            dismiss()
        }

        val campg_types_list = mutableListOf<filter_Cards_Data>()
        campg_types_list.add(0, filter_Cards_Data("Advocacy"))
        campg_types_list.add(1, filter_Cards_Data("Review"))
        campg_types_list.add(2, filter_Cards_Data("Collaboration"))

        val filter_adapter = filter_lout_adapter(campg_types_list)
        val filter_lout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        campg_type_recv.layoutManager = filter_lout
        campg_type_recv.adapter = filter_adapter


        val pricing_types_list = mutableListOf<filter_Cards_Data>()
        pricing_types_list.add(0, filter_Cards_Data("Barter"))
        pricing_types_list.add(1, filter_Cards_Data("Paid"))

        val pricing_adapter = filter_lout_adapter(pricing_types_list)
        val pricing_lout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        pricing_type_recv.layoutManager = pricing_lout
        pricing_type_recv.adapter = pricing_adapter

        val brands_list = mutableListOf<filter_Brands_Data>()
        brands_list.add(0, filter_Brands_Data(R.drawable.myglamm))
        brands_list.add(1, filter_Brands_Data(R.drawable.michael_kors))
        brands_list.add(2, filter_Brands_Data(R.drawable.air_bnb))
        brands_list.add(3, filter_Brands_Data(R.drawable.michael_kors))
        brands_list.add(4, filter_Brands_Data(R.drawable.handm))

        val brands_adapter = filter_brands_adapter(brands_list)
        val brands_lout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        brands_recv.layoutManager = brands_lout
        brands_recv.adapter = brands_adapter


        val interests_list = mutableListOf<filter_Cards_Data>()
        interests_list.add(0, filter_Cards_Data("Travel"))
        interests_list.add(1, filter_Cards_Data("Fashion"))
        interests_list.add(2, filter_Cards_Data("Tech"))
        interests_list.add(3, filter_Cards_Data("Makeup"))

        val interests_adapter = filter_lout_adapter(interests_list)
        val interests_lout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        interests_recv.layoutManager = interests_lout
        interests_recv.adapter = interests_adapter

        val language_list = mutableListOf<filter_Cards_Data>()
        language_list.add(0, filter_Cards_Data("English"))
        language_list.add(1, filter_Cards_Data("Hindi"))
        language_list.add(2, filter_Cards_Data("Marathi"))
        language_list.add(3, filter_Cards_Data("Telugu"))
        language_list.add(4, filter_Cards_Data("Kannada"))

        val language_adapter = filter_lout_adapter(language_list)
        val language_lout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        language_recv.layoutManager = language_lout
        language_recv.adapter = language_adapter

        insta_lnout.setOnClickListener {
            if(instag_chckd_status.text.toString().equals("unchecked")){
                insta_lnout.background = resources.getDrawable(R.drawable.social_media_blue_bg)
                instag_chckd_status.text = "checked"
            }
            else{
                insta_lnout.background = resources.getDrawable(R.drawable.social_media_bg)
                instag_chckd_status.text = "unchecked"
            }
        }

        youtube_lnout.setOnClickListener {
            if(youtube_chckd_status.text.toString().equals("unchecked")){
                youtube_lnout.background = resources.getDrawable(R.drawable.social_media_blue_bg)
                youtube_chckd_status.text = "checked"
            }
            else{
                youtube_lnout.background = resources.getDrawable(R.drawable.social_media_bg)
                youtube_chckd_status.text = "unchecked"
            }
        }


        age_range_slider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: RangeSlider) {
                val values = slider.values

                start_range.text = values[0].toInt().toString()
                end_range.text = values[1].toInt().toString()
                //Those are the satrt and end values of sldier when user start dragging
                Log.i("SliderPreviousValue Fr", values[0].toString())
                Log.i("SliderPreviousValue To", values[1].toString())
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                val values = slider.values
                start_range.text = values[0].toInt().toString()
                end_range.text = values[1].toInt().toString()

                //Those are the new updated values of sldier when user has finshed dragging
                Log.i("SliderNewValue From", values[0].toString())
                Log.i("SliderNewValue To", values[1].toString())

                //textView.setText("Start value: ${values[0]}, End value: ${values[1]}")
            }
        })
        return v
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun getTheme() = R.style.CustomBottomSheetDialogTheme
}