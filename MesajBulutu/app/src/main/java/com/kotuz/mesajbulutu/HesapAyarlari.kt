package com.kotuz.mesajbulutu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_hesap_ayarlari.*
import kotlinx.android.synthetic.main.activity_loginden_sonra.*
import kotlinx.android.synthetic.main.fragment_hesap_ayarlari_iki.*

class HesapAyarlari : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hesap_ayarlari)


        var kullanici = FirebaseAuth.getInstance().currentUser!!
        etDetayName.setText(kullanici.displayName.toString())


        değişiklikleriKaydetBaba.setOnClickListener {

            Toast.makeText(applicationContext, "Lütfen bekleyiniz..", Toast.LENGTH_SHORT).show()  //this olmazsa applicationContext olacak..
            if (etDetayName.text.toString().isNotEmpty() && etDetayName.text.toString().isNotEmpty()) {
                if (!etDetayName.text.toString().equals(kullanici.displayName.toString())) {

                    var bilgileriGuncelle = UserProfileChangeRequest.Builder()
                            .setDisplayName(etDetayName.text.toString())
                            .build()
                    kullanici.updateProfile(bilgileriGuncelle)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(this, "Degişiklikler yapıldı", Toast.LENGTH_SHORT).show()
                                    var intent = Intent(this, Mesaj::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(this, "Değişikler yapılamadı", Toast.LENGTH_SHORT).show()
                                }
                                anaSayfayaDön.setOnClickListener {
                                    intent = Intent(this, Mesaj::class.java)
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                                    startActivity(intent)
                                }
                            }

                }
            }

        }





}
}