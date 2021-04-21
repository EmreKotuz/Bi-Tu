package com.kotuz.mesajbulutu

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        girisYap.setOnClickListener {
            var intent = Intent (this,LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
            startActivity(intent)
        }

        btnKayitOl.setOnClickListener{

            if (etMail.text.isNotEmpty() && etSifre.text.isNotEmpty() && etSifreTekrar.text.isNotEmpty()){


                if (etSifre.text.toString().equals(etSifreTekrar.text.toString())) {

                    yeniUyeKayit(etMail.text.toString(), etSifre.text.toString())


                }else{
                    Toast.makeText(this,"Şifreler aynı değil", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this,"Boş alanları doldurunuz", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun yeniUyeKayit(mail: String, sifre: String) {

        progressBarGoster()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,sifre)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                    override fun onComplete(p0: Task<AuthResult>) {

                        if(p0.isSuccessful){
                            progressBarGizle()
                            Toast.makeText(this@RegisterActivity,"KAYIT BAŞARILI", Toast.LENGTH_SHORT).show()
                            var intent = Intent(applicationContext,LoginActivity::class.java)       // this olmazsa -> applicationContext kullanabilirsin..
                            startActivity(intent)
                            Toast.makeText(this@RegisterActivity,"Artık sınav bizden korksun!",Toast.LENGTH_SHORT).show()
                        }else{
                            progressBarGizle()
                            Toast.makeText(this@RegisterActivity,"Üye kaydedilirken sorun oluştu..:"+p0.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                })
    }
    private fun progressBarGoster(){
        progressBar.visibility=View.VISIBLE
    }
    private fun progressBarGizle(){
        progressBar.visibility=View.INVISIBLE
    }

}
