package com.example.mywork.Beranda.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R

class LokerPopulerAdapter (private val list: ArrayList<LokerModel>)
    : RecyclerView.Adapter<LokerPopulerAdapter.MyViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var namaLoker: TextView? = itemView.findViewById(R.id.text_pekerjaan_loker)
        var logoPerusahaan: ImageView = itemView.findViewById(R.id.image_logo_loker)
        var namaPerusahaan: TextView? = itemView.findViewById(R.id.text_perusahaan_loker)
        var tempatLoker: TextView? = itemView.findViewById(R.id.text_tempat_loker)
        var gajiLoker: TextView? = itemView.findViewById(R.id.text_gaji_loker)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_loker_populer, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namaLoker?.text = list[position].pekerjaan
        holder.logoPerusahaan?.setImageResource(list[position].logo_perusahaan)
        holder.namaPerusahaan?.text = list[position].perusahaan
        holder.tempatLoker?.text = list[position].tempat
        holder.gajiLoker?.text = "Gaji "+list[position].gaji_min.toString()+"-"+list[position].gaji_max.toString()+" Jt"
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition]) }
    }

    override fun getItemCount():Int {return list.size}

    interface OnItemClickCallback {
        fun onItemClicked(data: LokerModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}