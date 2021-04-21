package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_biyoloji_web.*

class biyolojiWeb : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biyoloji_web)


        webView.loadUrl("https://www.derscalisiyorum.com.tr/tyt/tyt-biyoloji-konu-anlatimi.html")


        derslerButon.setOnClickListener {
            var intent=Intent(this,derseGiris::class.java)
            startActivity(intent)
        }
        anaSayfayaDon.setOnClickListener {
            var intent=Intent(this,Mesaj::class.java)
            startActivity(intent)
        }
    }
}
