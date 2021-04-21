package com.kotuz.mesajbulutu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_teknoek.*

class teknoek : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknoek)
        webb.loadUrl("https://teknoek.com/")
    }
}
