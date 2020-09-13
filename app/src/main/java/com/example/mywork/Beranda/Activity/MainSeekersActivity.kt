package com.example.mywork.Beranda.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.Beranda.Adapter.MainPelamarAdapter
import com.example.mywork.Beranda.Data.LokerData
import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainSeekersActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var database: FirebaseDatabase
    private lateinit var populer_loker : DatabaseReference
    private lateinit var rekomendasi_loker: DatabaseReference
    private var dataPopLoker: ArrayList<LokerModel> = arrayListOf()
    private var dataRecLoker: ArrayList<LokerModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_seekers)

        val recyclerViewPop = findViewById<RecyclerView>(R.id.recycler_view_homepage_poploker)
        val recyclerViewRec = findViewById<RecyclerView>(R.id.recycler_view_homepage_poploker)

        dataRecLoker.addAll(LokerData.listData)

        showListLoker(recyclerViewPop, dataPopLoker, LinearLayoutManager.HORIZONTAL)
        showListLoker(recyclerViewRec, dataRecLoker, LinearLayoutManager.VERTICAL)
    }

    private fun showListLoker(recyclerView: RecyclerView, listData: ArrayList<LokerModel>, orientation: Int) {
        recyclerView.layoutManager = LinearLayoutManager(this, orientation, false)
        val listAdapter = MainPelamarAdapter(listData)
        recyclerView.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : MainPelamarAdapter.OnItemClickCallback{
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