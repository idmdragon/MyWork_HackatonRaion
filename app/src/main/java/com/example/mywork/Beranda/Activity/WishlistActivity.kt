package com.example.mywork.Beranda.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.Beranda.Adapter.LokerPopulerAdapter
import com.example.mywork.Beranda.Adapter.LokerRekomendasiAdapter
import com.example.mywork.Beranda.Data.LokerPopulerData
import com.example.mywork.Beranda.Data.LokerRekomendasiData
import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R

class WishlistActivity :AppCompatActivity() {
    private var dataWishlist: ArrayList<LokerModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_wishlist)
        setActionBar(toolbar)
        val btnToolbar = findViewById<ImageButton>(R.id.button_toolbar_wishlist)
        btnToolbar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                onBackPressed()
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_wishlist)

        dataWishlist.addAll(LokerPopulerData.listData)

        showListWishlist(recyclerView, dataWishlist)
    }

    private fun showListWishlist(recyclerView: RecyclerView, listData: ArrayList<LokerModel>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listAdapter = LokerRekomendasiAdapter(listData)
        recyclerView.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : LokerRekomendasiAdapter.OnItemClickCallback{
            override fun onItemClicked(data: LokerModel) {
                val intent = Intent(this@WishlistActivity, DetailLokerActivity::class.java)
                intent.putExtra("LokerPekerjaan", data.pekerjaan)
                intent.putExtra("LokerLogoPerusahaan", data.logo_perusahaan)
                intent.putExtra("LokerPerusahaan", data.perusahaan)
                intent.putExtra("LokerTempat", data.tempat)
                intent.putExtra("LokerGajiMin", data.gaji_min)
                intent.putExtra("LokerGajiMax", data.gaji_max)
                intent.putExtra("LokerDetailLoker", data.detail_loker)
                intent.putExtra("LokerSyaratLoker", data.syarat_loker)
                intent.putExtra("LokerTipe", data.tipe)
                intent.putExtra("LokerBidang", data.bidang)
                intent.putExtra("LokerBatasDaftar", data.batas_daftar)
                intent.putExtra("LokerEmailDaftar", data.email_daftar)
                intent.putExtra("LokerTelpDaftar", data.telp_daftar)
                startActivity(intent)
            }
        })
    }
}