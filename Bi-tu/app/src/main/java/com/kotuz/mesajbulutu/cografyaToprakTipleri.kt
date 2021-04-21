package com.kotuz.mesajbulutu

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_cografya_nufus.*
import kotlinx.android.synthetic.main.activity_cografya_toprak_tipleri.*

class cografyaToprakTipleri : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cografya_toprak_tipleri)
        toprakGeceModu.setOnClickListener {
            if (toprakGeceModu.isChecked) {
                ekranToprak.setBackgroundColor(Color.parseColor("#FFD4C954"))
                toprakGeceModu.text = "Gece modunu kapatmak için tıkla"
            } else {
                ekranToprak.setBackgroundColor(Color.WHITE)
                toprakGeceModu.text = "Gece Modu"
            }
    }
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

