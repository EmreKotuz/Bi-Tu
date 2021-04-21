package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cografya.*

class cografya : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cografya)
        harita.setOnClickListener {
            var intent=Intent(this,cografyayaGiris::class.java)
            startActivity(intent)
        }
        dogalAfet.setOnClickListener {
            var intent = Intent(this, dogalAfetler::class.java)
            startActivity(intent)
        }
        dunyanınSekli.setOnClickListener {
            var intent = Intent(this, dunyaninSekli::class.java)
            startActivity(intent)
        }
        cevree.setOnClickListener {
            var intent = Intent(this, cografyacevre::class.java)
            startActivity(intent)
    }
        icc.setOnClickListener {
            var intent = Intent(this, cografyaicVeDisKuvvetler::class.java)
            startActivity(intent)
                }
        iklim.setOnClickListener {
            var intent = Intent(this, cografyaiklimBilgi::class.java)
            startActivity(intent)
        }
        nufus.setOnClickListener {
            var intent = Intent(this,cografyaNufus::class.java)
            startActivity(intent)
        }
        toprakTipleri.setOnClickListener {
            var intent = Intent(this,cografyaToprakTipleri::class.java)
            startActivity(intent)
                }
        ulasim.setOnClickListener {
            var intent = Intent(this,ulasimYollari::class.java)
            startActivity(intent)
        }
    }
}
