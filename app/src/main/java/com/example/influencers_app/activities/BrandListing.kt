package com.example.influencers_app.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brands_list_adapter
import com.example.influencers_app.models.brands_listing_data

class BrandListing : AppCompatActivity() {
    lateinit var top_brands_recv: RecyclerView
    lateinit var back_btn:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand_listing)
        top_brands_recv = findViewById(R.id.brands_list_recv)
        back_btn = findViewById(R.id.top_brands_back_btn)

        val top_brands_list = mutableListOf<brands_listing_data>()
        top_brands_list.add(0, brands_listing_data(R.drawable.air_bnb,"Airbnb",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(1, brands_listing_data(R.drawable.wendys,"Wendy's",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(2, brands_listing_data(R.drawable.michael_kors,"Michael Kors",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(3, brands_listing_data(R.drawable.the_ordinary,"The Ordinary",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(4, brands_listing_data(R.drawable.esbeda,"ESBEDA",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(5, brands_listing_data(R.drawable.pizza_logo,"Pizza Express",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(6, brands_listing_data(R.drawable.handm,"H & M",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(7, brands_listing_data(R.drawable.peng_books,"Penguin Books",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))
        top_brands_list.add(8, brands_listing_data(R.drawable.reebok,"Reebok",3,"Lorem ipsum dolor sit amet consectetur. At bibendum lorem rutrum facilisis enim elementum et. Placerat diam nec vitae aliquet aliquet tellus adipiscing lobortis dignissim. Ut lorem faucibus enim laoreet felis. Cursus etiam malesuada tristique duis vitae amet justo morbi. Sed nunc ac at hendrerit. Vulputate sit ut gravida cras sed. Faucibus facilisis ut nibh gravida. Id urna in placerat accumsan massa imperdiet nec lacus. Neque cras morbi tempus est condimentum enim fringilla. Lorem sit nulla at turpis congue tortor."))

        val top_brands_adapter = brands_list_adapter(top_brands_list)
        val top_brands_lout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        top_brands_recv.layoutManager = top_brands_lout
        top_brands_recv.adapter = top_brands_adapter

        back_btn.setOnClickListener {
            finish()
        }

    }
}