package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tarih.*

class tarih : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarih)

        tarihinTanimiButton.setOnClickListener {
            var intent=Intent(this,tarihinTanimi::class.java)
            startActivity(intent)
        }
        ilkcag.setOnClickListener {
            var intent=Intent(this,ilkCagMedeniyeti::class.java)
            startActivity(intent)
        }
        islamTarihiButton.setOnClickListener {
            var intent=Intent(this,islamTarihi::class.java)
            startActivity(intent)
        }
        onYedi.setOnClickListener {
            var intent=Intent(this,onYediOsmanliDevleti::class.java)
            startActivity(intent)
        }

    }
}
