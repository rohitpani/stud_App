package com.example.influencers_app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.influencers_app.R
import com.example.influencers_app.activities.get_started
import com.example.influencers_app.activities.my_applications
import com.example.influencers_app.utils.BottomSheetDialogCampgFilter
import com.example.influencers_app.utils.LogoutDialog

class ProfileFragment : Fragment() {
    lateinit var application_btn:LinearLayout
    lateinit var change_pswd_btn:LinearLayout
    lateinit var billiing_details_btn:LinearLayout
    lateinit var share_app_btn:LinearLayout
    lateinit var settings_btn:LinearLayout
    lateinit var logout_btn:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        application_btn = view.findViewById(R.id.applications_button)
        change_pswd_btn = view.findViewById(R.id.change_pswd_button)
        billiing_details_btn = view.findViewById(R.id.billing_details_button)
        share_app_btn = view.findViewById(R.id.share_app_button)
        settings_btn = view.findViewById(R.id.settings_button)
        logout_btn = view.findViewById(R.id.logout_button)


        logout_btn.setOnClickListener {
            val logout_sheet: LogoutDialog = LogoutDialog()
            activity?.let { it1 -> logout_sheet.show(it1.supportFragmentManager,"FilterSheet") }
        }

        application_btn.setOnClickListener {
            val intent: Intent = Intent(activity, my_applications::class.java)
            startActivity(intent)
        }


        return view
    }

}