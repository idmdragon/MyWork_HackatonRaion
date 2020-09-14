package com.example.mywork.Sign.Seekers.SignIn



import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import com.example.mywork.Beranda.Activity.MainSeekersActivity
import com.example.mywork.Pengaturan.PengaturanActivity
import com.example.mywork.R
import com.example.mywork.Sign.Corporate.SignCorporate
import com.example.mywork.Sign.Seekers.SignUp.SignUpActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignIn : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        auth = FirebaseAuth.getInstance()


        var textEmail = etInputSignInEmail.text!!
        var password = etInputSignInPassword.text!!

        btnSignIn.setOnClickListener {
            Toast.makeText(this,"Proses Autentikasi",Toast.LENGTH_SHORT).show()

            SignInUser(textEmail.toString(),password.toString())


        }

        btn_signUp.setOnClickListener {
            Intent(applicationContext, SignUpActivity::class.java).also {
                startActivity(it)
            }


        }



        btnSignInPerusahaan.setOnClickListener {
            Intent(applicationContext, SignCorporate::class.java).also {
                startActivity(it)
            }
        }









    }
    private fun SignInUser(email: String, password: String,) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Log.d("RegisterUserDebug: ", "User: $password registered")
                   startActivity(Intent(this, MainSeekersActivity::class.java))
                    finishAffinity()
                } else {
                    Log.d("RegisterUserDebug: ", "User: $email failed")
                    Log.d("RegisterUserDebug: ", task.exception.toString())
                    Toast.makeText(this,task.exception.toString(),Toast.LENGTH_SHORT).show()

                }
            }

    }
}
