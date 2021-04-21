package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_yemege_giris.*
import kotlinx.android.synthetic.main.activity_yemekler.*

class yemekler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemekler)

        makarnaButton.setOnClickListener {
            var intent = Intent(this, makarnaa::class.java)
            startActivity(intent)
        }
        ezmeSalata.setOnClickListener {
            var intent = Intent(this, com.kotuz.mesajbulutu.ezmeSalata::class.java)
            startActivity(intent)
        }
        pilavButton.setOnClickListener {
            var intent = Intent(this, pilavActivity::class.java)
            startActivity(intent)
        }
        mantıButton.setOnClickListener {
            var intent = Intent(this, mantiActivity::class.java)
            startActivity(intent)
        }
        corba.setOnClickListener {
            var intent = Intent(this, hazircorbaa::class.java)
            startActivity(intent)
        }
        patates.setOnClickListener {
            var intent = Intent(this, com.kotuz.mesajbulutu.patates::class.java)
            startActivity(intent)
        }
    }
}
