package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_derse_giris.*

class derseGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_derse_giris)
        cografya.setOnClickListener {
            var intent=Intent(this,com.kotuz.mesajbulutu.cografya::class.java)
            startActivity(intent)
        }

        kullanicii.setOnClickListener {
            var intent= Intent(this,ogrenciDestek::class.java)
            startActivity(intent)
        }
        kimya.setOnClickListener {
            var intent= Intent(this,com.kotuz.mesajbulutu.kimya::class.java)
            startActivity(intent)
        }

matematik.setOnClickListener {
    var intent=Intent(this,matematikeGiris::class.java)
    startActivity(intent)
}
        var kullanici = FirebaseAuth.getInstance().currentUser
        if (kullanici != null) {
            kullanicii.text =
                    if (kullanici.displayName.isNullOrEmpty())"Eksik veya hatalarımızı bize söyleyin :)"
            else
                kullanici.displayName + "," + " eksik veya hatalarımızı bize çekinmeden söyle :)"


        }
        telegrammmmm.setOnClickListener {
            var intent=Intent(this,telegramGiris::class.java)
            startActivity(intent)
        }
        fizikButtonn.setOnClickListener {
            var intent=Intent(this,fizigeGiris::class.java)
            startActivity(intent)
        }
        biyolojiButton.setOnClickListener {
            var intent=Intent(this,biyolojiyeGiris::class.java)
            startActivity(intent)
        }
        turkceButton.setOnClickListener {
            var intent=Intent(this,turkceyeGiris::class.java)
            startActivity(intent)
        }
        tarihButton.setOnClickListener{
            var intent= Intent(this,tarih::class.java)
            startActivity(intent)
        }
    }
}
