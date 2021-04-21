package com.kotuz.mesajbulutu

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_mesaj.*
import java.util.*

class Mesaj : AppCompatActivity() {
    lateinit var myAuthStateListener: FirebaseAuth.AuthStateListener
    val randommm = arrayListOf("Çok istediğiniz bir hedef belirleyin. Sabahları yataktan fırlayarak kalkmanızı sağlayacak kadar çok istediğiniz …", "Binlerce kilometrelik bir yolculuk bile, tek bir adımla başlar. [Lao – Tzu]", "Her gece veya problem güneşin doğuşuna ve umuda yenilmeye mahkumdur. [Bernard Williams]"

            , "Büyük hayaller kurmak iyidir. Fakat uykunuz da büyükse hayalleriniz asla gün ışığı görmeyecektir. Günaydın …", "Hayat bisiklete binmek gibidir. Pedalı çevirmeye devam ettiğiniz sürece düşmezsiniz. [Claude Pepper]"
    ,"“Yaptığım her şeyde bana rehberlik eden arzu, doğanın güçlerini insanlığın hizmetine koşturma arzusudur.   Nikola Tesla"
    ,"“Bilginin efendisi olmak için çalışmanın uşağı olmak şarttır.   Balzac"
    ,"“Bir insanı, bulunduğu mevki ile değil, göz koyduğu mevkiyle değerlendirmek gerekir.”   Tolstoy"
    ,"“Siz kendinize inanın, başkaları da size inanacaktır.”   Johann Wolfgang von Goethe"
    ,"“Yaratıcılığın önemli bir unsuru, başarısız olmaktan korkmamaktır.”    Edwin Land"
    ,"“Ders alınmış başarısızlık, aslında bir başarıdır.”   Malcolm S. Forbes"
    ,"“Eğer yürüdüğünüz yolda güçlük ve engel yoksa, bilin ki o yol sizi bir yere ulaştırmaz.”   Bernard Shaw"
    ,"“Her gün tutarlılık ile tekrarlanan küçük disiplinler, zaman içinde yavaş yavaş kazanılan büyük başarılara yol açar.”    John C. Maxwell")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesaj)
        initAuthStateListener()
        setKullaniciBilgileri()
        myAuthStateListener
    }
    private fun setKullaniciBilgileri() {

        var kullanici = FirebaseAuth.getInstance().currentUser
        if (kullanici != null) {
            tvKullaniciAdi.text = if (kullanici.displayName.isNullOrEmpty()) {
                tvKullaniciAdi.setOnClickListener {
                    var intent = Intent(this, HesapAyarlari::class.java)
                    startActivity(intent)
                }
                tvKullaniciAdi.setTextColor(Color.RED)
                "İsmini oluşturmak için tıkla"
            } else
            "Merhaba, " + kullanici.displayName + "." + " Bugün ne yapıyoruz?"
            //  tvKullaniciEmail.text=kullanici.email
ingilizceyeGiris.setOnClickListener {
    var intent = Intent(this,ingilizceGiris::class.java)
    startActivity(intent)
}

        }
        button6.setOnClickListener {
            var intent = Intent(this, ayarlar::class.java)
            startActivity(intent)
        }
        dersButton.setOnClickListener {
            var intent=Intent(this,derseGiris::class.java)
            startActivity(intent)
        }


        val random = Random()
        val randomProgram = random.nextInt(randommm.count())
            textView8.text = randommm[randomProgram]


        Beyin.setOnClickListener {
            var intent = Intent(this,beyin::class.java)
            startActivity(intent)
        }
        kronooo.setOnClickListener {
            var intent = Intent(this,kronometre::class.java)
            startActivity(intent)
        }
        tekno.setOnClickListener {
            var intent = Intent(this,teknoek::class.java)
            startActivity(intent)
        }
        yemekButton.setOnClickListener {
            var intent =Intent(applicationContext,yemekler::class.java)
            startActivity(intent)
        }
        eğzersiz.setOnClickListener {
            var intent = Intent (this,egzersizeGiris::class.java)
            startActivity(intent)
        }
    }



    private fun initAuthStateListener() {
        myAuthStateListener = object : FirebaseAuth.AuthStateListener {
            override fun onAuthStateChanged(p0: FirebaseAuth) {
                var kullanici = p0.currentUser

                if (kullanici != null) {

                } else {
                    var intent = Intent(this@Mesaj, LoginActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                    startActivity(intent)
                    finish()
                }
            }


        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.anamenu, menu)
        menuInflater.inflate(R.menu.hesapayarlari,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.menuHesapAyarlari ->{
                var intent = Intent(this,HesapAyarlari::class.java)
                startActivity(intent)
            }
        }
            when(item?.itemId){
            R.id.menuCikisyap ->{
                cikisYap()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

        private fun cikisYap() {
            var intent = Intent(this@Mesaj, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
            startActivity(intent)
            finish()
            FirebaseAuth.getInstance().signOut()
        }


        override fun onResume() {
            super.onResume()
            kullaniciyiKontrolEt()
            setKullaniciBilgileri()
        }

        private fun kullaniciyiKontrolEt() {
            var kullanici = FirebaseAuth.getInstance().currentUser

            if (kullanici == null) {
                var intent = Intent(this@Mesaj, LoginActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                startActivity(intent)
                finish()
            }
        }


        override fun onStart() {
            super.onStart()
            FirebaseAuth.getInstance().addAuthStateListener { myAuthStateListener }
        }

        override fun onStop() {
            super.onStop()
            if (myAuthStateListener != null) {
                FirebaseAuth.getInstance().removeAuthStateListener { myAuthStateListener }
            }

            }
        }


