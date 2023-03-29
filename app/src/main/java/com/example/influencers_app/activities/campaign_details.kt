package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.ViewPager
import com.example.influencers_app.R
import com.example.influencers_app.utils.pageAdapter
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout


class campaign_details : AppCompatActivity() {
    lateinit var tablout:TabLayout
    lateinit var details_tab: TabItem
    lateinit var deliverables_tab: TabItem
    lateinit var criteria_tab: TabItem
    lateinit var dos_dont_tab: TabItem
    lateinit var references_tab: TabItem
    lateinit var viewpager: ViewPager
    lateinit var back_btn:LinearLayout
    lateinit var participation_btn: LinearLayout
    lateinit var successDialog: AlertDialog
    lateinit var share_btn: LinearLayout
    lateinit var participate_now_text: TextView

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign_details)
        tablout = findViewById(R.id.tablout1)
        participation_btn = findViewById(R.id.participate_now_btn_details_frag)
        participate_now_text = findViewById(R.id.lnout_btn_text)
//        details_tab = findViewById<TabItem>(R.id.detail_tab)
//        criteria_tab = findViewById(R.id.influencer_criteria_tab)
//        deliverables_tab = findViewById(R.id.deliverables_tab)
//        dos_dont_tab = findViewById(R.id.dos_donts_tab)
//        references_tab = findViewById(R.id.references_tab)
        viewpager = findViewById(R.id.viewpager1)
        back_btn = findViewById(R.id.back_btn_campg_details)
        share_btn = findViewById(R.id.share_btn_campg_details)

        back_btn.setOnClickListener {
            finish()
        }

        share_btn.setOnClickListener{
            val sharingIntent: Intent = Intent(Intent.ACTION_SEND)
            sharingIntent.setType("text/plain")
            val shareBody = "Here are campaign Details"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        var pageadapter = pageAdapter(supportFragmentManager,tablout.tabCount)
        viewpager.adapter = pageadapter

        tablout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager.currentItem = tab.position
                if(tab.position == 0 || tab.position == 1 || tab.position == 2|| tab.position == 3 || tab.position == 4){
                    pageadapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab){
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }


        })

        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablout))


        participation_btn.setOnClickListener {
            participation_btn.background = resources.getDrawable(R.drawable.button_bg_gray)
            participate_now_text.text = "Already Applied"
            participation_btn.isClickable = false
            val builder = AlertDialog.Builder(this)
            val inflater:LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.applied_successfully_dialog,null)
            builder.setView(view)
            successDialog = builder.create()
            successDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            successDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val cancel_btn = view.findViewById<ImageView>(R.id.cancel_btn_applied_successfully_dialog)
            val my_app_btn = view.findViewById<Button>(R.id.my_applications_application_successfull_dialog)
            val keep_applying = view.findViewById<AppCompatButton>(R.id.keep_applying_application_successfull_dialog)

            cancel_btn.setOnClickListener{
                successDialog.dismiss()
            }

            my_app_btn.setOnClickListener {
                val intent:Intent = Intent(this,my_applications::class.java)
                startActivity(intent)
                successDialog.dismiss()
            }

            keep_applying.setOnClickListener {
                val intent:Intent = Intent(this,all_campaign_list::class.java)
                startActivity(intent)
                successDialog.dismiss()
            }

            successDialog.show()
        }

    }
}