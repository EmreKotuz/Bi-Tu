package com.kotuz.mesajbulutu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_mesaj.*
import kotlinx.android.synthetic.main.activity_telegram_giris.*

class ayarlar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayarlar)
        telegram.setOnClickListener {
            var intnent=Intent(this,telegramGiris::class.java)
            startActivity(intnent)


        }
        öğrenci.setOnClickListener {
            var intnent=Intent(this,ogrenciDestek::class.java)
            startActivity(intnent)
        }
        buttonÇikiş.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
            startActivity(intent)
            finish()
            FirebaseAuth.getInstance().signOut()
        }
        kullaniciAdiniGüncelle.setOnClickListener {
            intent = Intent(this, HesapAyarlari::class.java)
            startActivity(intent)
        }
        kaynakButton.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.derscalisiyorum.com.tr")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }
}}