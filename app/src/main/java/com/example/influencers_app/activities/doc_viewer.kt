package com.example.influencers_app.activities

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.influencers_app.R
import java.net.URLEncoder

class doc_viewer : AppCompatActivity() {
    lateinit var pbar:ProgressBar
    lateinit var webv:WebView
    val fileurl = "https://www.africau.edu/images/default/sample.pdf"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_viewer)
        webv = findViewById(R.id.web_view)
        webv.setBackgroundColor(Color.TRANSPARENT);
        webv.settings.javaScriptEnabled = true
        webv.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        pbar = findViewById(R.id.simpleProgressBar)
        pbar.setVisibility(View.VISIBLE)

        webv.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pbar.visibility = View.GONE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

        }
        var url = ""
        try {
            url = URLEncoder.encode(fileurl, "UTF-8")
        } catch (ex: Exception) {
        }
        webv.loadUrl("http://docs.google.com/gview?embedded=true&url=$url")

    }
}