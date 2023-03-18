package com.example.influencers_app.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.influencers_app.R
import com.example.influencers_app.activities.get_started
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class deleteAccountDialog: BottomSheetDialogFragment() {
    lateinit var cancel_btn: AppCompatButton
    lateinit var delete_btn: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.delete_account_lout,container,false)
        delete_btn = v.findViewById(R.id.delete_btn_delete_account_dialog)
        cancel_btn = v.findViewById(R.id.cancel_btn_delete_account_dialog)

        delete_btn.setOnClickListener {
            dismiss()
            val intent: Intent = Intent(activity, get_started::class.java)
            startActivity(intent)
            activity?.finish()
        }

        cancel_btn.setOnClickListener {
            dismiss()
        }

        return v
    }

    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

}