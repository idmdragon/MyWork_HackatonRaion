package com.example.mywork.Pengaturan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.example.mywork.Intro.MulaiActivity
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SeekersModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_pengaturan.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_sign_up.*

class PengaturanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)

        EditProfil.setOnClickListener {
            val intent = Intent(this@PengaturanActivity, EditProfilActivity::class.java)
            startActivity(intent)
        }
        EditPreferensi.setOnClickListener {
            val intent = Intent(this@PengaturanActivity, EditPreferensiActivity::class.java)
            startActivity(intent)
        }









    }
}