package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mesaj_iki.*

class Mesajİki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesaj_iki)


        kaydolma.setOnClickListener {
            var intent = Intent (this,RegisterActivity::class.java)
            startActivity(intent)
        }


        ders.setOnClickListener {
            var inten = Intent(this,derseGiris::class.java)
            startActivity(inten)
        }
        tarif.setOnClickListener {
            var inten = Intent(this,yemegeGiris::class.java)
            startActivity(inten)
        }
        spor.setOnClickListener {
            var inten = Intent(this,egzersizeGiris::class.java)
            startActivity(inten)
        }
        en.setOnClickListener {
            var inten = Intent(this,ingilizceGiris::class.java)
            startActivity(inten)
        }
        kısaNotlar.setOnClickListener {
            var inten = Intent(this,beyin::class.java)
            startActivity(inten)
        }


    }
}
