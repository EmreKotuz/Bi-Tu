package com.kotuz.mesajbulutu
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SifremiUnuttumDialogFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SifremiUnuttumDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SifremiUnuttumDialogFragment : DialogFragment() {

    lateinit var emailEditText: EditText
    lateinit var mContext: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_sifremi_unuttum_dialog, container, false)

        mContext=requireActivity()

        emailEditText=view.findViewById(R.id.etSifreyiTekrarGonder)


        var btnIptal=view.findViewById<Button>(R.id.btnSifreyiUnuttumGonderIptal)
        btnIptal.setOnClickListener {
            dialog.dismiss()
        }
        var btnGonder=view.findViewById<Button>(R.id.btnSifreyiUnuttumGonder)
        btnGonder.setOnClickListener {

            FirebaseAuth.getInstance().sendPasswordResetEmail(emailEditText.text.toString())
                    .addOnCompleteListener {task ->
                        if (task.isSuccessful){
                            Toast.makeText(mContext,"Şifre sıfırlama maili gönderildi",Toast.LENGTH_SHORT).show()
                            dialog.dismiss()
                        }else{
                            Toast.makeText(mContext,"Hata oluştu",Toast.LENGTH_SHORT).show()
                        }
                    }

        }

        return view
    }

    }
