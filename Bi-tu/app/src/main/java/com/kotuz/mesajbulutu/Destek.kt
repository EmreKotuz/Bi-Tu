package com.kotuz.mesajbulutu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_destek.*
import kotlinx.android.synthetic.main.activity_mesaj.*

class Destek : AppCompatActivity() {
//public void
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destek)

    var kullanici= FirebaseAuth.getInstance().currentUser
    if (kullanici !=null)
    {
        tvKullaniciAdiii.text = if (kullanici.displayName.isNullOrEmpty()) "Dostum, destek yerindesiniz " else  kullanici.displayName + ", destek yerindesiniz"
    }
reklamButton.setOnClickListener {
    var tikla =Intent (this,reklamaGiris::class.java)
    startActivity(tikla)
}


        }


}
