package com.kotuz.mesajbulutu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fizige_giris.*

class fizigeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fizige_giris)

        dogasiButton.setOnClickListener {
            var intent=Intent(this,fiziginDogasi::class.java)
            startActivity(intent)
        }
        maddeButton.setOnClickListener {
            var intent=Intent(this,maddeveOzellikleri::class.java)
            startActivity(intent)
        }
        dogrusalButton.setOnClickListener {
            var intent=Intent(this,dogrusalHareket::class.java)
            startActivity(intent)
        }
        isguc.setOnClickListener {
            var intent=Intent(this,isgucenerji::class.java)
            startActivity(intent)
        }
        isiSicaklikButton.setOnClickListener {
            var intent=Intent(this,isiSicaklik::class.java)
            startActivity(intent)
        }
        basinc.setOnClickListener {
            var intent=Intent(this,com.kotuz.mesajbulutu.basinc::class.java)
            startActivity(intent)
        }
        golgeButon.setOnClickListener {
            var intent=Intent(this,golge::class.java)
            startActivity(intent)
        }
        miklantisButton.setOnClickListener {
            var intent=Intent(this,miklantis::class.java)
            startActivity(intent)
        }
    }
}
