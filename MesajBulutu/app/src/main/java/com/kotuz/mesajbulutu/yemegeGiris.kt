package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_yemege_giris.*

class yemegeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemege_giris)


        yemekDestek.setOnClickListener {

            var intent = Intent(this, ogrenciDestek::class.java)
            startActivity(intent)
        }

        yemekButton.setOnClickListener {

            var intent = Intent(this, yemekler::class.java)
            startActivity(intent)
        }

        tatlıButton.setOnClickListener {
            Toast.makeText(this,"Tatlılar bölümü daha yapım aşamasında, güncellemeleri takip ediniz :)",Toast.LENGTH_SHORT).show()
        }

    }
}
