package com.example.influencers_app.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.influencers_app.R
import com.example.influencers_app.activities.*
import com.example.influencers_app.utils.BottomSheetDialogCampgFilter
import com.example.influencers_app.utils.LogoutDialog

class ProfileFragment : Fragment() {
    lateinit var application_btn:LinearLayout
    lateinit var change_pswd_btn:LinearLayout
    lateinit var billiing_details_btn:LinearLayout
    lateinit var share_app_btn:LinearLayout
    lateinit var settings_btn:LinearLayout
    lateinit var logout_btn:LinearLayout
    lateinit var profile_edit:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        application_btn = view.findViewById(R.id.applications_button)
        change_pswd_btn = view.findViewById(R.id.change_pswd_button)
        billiing_details_btn = view.findViewById(R.id.billing_details_button)
        share_app_btn = view.findViewById(R.id.share_app_button)
        settings_btn = view.findViewById(R.id.settings_button)
        logout_btn = view.findViewById(R.id.logout_button)
        profile_edit = view.findViewById(R.id.profile_edit)


        logout_btn.setOnClickListener {
            val logout_sheet: LogoutDialog = LogoutDialog()
            activity?.let { it1 -> logout_sheet.show(it1.supportFragmentManager,"FilterSheet") }
        }

        application_btn.setOnClickListener {
            val intent: Intent = Intent(activity, my_applications::class.java)
            startActivity(intent)
        }

        change_pswd_btn.setOnClickListener {
            val intent: Intent = Intent(activity, change_password::class.java)
            startActivity(intent)
        }

        billiing_details_btn.setOnClickListener {
            val intent: Intent = Intent(activity, billing_Details::class.java)
            startActivity(intent)
        }

        share_app_btn.setOnClickListener {
            val sharingIntent: Intent = Intent(Intent.ACTION_SEND)
            sharingIntent.setType("text/plain")
            val shareBody = "http://studApp.apk"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        settings_btn.setOnClickListener {
            val intent: Intent = Intent(activity, settings::class.java)
            startActivity(intent)
        }

        profile_edit.setOnClickListener {
            val intent: Intent = Intent(activity, edit_profile::class.java)
            startActivity(intent)
        }

        return view
    }

}