package com.kotuz.mesajbulutu

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_animasyon.*

class animasyon : AppCompatActivity() {
//var emre =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animasyon)

        //val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
       // val yazi = findViewById(R.id.yazi) as TextView
        //val subtitlee = findViewById(R.id.yazi) as TextView


        val stt = AnimationUtils.loadAnimation(this, R.anim.animation)

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        val subtitle = findViewById(R.id.image) as ImageView
        image.startAnimation(animation)
        subtitle.startAnimation(stt)

       // yazi . startAnimation (ttb)
      //  subtitlee.startAnimation(ttb)


        object : CountDownTimer(3000, 3000) {
            override fun onFinish() {

                var intent = Intent(applicationContext, Mesaj::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)

            }
            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }   }




