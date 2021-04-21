package com.kotuz.mesajbulutu

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.TwoStatePreference
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_soru_isareti.*

class soruIsareti : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soru_isareti)


        anaSayfaSoruİşareti.setOnClickListener {
            var intent=Intent(this,Mesaj::class.java)
            startActivity(intent)
        }

    }
}
