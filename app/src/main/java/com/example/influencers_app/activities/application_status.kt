package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.influencers_app.R

class application_status : AppCompatActivity() {
    lateinit var completed_date:TextView
    lateinit var brand_name:TextView
    lateinit var brand_logo:ImageView
    lateinit var application_date:TextView
    lateinit var profile_status_tv:TextView
    lateinit var application_status_tv:TextView
    lateinit var green_profile:ImageView
    lateinit var orange_profile:ImageView
    lateinit var red_profile:ImageView
    lateinit var green_line: View
    lateinit var red_line:ImageView
    lateinit var gray_line:ImageView
    lateinit var rejected_status:ImageView
    lateinit var completed_status:ImageView
    lateinit var pending_status:ImageView
    lateinit var in_prgress_status:ImageView
    lateinit var mark_as_complete_btn:Button
    lateinit var completed_lout:LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_status)

        completed_date = findViewById(R.id.completed_date_in_applicatin_status)
        brand_name = findViewById(R.id.brand_name_my_appcn_status)
        brand_logo = findViewById(R.id.brand_imgv_appcn_status)
        application_date = findViewById(R.id.campaign_date_appcn_status)
        profile_status_tv = findViewById(R.id.profile_status_appcn_status)
        application_status_tv = findViewById(R.id.appcn_status_my_application)
        green_profile = findViewById(R.id.green_profile)
        orange_profile = findViewById(R.id.orange_profile)
        red_profile = findViewById(R.id.red_profile)
        green_line = findViewById(R.id.green_line)
        red_line = findViewById(R.id.red_line)
        gray_line = findViewById(R.id.gray_line)
        rejected_status = findViewById(R.id.rejected_status)
        completed_status = findViewById(R.id.completed_status)
        pending_status = findViewById(R.id.pending_status)
        in_prgress_status = findViewById(R.id.in_progress_status)
        mark_as_complete_btn = findViewById(R.id.mark_as_cmplt_btn)
        completed_lout = findViewById(R.id.application_status_completed_details_lnout)

        val bname = intent.getStringExtra("brand_name")
        val bimg = intent.getIntExtra("brand_logo",R.drawable.air_bnb)
        val appcn_status = intent.getStringExtra("application_status")
        val applicn_date = intent.getStringExtra("application_date")

        brand_name.text = bname
        brand_logo.setImageResource(bimg)
        application_date.text = applicn_date+". 1:33pm."

        if(appcn_status.equals("Rejected")){
            completed_date.visibility = View.GONE
            green_profile.visibility = View.GONE
            orange_profile.visibility = View.GONE
            red_profile.visibility = View.VISIBLE
            green_line.visibility = View.GONE
            gray_line.visibility = View.GONE
            red_line.visibility = View.VISIBLE
            completed_status.visibility = View.GONE
            pending_status.visibility = View.GONE
            in_prgress_status.visibility = View.GONE
            rejected_status.visibility = View.VISIBLE
            mark_as_complete_btn.visibility = View.GONE
            completed_lout.visibility = View.GONE

            profile_status_tv.text = "Rejected"
            profile_status_tv.setTextColor(this.resources.getColor(R.color.red))
            profile_status_tv.background = this.resources.getDrawable(R.drawable.red_bg_application_status)

            application_status_tv.text = "Rejected"
            application_status_tv.setTextColor(this.resources.getColor(R.color.red))
            application_status_tv.background = this.resources.getDrawable(R.drawable.red_bg_application_status)

        }
        else if(appcn_status.equals("In Progress")){
            completed_date.visibility = View.GONE
            green_profile.visibility = View.VISIBLE
            orange_profile.visibility = View.GONE
            red_profile.visibility = View.GONE
            green_line.visibility = View.VISIBLE
            gray_line.visibility = View.GONE
            red_line.visibility = View.GONE
            completed_status.visibility = View.GONE
            pending_status.visibility = View.GONE
            in_prgress_status.visibility = View.VISIBLE
            rejected_status.visibility = View.GONE
            mark_as_complete_btn.visibility = View.VISIBLE
            completed_lout.visibility = View.GONE

            profile_status_tv.text = "Approved"
            profile_status_tv.setTextColor(this.resources.getColor(R.color.green))
            profile_status_tv.background = this.resources.getDrawable(R.drawable.green_bg_application_status)

            application_status_tv.text = "In Progress"
            application_status_tv.setTextColor(this.resources.getColor(R.color.yellow))
            application_status_tv.background = this.resources.getDrawable(R.drawable.yellow_bg_applicatin_status)
        }
        else if(appcn_status.equals("Pending")){
            completed_date.visibility = View.GONE
            green_profile.visibility = View.GONE
            orange_profile.visibility = View.VISIBLE
            red_profile.visibility = View.GONE
            green_line.visibility = View.GONE
            gray_line.visibility = View.VISIBLE
            red_line.visibility = View.GONE
            completed_status.visibility = View.GONE
            pending_status.visibility = View.VISIBLE
            in_prgress_status.visibility = View.GONE
            rejected_status.visibility = View.GONE
            mark_as_complete_btn.visibility = View.GONE
            completed_lout.visibility = View.GONE

            profile_status_tv.text = "Under Review"
            profile_status_tv.setTextColor(this.resources.getColor(R.color.yellow))
            profile_status_tv.background = this.resources.getDrawable(R.drawable.yellow_bg_applicatin_status)

            application_status_tv.text = "Pending"
            application_status_tv.setTextColor(this.resources.getColor(R.color.orange))
            application_status_tv.background = this.resources.getDrawable(R.drawable.orange_bg_application_status)
        }
        else if(appcn_status.equals("Completed")){
            completed_date.visibility = View.VISIBLE
            green_profile.visibility = View.VISIBLE
            orange_profile.visibility = View.GONE
            red_profile.visibility = View.GONE
            green_line.visibility = View.VISIBLE
            gray_line.visibility = View.GONE
            red_line.visibility = View.GONE
            completed_status.visibility = View.VISIBLE
            pending_status.visibility = View.GONE
            in_prgress_status.visibility = View.GONE
            rejected_status.visibility = View.GONE
            mark_as_complete_btn.visibility = View.GONE
            completed_lout.visibility = View.VISIBLE

            profile_status_tv.text = "Approved"
            profile_status_tv.setTextColor(this.resources.getColor(R.color.green))
            profile_status_tv.background = this.resources.getDrawable(R.drawable.green_bg_application_status)

            application_status_tv.text = "Completed"
            application_status_tv.setTextColor(this.resources.getColor(R.color.green))
            application_status_tv.background = this.resources.getDrawable(R.drawable.green_bg_application_status)

        }


        mark_as_complete_btn.setOnClickListener {

            val intent: Intent = Intent(this, complete_campaign::class.java)
            startActivity(intent)

        }
    }
}