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

class LogoutDialog: BottomSheetDialogFragment() {
    lateinit var cancel_btn:TextView
    lateinit var logout_btn:AppCompatButton
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.logout_lout,container,false)
        logout_btn = v.findViewById(R.id.logout_btn_dialog)
        cancel_btn = v.findViewById(R.id.cancel_logout_btn_dialog)

        logout_btn.setOnClickListener {
            dismiss()
            val intent: Intent = Intent(activity,get_started::class.java)
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