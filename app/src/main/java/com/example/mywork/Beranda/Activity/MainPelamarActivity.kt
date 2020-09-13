package com.example.mywork.Beranda.Activity

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

class MainPelamarActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var database: FirebaseDatabase
    private lateinit var populer_loker : DatabaseReference
    private lateinit var rekomendasi_loker: DatabaseReference
    private var dataPopLoker: ArrayList<LokerModel> = arrayListOf()
    private var dataRecLoker: ArrayList<LokerModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pelamar)

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
//                val intent = Intent(this@MainActivity, detail::class.java)
//                intent.putExtra("WAIFU_NAME", data.name)
//                intent.putExtra("WAIFU_DETAIL", data.detail)
//                intent.putExtra("WAIFU_IMAGE", data.photo)
//                startActivity(intent)
            }
        })
    }
}