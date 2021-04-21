package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_biyolojiye_giris.*

class biyolojiyeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biyolojiye_giris)

        biyolojiwebButton.setOnClickListener {
            var intent = Intent(this,biyolojiWeb::class.java)
            startActivity(intent)
        }
        anaSayfa.setOnClickListener {
            var intent = Intent(this,Mesaj::class.java)
            startActivity(intent)
        }
    }
}
