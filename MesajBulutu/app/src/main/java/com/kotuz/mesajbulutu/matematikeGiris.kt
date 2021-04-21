package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_matematike_giris.*

class matematikeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matematike_giris)

        temelKavramButton.setOnClickListener {
            var intent=Intent(this,temelKavramlar::class.java)
            startActivity(intent)
        }
        basitButton.setOnClickListener {
            var intent=Intent(this,basitEsitsizlik::class.java)
            startActivity(intent)
        }
        rasyonel.setOnClickListener {
            var intent=Intent(this,rasyonelSayi::class.java)
            startActivity(intent)
        }
        koklu.setOnClickListener {
            var intent=Intent(this,kokluSayi::class.java)
            startActivity(intent)
        }
        mutlak.setOnClickListener {
            var intent=Intent(this,mutlakDeger::class.java)
            startActivity(intent)
        }
        oranButton.setOnClickListener {
            var intent=Intent(this,oranOranti::class.java)
            startActivity(intent)
        }
        bolme.setOnClickListener {
            var intent=Intent(this,bolmeBolunebilme::class.java)
            startActivity(intent)
        }
    }
}
