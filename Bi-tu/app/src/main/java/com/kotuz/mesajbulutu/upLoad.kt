package com.kotuz.mesajbulutu

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_up_load.*
import java.lang.Exception
import java.util.jar.Manifest

class upLoad : AppCompatActivity() {

    var sellectedPicture: Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up_load)
    }
    fun imageViewClicked(view: View){
        Toast.makeText(this,"başlıyoruz",Toast.LENGTH_SHORT).show()

        //izin verilmediyse verme kodu
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)

        }else{
            //galeri açma
            val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,2)
        }

    }

//<>
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

    //eger izin verdiyse şunu yap
        if (requestCode==1){
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent,2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 2 && requestCode == Activity.RESULT_OK && data != null){
            sellectedPicture = data.data

            Toast.makeText(this,"giriyor",Toast.LENGTH_SHORT).show()


                try {
                    if (sellectedPicture!=null){
                        Toast.makeText(this,"girdi",Toast.LENGTH_SHORT).show()

                        //android 10'dan sonrası için şunu yap
                if (Build.VERSION.SDK_INT >=28){

                    val source=ImageDecoder.createSource(contentResolver,sellectedPicture!!)
                    val bitmap=ImageDecoder.decodeBitmap(source)
                    uploadimageViewww.setImageBitmap(bitmap)
                    Toast.makeText(this,"olduu",Toast.LENGTH_SHORT).show()


                }else{
                    val bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,sellectedPicture)
                    uploadimageViewww.setImageBitmap((bitmap))
                    Toast.makeText(this,"oldu",Toast.LENGTH_SHORT).show()
                }

            }
                }catch (e:Exception){
                    e.printStackTrace()
            }



        }

        super.onActivityResult(requestCode, resultCode, data)
    }
    fun uploadClicked(view: View){

    }
}
