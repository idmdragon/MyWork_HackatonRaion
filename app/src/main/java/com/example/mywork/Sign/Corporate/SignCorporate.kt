package com.example.mywork.Sign.Corporate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SignIn.SignIn
import kotlinx.android.synthetic.main.activity_sign_corporate.*

class SignCorporate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_corporate)

        btn_signUp_perusahaan.setOnClickListener {
            startActivity(Intent(this@SignCorporate,AjukanAccountActivity::class.java))

        }
        btnSignIn.setOnClickListener {
            startActivity(Intent(this@SignCorporate, SignIn::class.java))

        }


    }
}