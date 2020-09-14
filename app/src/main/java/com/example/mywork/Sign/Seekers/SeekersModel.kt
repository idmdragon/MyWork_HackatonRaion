package com.example.mywork.Sign.Seekers


data class SeekersModel(
    var nama: String = "",
    var email: String = "",
    var kelamin: String = "",
    var status: String = "",
    var tanggalLahir: String = "",
    var gajipilhan: String = "",
    var kotaPilihan: String = "",
    var pekerjaan: String = "",
    var nomerTelepon : String = ""

) {
    constructor(): this("","","","","","","","","")
}