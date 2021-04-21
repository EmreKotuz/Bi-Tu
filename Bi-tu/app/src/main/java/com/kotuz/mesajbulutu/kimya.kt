package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kimya.*

class kimya : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kimya)


        kimyaButton.setOnClickListener {
            var intent=Intent(this,kimyaBilimineGiris::class.java)
            startActivity(intent)
        }
        kimyaKanun.setOnClickListener {
            var intent=Intent(this,kimyaTemelKanunu::class.java)
            startActivity(intent)
        }
        maddeveozellikButton.setOnClickListener {
            var intent=Intent(this,maddeveozellikler::class.java)
            startActivity(intent)
        }
        molButton.setOnClickListener {
            var intent=Intent(this,molKavrami::class.java)
            startActivity(intent)
        }
        atomButton.setOnClickListener {
            var intent=Intent(this,atomveyapisi::class.java)
            startActivity(intent)
        }
        bilesikButton.setOnClickListener {
            var intent=Intent(this,bilesik::class.java)
            startActivity(intent)
        }
        peryodikButton.setOnClickListener {
            var intent=Intent(this,peryodikTablo::class.java)
            startActivity(intent)
        }
    }
}
