package com.example.mywork.Sign.Corporate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywork.R
import kotlinx.android.synthetic.main.activity_ajukan_account.*

class AjukanAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajukan_account)
        btnSelesaiPerusahaan.setOnClickListener {
            startActivity(Intent(this@AjukanAccountActivity,AjukanAccountComplete::class.java))

        }

        btn_back.setOnClickListener {
            finish()
        }
    }
}