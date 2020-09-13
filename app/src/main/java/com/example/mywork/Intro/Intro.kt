package com.example.mywork.Intro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SignIn
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_intro.*


class Intro : AppCompatActivity() {


    private val introSlideAdapter = IntroSlideAdapter(
        listOf(
            IntroSlide(
                R.drawable.ic_ilustrasi1,
                "Rekomendasi 1",
                "Dapatkan pekerjaan\n" +
                        "berdasarkan pilihan minat anda"
            ),
            IntroSlide(
                R.drawable.ic_ilustrasi2,
                "Rekomendasi 2",
                "Dapatkan pekerjaan\n" +
                        "berdasarkan pilihan minat anda"
            ),
            IntroSlide(
                R.drawable.ic_ilustrasi3,
                "Rekomendasi 3",
                "Dapatkan pekerjaan\n" +
                        "berdasarkan pilihan minat anda"
            ),


            )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        introSliderViewPager.adapter = introSlideAdapter

        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })

        btnNext.setOnClickListener{
            if(introSliderViewPager.currentItem + 1 < introSlideAdapter.itemCount)
            {
                introSliderViewPager.currentItem+=1
            }else{
                Intent(applicationContext, SignIn::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
    }



}