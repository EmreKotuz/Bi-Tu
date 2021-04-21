package com.kotuz.mesajbulutu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_telegram_giris.*

class telegramGiris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telegram_giris)


        whatsappCode.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }
        whatsappCode2.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }
    }
}
