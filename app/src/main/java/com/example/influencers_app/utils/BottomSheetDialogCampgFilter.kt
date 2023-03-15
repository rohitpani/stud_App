package com.example.influencers_app.utils

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brands_list_adapter
import com.example.influencers_app.adapters.filter_brands_adapter
import com.example.influencers_app.adapters.filter_lout_adapter
import com.example.influencers_app.models.brands_listing_data
import com.example.influencers_app.models.filter_Brands_Data
import com.example.influencers_app.models.filter_Cards_Data
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogCampgFilter: BottomSheetDialogFragment() {
    lateinit var campg_type_recv:RecyclerView
    lateinit var brands_recv:RecyclerView
    lateinit var interests_recv:RecyclerView
    lateinit var language_recv:RecyclerView
    lateinit var cancel:ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.filter_lout,container,false)
        cancel = v.findViewById(R.id.filter_cancel)
        campg_type_recv = v.findViewById(R.id.campg_type_filter_recv)
        brands_recv = v.findViewById(R.id.brands_filter_recv)
        interests_recv = v.findViewById(R.id.interests_filter_recv)
        language_recv = v.findViewById(R.id.language_filter_recv)

        cancel.setOnClickListener {
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