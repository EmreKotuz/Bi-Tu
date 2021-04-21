package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_derse_giris.*
import kotlinx.android.synthetic.main.activity_dua.*
import kotlinx.android.synthetic.main.activity_dua.view.*

class dua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)
        duaGiris.setOnClickListener {

            var kullanici = FirebaseAuth.getInstance().currentUser
            if (kullanici != null) {

                if (kullanici.displayName.isNullOrEmpty()){
                    var inteeent = Intent(this, HesapAyarlari::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                    startActivity(inteeent)}

                else {
                    kullanici.displayName
                    var inteent = Intent(this, Mesaj::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                    startActivity(inteent)
                }

        }




        }
    }
}
