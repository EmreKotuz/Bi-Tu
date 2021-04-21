package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_derse_giris.*
import kotlinx.android.synthetic.main.activity_ingilizce_giris.*

class ingilizceGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingilizce_giris)

        günlükKonuşmaCümleleri.setOnClickListener {
            var intent =Intent(this,gunlukKonusma::class.java)
            startActivity(intent)
        }
        tanışma.setOnClickListener {
            var intent = Intent(this,Tanisma::class.java)
            startActivity(intent)
        }
        emirButton.setOnClickListener {
            var intent = Intent(this,emirCumleleri::class.java)
            startActivity(intent)
        }

    }
}
