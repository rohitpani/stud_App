package com.example.influencers_app.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.example.influencers_app.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

class myApplicationsFilterDialog: BottomSheetDialogFragment() {
    lateinit var apply_btn: AppCompatButton
    lateinit var clearAll_btn: TextView
    lateinit var cancel: ImageView
    lateinit var radio_grp_app_filter: RadioGroup
    lateinit var radio_grp_time_filter: RadioGroup
    lateinit var applied: RadioButton
    lateinit var in_progress: RadioButton
    lateinit var pending: RadioButton
    lateinit var rejected: RadioButton
    lateinit var completed: RadioButton
    lateinit var last_7_days: RadioButton
    lateinit var last_30_days: RadioButton
    lateinit var custom_data: RadioButton
    lateinit var selected_filter: RadioButton
    lateinit var selected_time: RadioButton
    lateinit var date_lnout:LinearLayout
    lateinit var from_date:TextView
    lateinit var to_date:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.my_applications_filter_lnout,container,false)
        cancel = v.findViewById(R.id.filter_cancel_MyApplicationsDialog)
        apply_btn = v.findViewById(R.id.apply_btn_MyApplicationsFilter)
        clearAll_btn = v.findViewById(R.id.clearAll_btn_MyApplicationsFilter)
        radio_grp_app_filter = v.findViewById(R.id.radio_group_application_filter)
        radio_grp_time_filter = v.findViewById(R.id.radio_group_time_filter)
        applied = v.findViewById(R.id.applied_applications)
        in_progress = v.findViewById(R.id.in_progress_applications)
        pending = v.findViewById(R.id.pending_applications)
        rejected = v.findViewById(R.id.rejected_applications)
        completed = v.findViewById(R.id.completed_applications)
        last_7_days = v.findViewById(R.id.last_7_days)
        last_30_days = v.findViewById(R.id.last_30_days)
        custom_data = v.findViewById(R.id.custom_date)
        date_lnout = v.findViewById(R.id.custom_date_lnout)
        from_date = v.findViewById(R.id.from_date)
        to_date = v.findViewById(R.id.to_date)

        val onCheckedChangeListener  = object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, checkedId: Int) {
                selected_filter = v.findViewById(checkedId)
                selected_filter.background = resources.getDrawable(R.drawable.views_bg)
//                Toast.makeText(
//                    activity?.applicationContext, " On checked change :" +
//                            " ${selected_radio.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
                when(checkedId){
                    R.id.applied_applications -> {
                        in_progress.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        pending.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        rejected.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        completed.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.in_progress_applications -> {
                        applied.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        pending.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        rejected.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        completed.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.pending_applications -> {
                        applied.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        in_progress.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        rejected.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        completed.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    }
                    R.id.rejected_applications -> {
                        applied.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        in_progress.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        pending.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        completed.background = resources.getDrawable(R.drawable.radio_btn_bg)

                    }
                    R.id.completed_applications -> {
                        applied.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        in_progress.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        rejected.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        pending.background = resources.getDrawable(R.drawable.radio_btn_bg)

                    }
                }
            }

        }

        val onCheckedChangeListener_time  = object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, checkedId: Int) {
                selected_time = v.findViewById(checkedId)
                selected_time.background = resources.getDrawable(R.drawable.views_bg)
//                Toast.makeText(
//                    activity?.applicationContext, " On checked change :" +
//                            " ${selected_radio.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
                when(checkedId){
                    R.id.last_7_days -> {
                        last_30_days.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        custom_data.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        date_lnout.visibility = View.GONE
                    }
                    R.id.last_30_days -> {
                        last_7_days.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        custom_data.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        date_lnout.visibility = View.GONE
                    }
                    R.id.custom_date -> {
                        last_7_days.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        last_30_days.background = resources.getDrawable(R.drawable.radio_btn_bg)
                        date_lnout.visibility = View.VISIBLE
                    }
                }
            }

        }

        radio_grp_app_filter.setOnCheckedChangeListener(onCheckedChangeListener)
        radio_grp_time_filter.setOnCheckedChangeListener(onCheckedChangeListener_time)

        cancel.setOnClickListener {
            dismiss()
        }

        apply_btn.setOnClickListener {
            dismiss()
        }

        clearAll_btn.setOnClickListener {

            if(!applied.isChecked and !in_progress.isChecked and !pending.isChecked and !rejected.isChecked and !completed.isChecked and !last_7_days.isChecked and !last_30_days.isChecked and !custom_data.isChecked){
                Toast.makeText(activity?.applicationContext,"Nothing Selected",Toast.LENGTH_SHORT).show()
//                if(radio_grp_app_filter.checkedRadioButtonId.equals(null) and radio_grp_time_filter.checkedRadioButtonId.equals(null)){
//                    Toast.makeText(activity?.applicationContext,"Nothing Selected",Toast.LENGTH_SHORT).show()
//                }
//                else if(radio_grp_app_filter.checkedRadioButtonId.equals(null)){
//                    radio_grp_time_filter.setOnCheckedChangeListener(null)
//                    selected_time.background = resources.getDrawable(R.drawable.radio_btn_bg)
//                    radio_grp_time_filter.clearCheck()
//                    radio_grp_time_filter.setOnCheckedChangeListener(onCheckedChangeListener_time)
//                    date_lnout.visibility = View.GONE
//                }
//                else if(radio_grp_time_filter.checkedRadioButtonId.equals(null)){
//                    radio_grp_app_filter.setOnCheckedChangeListener(null)
//                    selected_filter.background = resources.getDrawable(R.drawable.radio_btn_bg)
//                    radio_grp_app_filter.clearCheck()
//                    radio_grp_app_filter.setOnCheckedChangeListener(onCheckedChangeListener)
//                }

            }
            else{

                if(applied.isChecked or in_progress.isChecked or pending.isChecked or rejected.isChecked or completed.isChecked){
                    radio_grp_app_filter.setOnCheckedChangeListener(null)
                    selected_filter.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    radio_grp_app_filter.clearCheck()
                    radio_grp_app_filter.setOnCheckedChangeListener(onCheckedChangeListener)
                }
                if(last_7_days.isChecked or last_30_days.isChecked or custom_data.isChecked){
                    radio_grp_time_filter.setOnCheckedChangeListener(null)
                    selected_time.background = resources.getDrawable(R.drawable.radio_btn_bg)
                    radio_grp_time_filter.clearCheck()
                    radio_grp_time_filter.setOnCheckedChangeListener(onCheckedChangeListener_time)
                    date_lnout.visibility = View.GONE
                }
            }

        }

        from_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    from_date.setText(dat)
                }, year, month, day)
            datePickerDialog.show()
        }

        to_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    to_date.setText(dat)
                }, year, month, day)
            datePickerDialog.show()
        }


        return v
    }


    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

}