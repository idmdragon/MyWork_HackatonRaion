package com.example.mywork.Sign.Seekers



import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.mywork.R
import com.example.mywork.Sign.Corporate.SignCorporate
import com.example.mywork.Sign.Seekers.SignUp.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignIn : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

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
}