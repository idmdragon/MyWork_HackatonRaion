package com.example.mywork.Beranda.Activity

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.mywork.R
import org.w3c.dom.Text

class DetailLokerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_loker)

        val pekerjaan = intent.getStringExtra("LokerPekerjaan")
        val logo_perusahaan = intent.getIntExtra("LokerLogoPerusahaan", 0)
        val perusahaan = intent.getStringExtra("LokerPerusahaan")
        val tempat = intent.getStringExtra("LokerTempat")
        val gaji_min = intent.getDoubleExtra("LokerGajiMin", 0.0)
        val gaji_max = intent.getDoubleExtra("LokerGajiMax", 0.0)
        val detail_loker = intent.getStringExtra("LokerDetailLoker")
        val syarat_loker = intent.getStringExtra("LokerSyaratLoker")
        val tipe = intent.getStringExtra("LokerTipe")
        val bidang = intent.getStringExtra("LokerBidang")
        val batas_daftar = intent.getStringExtra("LokerBatasDaftar")
        val email_daftar = intent.getStringExtra("LokerEmailDaftar")
        val telp_daftar = intent.getStringExtra("LokerTelpDaftar")
        
        val toolbar = findViewById<Toolbar>(R.id.toolbar_detail_loker)
        setActionBar(toolbar)
        val btnToolbar = findViewById<ImageButton>(R.id.button_toolbar_detail)
        btnToolbar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                onBackPressed()
            }
        })
        val txtToolbar = findViewById<TextView>(R.id.text_toolbar_detail)
        txtToolbar.text = perusahaan

        val txt_pekerjaan = findViewById<TextView>(R.id.text_pekerjaan_detail_loker)
        val image_logo = findViewById<ImageView>(R.id.image_detail_loker)
        val txt_perusahaan = findViewById<TextView>(R.id.text_perusahaan_detail_loker)
        val txt_tempat = findViewById<TextView>(R.id.text_tempat_detail_loker)
        val txt_gaji = findViewById<TextView>(R.id.text_gaji_detail_loker)
        val txt_detail = findViewById<TextView>(R.id.text_detail_detail_loker)
        val txt_syarat = findViewById<TextView>(R.id.text_syarat_detail_loker)
        val txt_tipe = findViewById<TextView>(R.id.text_tipe_detail_loker)
        val txt_bidang = findViewById<TextView>(R.id.text_bidang_detail_loker)
        val txt_batas_daftar = findViewById<TextView>(R.id.text_batas_daftar_detail_loker)
        val txt_info_daftar = findViewById<TextView>(R.id.text_info_daftar_detail_loker)

        txt_pekerjaan.text = pekerjaan
        image_logo.setImageResource(logo_perusahaan)
        txt_perusahaan.text = perusahaan
        txt_tempat.text = tempat
        txt_gaji.text = gaji_min.toString() + "-" + gaji_max.toString() + " Juta"
        txt_detail.text = detail_loker
        txt_syarat.text = syarat_loker
        txt_tipe.text = tipe
        txt_bidang.text = bidang
        txt_batas_daftar.text = batas_daftar
        txt_info_daftar.text = Html.fromHtml("Kirimkan CV anda ke email <font color='#000000'>"+email_daftar+"</font> dan untuk info lebih lanjut hubungi <font color='#000000'>"+telp_daftar+"</font>")
    }

}