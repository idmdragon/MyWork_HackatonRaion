package com.example.mywork.Beranda.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.Beranda.Adapter.LokerPopulerAdapter
import com.example.mywork.Beranda.Adapter.LokerRekomendasiAdapter
import com.example.mywork.Beranda.Data.LokerPopulerData
import com.example.mywork.Beranda.Data.LokerRekomendasiData
import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.navigation_drawer_seekers.*

class MainSeekersActivity : AppCompatActivity() {
    private lateinit var mToggle : ActionBarDrawerToggle
    private var dataPopLoker: ArrayList<LokerModel> = arrayListOf()
    private var dataRecLoker: ArrayList<LokerModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_seekers)

        setActionBar(findViewById(R.id.toolbar_main_seekers))
        val btnWishlist = findViewById<ImageButton>(R.id.button_toolbar_main_wishlist)
        btnWishlist.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(this@MainSeekersActivity, WishlistActivity::class.java))
            }
        })
//
//        mToggle = ActionBarDrawerToggle(this, drawer_layout_seeker, R.string.nav_open, R.string.nav_close)
//        drawer_layout_seeker.addDrawerListener(mToggle)
//        mToggle.syncState()

        val nav_view = findViewById<NavigationView>(R.id.navigation_view_seeker)
//        nav_view.onNavigation

        val recyclerViewPop = findViewById<RecyclerView>(R.id.recycler_view_homepage_poploker)
        val recyclerViewRec = findViewById<RecyclerView>(R.id.recycler_view_homepage_recloker)

        dataPopLoker.addAll(LokerPopulerData.listData)
        dataRecLoker.addAll(LokerRekomendasiData.listData)

        showListLokerPopuler(recyclerViewPop, dataPopLoker)
        showListLokerRekomendasi(recyclerViewRec, dataRecLoker)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return mToggle.onOptionsItemSelected(item)
    }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        when (p0.itemId) {
//            R.id.nav_beranda -> {
//                println("Friend Clicked")
//                true
//            }
//            R.id.nav_forum -> {
//                println("Channel Clicked")
//                true
//            }
//            R.id.nav_pengaturan -> {
//                println("Status Clicked")
//                true
//            }
//            R.id.nav_keluar -> {
//                FirebaseAuth.getInstance().signOut()
//                true
//            }
//            else -> true
//        }
//        return true
//    }

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