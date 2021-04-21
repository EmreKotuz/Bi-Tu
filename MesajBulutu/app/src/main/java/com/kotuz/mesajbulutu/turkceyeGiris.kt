package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_turkceye_giris.*

class turkceyeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turkceye_giris)

        anlatimBozukluguButton.setOnClickListener {
            var intent= Intent(this,anlatimBozuklugu::class.java)
            startActivity(intent)
        }
        cumledeAnlamButton.setOnClickListener {
            var intent= Intent(this,cumledeAnlam::class.java)
            startActivity(intent)
        }
        cumleninOgeleriButton.setOnClickListener {
            var intent= Intent(this,cumleninOgeleri::class.java)
            startActivity(intent)
        }
        fiilButton.setOnClickListener {
            var intent= Intent(this,fiildeCati::class.java)
            startActivity(intent)
        }
        noktalamaIsaretiButton.setOnClickListener {
            var intent= Intent(this,noktalamaIsareti::class.java)
            startActivity(intent)
        }
        paragrafButton.setOnClickListener {
            var intent= Intent(this,paragraf::class.java)
            startActivity(intent)
        }
        sozcukteAnlamButton.setOnClickListener {
            var intent= Intent(this,sozcukteAnlam::class.java)
            startActivity(intent)
        }
        yapiBilgisiButton.setOnClickListener {
            var intent= Intent(this,yapiBilgisi::class.java)
            startActivity(intent)
        }
        yazimKuraliButton.setOnClickListener {
            var intent= Intent(this,yazimKurallari::class.java)
            startActivity(intent)
        }
    }
}
