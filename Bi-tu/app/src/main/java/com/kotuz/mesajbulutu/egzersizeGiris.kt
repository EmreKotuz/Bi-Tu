package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_derse_giris.*
import kotlinx.android.synthetic.main.activity_egzersize_giris.*

class egzersizeGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egzersize_giris)
        var kullanici = FirebaseAuth.getInstance().currentUser
        if (kullanici != null) {
            egzersizText.text = if (kullanici.displayName.isNullOrEmpty())" UYARI: Dostum kendine ağır gelecek setleri deneme!" else kullanici.displayName + "," + " sakın kendine ağır gelecek setleri deneme!"

        }
        şınav.setOnClickListener {
            var intent =Intent (this,SinavaGiris::class.java)
            startActivity(intent)
        }
        squat.setOnClickListener {
            var intent = Intent (this,squatGiris::class.java)
            startActivity(intent)
        }
        lunge.setOnClickListener {
            var intent = Intent (this,lungeGiris::class.java)
            startActivity(intent)
        }
        mekik.setOnClickListener {
            var intent =Intent(this,mekikeGiris::class.java)
            startActivity(intent)
        }
        yürüyüş.setOnClickListener {
            var intent = Intent (this,yuruyuseGiris::class.java)
            startActivity(intent)
        }
        bisiklet.setOnClickListener {
            var intent = Intent(this,bisikleteGiris::class.java)
            startActivity(intent)
        }
    }
}
