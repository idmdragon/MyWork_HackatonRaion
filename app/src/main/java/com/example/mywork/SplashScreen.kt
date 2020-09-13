package com.example.mywork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.mywork.Beranda.Activity.MainPelamarActivity
import com.example.mywork.Intro.MulaiActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
         lateinit var fadeIn: Animation
         var user: FirebaseUser? = null



            fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            user = FirebaseAuth.getInstance().currentUser
            val appLogo = findViewById<ImageView>(R.id.imageView3)
            appLogo.startAnimation(fadeIn)
            Handler().postDelayed({
                if(user != null) {
                    startActivity(Intent(this, MainPelamarActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(this, MulaiActivity::class.java))
                    finish()
                }
            }, 2000)
        }
    }
