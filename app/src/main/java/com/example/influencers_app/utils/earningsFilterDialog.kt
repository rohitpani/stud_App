package com.example.influencers_app.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.example.influencers_app.R
import com.example.influencers_app.activities.get_started
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class earningsFilterDialog: BottomSheetDialogFragment() {
    lateinit var apply_btn: AppCompatButton
    lateinit var clearAll_btn: TextView
    lateinit var cancel: ImageView
    lateinit var radio_grp:RadioGroup
    lateinit var all_activities:RadioButton
    lateinit var last_1_month:RadioButton
    lateinit var last_3_month:RadioButton
    lateinit var last_6_month:RadioButton
    lateinit var selected_radio:RadioButton
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.earnings_filter_lnout,container,false)
        cancel = v.findViewById(R.id.filter_cancel_EarningsDialog)
        apply_btn = v.findViewById(R.id.apply_btn_EarningsFilter)
        clearAll_btn = v.findViewById(R.id.clearAll_btn_EarningsFilter)
        radio_grp = v.findViewById(R.id.radio_group)
        all_activities = v.findViewById(R.id.all_activities)
        last_1_month = v.findViewById(R.id.last_1_month)
        last_3_month = v.findViewById(R.id.last_3_month)
        last_6_month = v.findViewById(R.id.last_6_month)
        selected_radio = all_activities
        val onCheckedChangeListener  = object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, checkedId: Int) {
                selected_radio = v.findViewById(checkedId)
                selected_radio.background = resources.getDrawable(R.drawable.views_bg)
//                Toast.makeText(
//                    activity?.applicationContext, " On checked change :" +
//                            " ${selected_radio.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
                when(checkedId){
                    R.id.all_activities -> {
                        last_1_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_3_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_6_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.last_1_month -> {
                        all_activities.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_3_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_6_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.last_3_month -> {
                        all_activities.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_1_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_6_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.last_6_month -> {
                        all_activities.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_1_month.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_3_month.background = resources.getDrawable(R.drawable.radio_btn_bg)

                    }
                }
            }

        }

        radio_grp.setOnCheckedChangeListener(onCheckedChangeListener)

        cancel.setOnClickListener {
            dismiss()
        }

        apply_btn.setOnClickListener {
            dismiss()
        }

        clearAll_btn.setOnClickListener {
            radio_grp.setOnCheckedChangeListener(null)
            selected_radio.background = resources.getDrawable(R.drawable.radio_btn_bg)
            radio_grp.clearCheck()
            radio_grp.setOnCheckedChangeListener(onCheckedChangeListener)
        }



        return v
    }


    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

}