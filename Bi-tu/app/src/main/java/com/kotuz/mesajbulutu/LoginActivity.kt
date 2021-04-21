package com.kotuz.mesajbulutu

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_loginden_sonra.*
import kotlinx.android.synthetic.main.activity_mesaj.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        misafir.setOnClickListener {
            var intent = Intent(this,Mesajİki::class.java)
            startActivity(intent)
        }

        tvSifreTekrarYolla.setOnClickListener {
            var dialogSifreyiTekrarGonder=SifremiUnuttumDialogFragment()
            dialogSifreyiTekrarGonder.show(supportFragmentManager,"gosterdialogsifre")
        }


       /* button2.setOnClickListener(object: View.OnClickListener {   //button rengi
            override fun onClick(v: View?) {
              //  button2.text = "Click counter : "
                v?.setBackgroundColor(Color.MAGENTA)
            }
        })*/

        tvKayitOl.setOnClickListener {
            var intent =Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        btnGirisYap.setOnClickListener {

            if (etMail.text.isNotEmpty()&& etSifre.text.isNotEmpty()){
                progressBarGoster()

                FirebaseAuth.getInstance().signInWithEmailAndPassword(etMail.text.toString(),etSifre.text.toString())
                        .addOnCompleteListener(object :OnCompleteListener<AuthResult>{
                            override fun onComplete(p0: Task<AuthResult>) {

                                if (p0.isSuccessful){
                                    progressBarGizle()
                                    Toast.makeText(this@LoginActivity,"Merhaba, hoşgeldin! ",Toast.LENGTH_SHORT).show()
                                    finish()

                                        var kullanici = FirebaseAuth.getInstance().currentUser
                                        if (kullanici != null) {

                                            if (kullanici.displayName.isNullOrEmpty()) {
                                                var inteeent = Intent(applicationContext, HesapAyarlari::class.java)
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                                                startActivity(inteeent)
                                            } else {
                                                kullanici.displayName
                                                var inteent = Intent(applicationContext, Mesaj::class.java)
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                                                startActivity(inteent)
                                            }

                                        }

                                }else{
                                    progressBarGizle()
                                    Toast.makeText(this@LoginActivity,"Hatalı giriş"+p0.exception?.message,Toast.LENGTH_SHORT).show()

                                }

                            }

                        })

            }else{
                Toast.makeText(this,"boş alanları doldurunuz",Toast.LENGTH_SHORT).show()
            }



        }

        }
    private fun progressBarGoster(){
        progrprogressBarLogin.visibility= View.VISIBLE
    }
    private fun progressBarGizle(){
    progrprogressBarLogin.visibility= View.INVISIBLE
}
}

