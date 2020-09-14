package com.example.mywork.Intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SignIn.SignIn
import kotlinx.android.synthetic.main.activity_mulai.*

class MulaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai)

        btnNext.setOnClickListener {
            Intent (applicationContext, Intro::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}