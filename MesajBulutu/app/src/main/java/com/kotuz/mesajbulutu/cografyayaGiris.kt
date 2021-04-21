package com.kotuz.mesajbulutu

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_cografyaya_giris.*
import kotlinx.android.synthetic.main.activity_derse_giris.*
import kotlinx.android.synthetic.main.activity_rasyonel_sayi.*

class cografyayaGiris : AppCompatActivity() {
    private var mAdView: AdView? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cografyaya_giris)


        destekTemel8.setOnClickListener {
            var intent= Intent(this,DestekOl::class.java)
            startActivity(intent)
        }
        cografyaModu.setOnClickListener {
            if (cografyaModu.isChecked) {

                cografyaEkran.setBackgroundColor(Color.parseColor("#E6D973"))
                cografyaModu.text="Gece modunu kapatmak için tıkla"



            } else {
                cografyaEkran.setBackgroundColor(Color.WHITE)
                cografyaModu.text="Gece Modu"

            }
        }
        MobileAds.initialize(this, "\n" + "ca-app-pub-6537190103014639~2649982050")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)


        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/5237628702"

        mAdView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }
}
