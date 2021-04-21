package com.kotuz.mesajbulutu


import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_hesap_ayarlari.*
import kotlinx.android.synthetic.main.fragment_hesap_ayarlari_iki.*



class HesapAyarlariİki : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var kullanicii = FirebaseAuth.getInstance().currentUser!!

    }}