package com.kotuz.mesajbulutu

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ogrenci_destek.*

class ogrenciDestek : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ogrenci_destek)


        onaylama.setOnClickListener{
            if (onaylama.isChecked){
                gönder.setBackgroundResource(R.mipmap.g)
                gönder.setOnClickListener {
                    //get input from EditTexts and save in variables
                    val recipient = recipientEt.text.toString().trim()
                    val subject = subjectEt.text.toString().trim()
                    val message = messageEt.text.toString().trim()
                    Toast.makeText(this,"Dostum, iletini GMAİL yolu ile bize göndermen lazım...",Toast.LENGTH_SHORT).show()

                    //method call for email intent with these inputs as parameters
                    sendEmail(recipient, subject, message)
                }
            }else{

                gönder.setBackgroundResource(R.mipmap.gg)
                gönder.setOnClickListener {
                    Toast.makeText(this,"Şartı kabul etmen lazım...",Toast.LENGTH_SHORT).show()
                }
            }
        }
gönder.setOnClickListener {
    Toast.makeText(this,"Şartı kabul etmen lazım...",Toast.LENGTH_SHORT).show()

}
        //button click to get input and call sendEmail method

    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)


        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))

        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()

        }

    }
    private fun buttonuGoster(){				//herhangi bi nesneyi gizleyip göstermesini sağlıyor (visibility=invisible olacaktır..)
        gönder.visibility= View.VISIBLE
    }
    private fun buttonuGosterme() {
        gönder.visibility = View.INVISIBLE
    }

}
