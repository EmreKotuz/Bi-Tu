package com.kotuz.mesajbulutu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardedVideoAd

class MainActivity : AppCompatActivity(){

    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reklam)

    }
}
