package com.kotuz.mesajbulutu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import com.google.android.gms.ads.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_beyin.*
import kotlinx.android.synthetic.main.activity_destek.*
import kotlinx.android.synthetic.main.activity_mesaj.*
import java.io.RandomAccessFile
import java.util.*
import kotlin.collections.RandomAccess


val randommmm= arrayListOf(R.mipmap.atomyapi,R.mipmap.enzimfak,R.mipmap.eseyliureme,
        R.mipmap.fdoga,R.mipmap.haldegisim,R.mipmap.hucree,R.mipmap.kuralli,R.mipmap.nedensonuc
        , R.mipmap.olcuu,R.mipmap.ozelmat,R.mipmap.ozisii,R.mipmap.oznelnesnel,R.mipmap.prook,
        R.mipmap.ruhsalfiziksel,R.mipmap.sivibuhar,R.mipmap.skalerr,R.mipmap.ulama, R.mipmap.d,
        R.mipmap.eko,R.mipmap.en,R.mipmap.ki,R.mipmap.madde,R.mipmap.tek,R.mipmap.ii,R.mipmap.vi,
        R.mipmap.soy,R.mipmap.gli,R.mipmap.esey,R.mipmap.nit,R.mipmap.isi,R.mipmap.ska,R.mipmap.uu,
        R.mipmap.uuu,R.mipmap.uuuu,R.mipmap.uuuuu,R.mipmap.uuuuuu,R.mipmap.uuuuuuu,R.mipmap.uuuuuuuu,
        R.mipmap.uuuuuuuuu,R.mipmap.uuuuuuuuuu,R.mipmap.uuuuuuuuuuu,R.mipmap.uuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuu,
        R.mipmap.uuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuuuu,
        R.mipmap.uuuuuuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuuuuuuu,R.mipmap.uuuuuuuuuuuuuuuuuuuuu,
        R.mipmap.uuuuuuuuuuuuuuuuuuuuuuu,R.mipmap.atmo,R.mipmap.buyharoz,R.mipmap.dalol
        ,R.mipmap.dunyas,R.mipmap.dunyason,R.mipmap.dunyasong
        ,R.mipmap.ekfa,R.mipmap.erz,R.mipmap.harc,R.mipmap.icg
        ,R.mipmap.izo,R.mipmap.meridyen,R.mipmap.meridyenoz
        ,R.mipmap.orm,R.mipmap.par,R.mipmap.paroz,R.mipmap.per
        ,R.mipmap.renk,R.mipmap.volk,R.mipmap.yagis,R.mipmap.yasd,R.mipmap.yerkure
        ,R.mipmap.ayirt,R.mipmap.elekt,R.mipmap.element,R.mipmap.ga,R.mipmap.gaz,R.mipmap.gazbas
        ,R.mipmap.gy,R.mipmap.iyo,R.mipmap.kaba,R.mipmap.ktk,R.mipmap.molk,R.mipmap.maddd
        ,R.mipmap.ozkutleei,R.mipmap.pg,R.mipmap.sim,R.mipmap.enkayy,R.mipmap.izoproc,R.mipmap.kromyat
        ,R.mipmap.merboyy,R.mipmap.mevic,R.mipmap.nuart,R.mipmap.ozkonumm,R.mipmap.taryon,R.mipmap.tutuet,R.mipmap.ulyolll,R.mipmap.yilhar
        ,R.mipmap.yurtgoc)


class beyin : AppCompatActivity() {
    private var mAdView: AdView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beyin)

        button.setOnClickListener{
        val random = Random()
        val button = random.nextInt(randommmm.count())
        imageee.setImageResource(randommmm[button])

    }
        val random = Random()
        val button = random.nextInt(randommmm.count())
        imageee.setImageResource  (randommmm[button])





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
