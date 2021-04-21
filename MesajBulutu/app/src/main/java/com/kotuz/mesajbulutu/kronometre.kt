package com.kotuz.mesajbulutu

import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.ads.*
import com.kotuz.mesajbulutu.kronometre
import kotlinx.android.synthetic.main.activity_kronometre.*

class kronometre : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kronometre)

        var zamaniDurdur:Long=0
        BaslaButtonn.setOnClickListener {
            kronometre.base= SystemClock.elapsedRealtime()+zamaniDurdur
            kronometre.start()
            BaslaButtonn.visibility= View.GONE
            DurdurButtonn.visibility= View.VISIBLE
            sifirlaButtonn.visibility= View.VISIBLE
        }
        DurdurButtonn.setOnClickListener {
            zamaniDurdur = kronometre.base- SystemClock.elapsedRealtime()
            kronometre.stop()
            BaslaButtonn.visibility= View.VISIBLE
            DurdurButtonn.visibility= View.GONE
            sifirlaButtonn.visibility= View.VISIBLE
        }
        sifirlaButtonn.setOnClickListener {
            zamaniDurdur=0
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.stop()
            BaslaButtonn.visibility= View.VISIBLE
            DurdurButtonn.visibility= View.GONE
            sifirlaButtonn.visibility= View.VISIBLE
            // DurdurButtonn.imageView.setImageDrawable(getDrawable(R.drawable.durdurbutton))

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
            }

            override fun onAdFailedToLoad(errorCode: Int) {
            }

            override fun onAdOpened() {
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
