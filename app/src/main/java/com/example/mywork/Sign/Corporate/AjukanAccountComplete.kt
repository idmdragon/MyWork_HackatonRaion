package com.example.mywork.Sign.Corporate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywork.R
import kotlinx.android.synthetic.main.activity_ajukan_account_complete.*

class AjukanAccountComplete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajukan_account_complete)
        btnSelesai.setOnClickListener {
            startActivity(Intent(this@AjukanAccountComplete,SignCorporate::class.java))

        }

    }
}