package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influencers_app.R
import com.example.influencers_app.adapters.brand_filter_adapter


class brands_filter : AppCompatActivity() , View.OnClickListener {
    lateinit var brands_recv_filter: RecyclerView
    lateinit var A_tv: TextView
    lateinit var B_tv: TextView
    lateinit var C_tv: TextView
    lateinit var D_tv: TextView
    lateinit var E_tv: TextView
    lateinit var F_tv: TextView
    lateinit var G_tv: TextView
    lateinit var H_tv: TextView
    lateinit var I_tv: TextView
    lateinit var J_tv: TextView
    lateinit var K_tv: TextView
    lateinit var L_tv: TextView
    lateinit var M_tv: TextView
    lateinit var N_tv: TextView
    lateinit var O_tv: TextView
    lateinit var P_tv: TextView
    lateinit var Q_tv: TextView
    lateinit var R_tv: TextView
    lateinit var S_tv: TextView
    lateinit var T_tv: TextView
    lateinit var U_tv: TextView
    lateinit var V_tv: TextView
    lateinit var W_tv: TextView
    lateinit var X_tv: TextView
    lateinit var Y_tv: TextView
    lateinit var Z_tv: TextView
    lateinit var brands_name_list_filter:MutableList<String>
    lateinit var letters_lnout:LinearLayout
    lateinit var brands_filter_back_btn:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brands_filter)
        brands_recv_filter = findViewById(R.id.brands_name_recv_filter)

        A_tv = findViewById(R.id.letter_A)
        B_tv = findViewById(R.id.letter_B)
        C_tv = findViewById(R.id.letter_C)
        D_tv = findViewById(R.id.letter_D)
        E_tv = findViewById(R.id.letter_E)
        F_tv = findViewById(R.id.letter_F)
        G_tv = findViewById(R.id.letter_G)
        H_tv = findViewById(R.id.letter_H)
        I_tv = findViewById(R.id.letter_I)
        J_tv = findViewById(R.id.letter_J)
        K_tv = findViewById(R.id.letter_K)
        L_tv = findViewById(R.id.letter_L)
        M_tv = findViewById(R.id.letter_M)
        N_tv = findViewById(R.id.letter_N)
        O_tv = findViewById(R.id.letter_O)
        P_tv = findViewById(R.id.letter_P)
        Q_tv = findViewById(R.id.letter_Q)
        R_tv = findViewById(R.id.letter_R)
        S_tv = findViewById(R.id.letter_S)
        T_tv = findViewById(R.id.letter_T)
        U_tv = findViewById(R.id.letter_U)
        V_tv = findViewById(R.id.letter_V)
        W_tv = findViewById(R.id.letter_W)
        X_tv = findViewById(R.id.letter_X)
        Y_tv = findViewById(R.id.letter_Y)
        Z_tv = findViewById(R.id.letter_Z)


        A_tv.setOnClickListener(this)
        B_tv.setOnClickListener(this)
        C_tv.setOnClickListener(this)
        D_tv.setOnClickListener(this)
        E_tv.setOnClickListener(this)
        F_tv.setOnClickListener(this)
        G_tv.setOnClickListener(this)
        H_tv.setOnClickListener(this)
        I_tv.setOnClickListener(this)
        J_tv.setOnClickListener(this)
        K_tv.setOnClickListener(this)
        L_tv.setOnClickListener(this)
        M_tv.setOnClickListener(this)
        N_tv.setOnClickListener(this)
        O_tv.setOnClickListener(this)
        P_tv.setOnClickListener(this)
        Q_tv.setOnClickListener(this)
        R_tv.setOnClickListener(this)
        S_tv.setOnClickListener(this)
        T_tv.setOnClickListener(this)
        U_tv.setOnClickListener(this)
        V_tv.setOnClickListener(this)
        W_tv.setOnClickListener(this)
        X_tv.setOnClickListener(this)
        Y_tv.setOnClickListener(this)
        Z_tv.setOnClickListener(this)

        letters_lnout =findViewById(R.id.letters_lnout1)
        brands_filter_back_btn = findViewById(R.id.filter_brands_back_btn)

        brands_name_list_filter = mutableListOf()

        brands_name_list_filter.add(0, "AirBnb")
        brands_name_list_filter.add(1,"Ajio")
        brands_name_list_filter.add(2,"Asolo")
        brands_name_list_filter.add(3,"Beyoung")
        brands_name_list_filter.add(4,"Brighton")
        brands_name_list_filter.add(5,"Cole")
        brands_name_list_filter.add(6,"Callaway")
        brands_name_list_filter.add(7,"Colgate")
        brands_name_list_filter.add(8,"Diamont")
        brands_name_list_filter.add(9,"Daniels")
        brands_name_list_filter.add(10,"Deloitte")
        brands_name_list_filter.add(11,"Dell")
        brands_name_list_filter.add(12,"Diageo")
        brands_name_list_filter.add(13,"Element")
        brands_name_list_filter.add(14,"Edge")
        brands_name_list_filter.add(15,"Exame")
        brands_name_list_filter.add(16,"Ericsson")
        brands_name_list_filter.add(17,"Federal")
        brands_name_list_filter.add(18,"Fil")
        brands_name_list_filter.add(19,"Free People")
        brands_name_list_filter.add(20,"Fitbit")
        brands_name_list_filter.add(21, "Garmin")
        brands_name_list_filter.add(22,"Gatorade")
        brands_name_list_filter.add(23,"Guchhi")
        brands_name_list_filter.add(24,"Google")
        brands_name_list_filter.add(25,"Goldman Sachs")
        brands_name_list_filter.add(26,"GenPact")
        brands_name_list_filter.add(27,"GitHub")
        brands_name_list_filter.add(28,"Git")
        brands_name_list_filter.add(29,"GE Power")
        brands_name_list_filter.add(30,"HummingBird")
        brands_name_list_filter.add(31,"Honda Super")
        brands_name_list_filter.add(32,"H&M")
        brands_name_list_filter.add(33,"Hays")
        brands_name_list_filter.add(34,"Huawei")
        brands_name_list_filter.add(35,"Honeywell")
        brands_name_list_filter.add(36,"Iceberg")
        brands_name_list_filter.add(37,"IvyPark")
        brands_name_list_filter.add(38,"Inamorata")
        brands_name_list_filter.add(39,"ISKO")
        brands_name_list_filter.add(40,"Ike Behar")
        brands_name_list_filter.add(41,"Ignik")
        brands_name_list_filter.add(42,"Jet Airways")
        brands_name_list_filter.add(43,"Jetty")
        brands_name_list_filter.add(44,"Jack Rogers")
        brands_name_list_filter.add(45,"Jag")
        brands_name_list_filter.add(46,"Jack Kids")
        brands_name_list_filter.add(47,"kellog")
        brands_name_list_filter.add(48,"KingFisher")
        brands_name_list_filter.add(49,"K Wah")
        brands_name_list_filter.add(50,"Lavie")
        brands_name_list_filter.add(51,"Levesu")
        brands_name_list_filter.add(52,"L.L.Bean.")
        brands_name_list_filter.add(53,"LL Blanca")
        brands_name_list_filter.add(54,"La Perla")
        brands_name_list_filter.add(55,"Microsoft")
        brands_name_list_filter.add(56,"Meta")
        brands_name_list_filter.add(57,"Myntra")
        brands_name_list_filter.add(58,"Moonlight")
        brands_name_list_filter.add(59,"Mystic")
        brands_name_list_filter.add(60,"MyGlamm")
        brands_name_list_filter.add(61,"Nykaa")
        brands_name_list_filter.add(62,"Nitro")
        brands_name_list_filter.add(63,"Netflix")
        brands_name_list_filter.add(64,"Netbeans")
        brands_name_list_filter.add(65,"Nykaa")
        brands_name_list_filter.add(66,"Oppo")
        brands_name_list_filter.add(67,"Off Duty")
        brands_name_list_filter.add(68,"Oberoi")
        brands_name_list_filter.add(69,"Oracle")
        brands_name_list_filter.add(70,"Oil India Ltd")
        brands_name_list_filter.add(71,"Puma")
        brands_name_list_filter.add(72,"PSC")
        brands_name_list_filter.add(73,"Pfizer")
        brands_name_list_filter.add(74,"PwC")
        brands_name_list_filter.add(75,"Philips")
        brands_name_list_filter.add(76,"Q. Q Clothier.")
        brands_name_list_filter.add(77,"Quick iRepair.")
        brands_name_list_filter.add(78,"Quick Mart.")
        brands_name_list_filter.add(79,"Quick Thai.")
        brands_name_list_filter.add(80,"QuickLotz.")
        brands_name_list_filter.add(81,"Reebok")
        brands_name_list_filter.add(82,"Roxy")
        brands_name_list_filter.add(83,"Reformation")
        brands_name_list_filter.add(84,"Stanley")
        brands_name_list_filter.add(85,"Siemens.")
        brands_name_list_filter.add(86,"Swarovski")
        brands_name_list_filter.add(87,"Sanofi.")
        brands_name_list_filter.add(88,"Spotify.")
        brands_name_list_filter.add(89,"Trident Ltd.")
        brands_name_list_filter.add(90,"Trubite")
        brands_name_list_filter.add(91,"Tata Motors Ltd.")
        brands_name_list_filter.add(92,"Umbro")
        brands_name_list_filter.add(93,"UGG")
        brands_name_list_filter.add(94,"Ultracor")
        brands_name_list_filter.add(95,"UltrAspire")
        brands_name_list_filter.add(96,"ULTRA")
        brands_name_list_filter.add(97,"Vaurie")
        brands_name_list_filter.add(98,"Voltas Ltd.")
        brands_name_list_filter.add(99,"Varun Beverages Ltd.")
        brands_name_list_filter.add(100,"Vedanta")
        brands_name_list_filter.add(101,"Walmart")
        brands_name_list_filter.add(102,"WIRED.")
        brands_name_list_filter.add(103,"Wilson")
        brands_name_list_filter.add(104,"XTRA.")
        brands_name_list_filter.add(105,"Xcell Repair")
        brands_name_list_filter.add(106,"XUT Health Cente")
        brands_name_list_filter.add(107,"XXI Forever")
        brands_name_list_filter.add(108,"Xtreme Energy")
        brands_name_list_filter.add(109,"Ypê")
        brands_name_list_filter.add(110,"YASH Technologies")
        brands_name_list_filter.add(111,"Yanbal")
        brands_name_list_filter.add(112,"Yara Internationa")
        brands_name_list_filter.add(113,"Zara")
        brands_name_list_filter.add(114,"Zebra")
        brands_name_list_filter.add(115,"Zoe's Kitchen.")




        val brands_filter_adapter = brand_filter_adapter(brands_name_list_filter)
        brands_recv_filter.layoutManager = GridLayoutManager(this,2)
        brands_recv_filter.adapter = brands_filter_adapter

        brands_filter_back_btn.setOnClickListener {
            finish()
        }

    }
    @SuppressLint("ResourceType")
    override fun onClick(tv: View?) {
        var tvid = tv?.id
        val id = resources.getIdentifier(java.lang.String.valueOf(tvid!!), "id", "com.example.influencers_app")
        var sel_tv:TextView = findViewById<TextView>(id) as TextView
        Toast.makeText(this,sel_tv.text.toString(),Toast.LENGTH_SHORT).show()
        var pos = findID(sel_tv.text.toString())
        (brands_recv_filter.getLayoutManager() as LinearLayoutManager).scrollToPositionWithOffset(pos, 0)

        //setting colour of A to B to black
        for (i in 0 until letters_lnout.getChildCount()) {
            val v: View = letters_lnout.getChildAt(i)
            if (v is TextView) {
                var val_id = v.id
                var view:TextView = findViewById<TextView>(val_id) as TextView
                view.setTextColor(resources.getColor(R.color.Nero))
            }
        }

        //setting the colour of selected leter to Blue
        sel_tv.setTextColor(resources.getColor(R.color.blue))

    }

    private fun changeTextColor(s: String) {

    }

    private fun findID(s: String): Int {
        var index:Int = 0
        for(i in brands_name_list_filter){
            if(i.toLowerCase().startsWith(s.toLowerCase())){
                index = brands_name_list_filter.indexOf(i)
                break
            }
        }
        return index
    }
}