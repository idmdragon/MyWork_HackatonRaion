package com.example.mywork.Beranda.Model

data class LokerModel(
    val pekerjaan: String,
    val logo_perusahaan: Int,
    val perusahaan: String,
    val tempat: String,
    val gaji_min: Double,
    val gaji_max : Double,
    val detail_loker: String,
    val syarat_loker: String,
    val tipe: String,
    val bidang: String,
    val batas_daftar: String,
    val email_daftar: String,
    val telp_daftar:String
)