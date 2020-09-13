package com.example.mywork.Beranda.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.Beranda.Adapter.LokerPopulerAdapter
import com.example.mywork.Beranda.Adapter.LokerRekomendasiAdapter
import com.example.mywork.Beranda.Data.LokerPopulerData
import com.example.mywork.Beranda.Data.LokerRekomendasiData
import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R

class MainSeekersActivity : AppCompatActivity() {
    private var dataPopLoker: ArrayList<LokerModel> = arrayListOf()
    private var dataRecLoker: ArrayList<LokerModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_seekers)

        setActionBar(findViewById(R.id.toolbar_main_seekers))

        val recyclerViewPop = findViewById<RecyclerView>(R.id.recycler_view_homepage_poploker)
        val recyclerViewRec = findViewById<RecyclerView>(R.id.recycler_view_homepage_recloker)

        dataPopLoker.addAll(LokerPopulerData.listData)
        dataRecLoker.addAll(LokerRekomendasiData.listData)

        showListLokerPopuler(recyclerViewPop, dataPopLoker)
        showListLokerRekomendasi(recyclerViewRec, dataRecLoker)
    }

    private fun showListLokerPopuler(recyclerView: RecyclerView, listData: ArrayList<LokerModel>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listAdapter = LokerPopulerAdapter(listData)
        recyclerView.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : LokerPopulerAdapter.OnItemClickCallback{
            override fun onItemClicked(data: LokerModel) {
                val intent = Intent(this@MainSeekersActivity, DetailLokerActivity::class.java)
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

    private fun showListLokerRekomendasi(recyclerView: RecyclerView, listData: ArrayList<LokerModel>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listAdapter = LokerRekomendasiAdapter(listData)
        recyclerView.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : LokerRekomendasiAdapter.OnItemClickCallback{
            override fun onItemClicked(data: LokerModel) {
                val intent = Intent(this@MainSeekersActivity, DetailLokerActivity::class.java)
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