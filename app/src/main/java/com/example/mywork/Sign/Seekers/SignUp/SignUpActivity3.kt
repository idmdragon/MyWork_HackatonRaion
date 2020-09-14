package com.example.mywork.Sign.Seekers.SignUp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.mywork.Beranda.Activity.MainSeekersActivity
import com.example.mywork.Pengaturan.PengaturanActivity
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SeekersModel
import com.example.mywork.Sign.Seekers.SignIn.SignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up3.*

class SignUpActivity3 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    private lateinit var database: FirebaseDatabase
    private lateinit var userRef: DatabaseReference


    companion object {
        const val NAMA_SEEKERS = "nama_seekers"
        const val email_seekers = "email_seekers"
        const val password_seekers = "password_seekers"
        const val telepon_seekers = "telepon_seekers"
        const val kelamin_seekers = "kelamin_seekers"
        const val status_seekers = "status_seekers"
        const val tanggal_lahir_seekers = "tanggal_lahir_seekers"

    }





     var pekerjaan = ""
     var gajiPilihan =""
     var kotapilihan =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up3)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        userRef = database.getReference("SEEKERS")

        val name = intent.getStringExtra(NAMA_SEEKERS)
        val email = intent.getStringExtra(email_seekers)
        val password = intent.getStringExtra(password_seekers)
        val telepon = intent.getStringExtra(telepon_seekers)
        val tanggalLahir = intent.getStringExtra(tanggal_lahir_seekers)
        val status = intent.getStringExtra(status_seekers)

        val kerjaan :String = pekerjaan
        val gajipilhan:String =gajiPilihan
        val kotaPilihan:String =kotapilihan


        btn_back.setOnClickListener {
            finish()
        }



        btnSelesai.setOnClickListener {

            checkBox()
            spinner_gaji()
            spinner_kota()
            registerUser(name!!, email!!, password!!,telepon!!,tanggalLahir!!,status!!,kerjaan!!,gajipilhan!!,kotaPilihan!!)
            Toast.makeText(this,"Proses Membuat akun",Toast.LENGTH_LONG).show()
        }







    }

    private fun createAccount() {

    }


    fun spinner_gaji(){
        sp_gaji.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gajiPilihan = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }

    fun spinner_kota(){
        sp_lokasi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                kotapilihan = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }

    fun checkBox() {

        if (PekejaanUmum.isChecked){
            pekerjaan+="PekejaanUmum"
        }
         if(Keuangan.isChecked){
             pekerjaan+="\nKeuangan"
         }

        if(Pendidikan.isChecked){
            pekerjaan+="\nPendidikan"
        }
        if(Kesehatan.isChecked){
            pekerjaan+="\nKesehatan"
        }
        if(Robotik.isChecked){
            pekerjaan+="\nRobotik"
        }
        if(IT.isChecked){
            pekerjaan+="\nIT"
        }
        if(Restaurant.isChecked){

            pekerjaan+="\nRestaurant"
        }
        if(Pertambangan.isChecked){
            pekerjaan+="\nPertambangan"
        }
        if(Industri.isChecked){
            pekerjaan+="\nIndustri"
        }
        if(Musik.isChecked){
            pekerjaan+="\nMusik"
        }
        }


    fun registerUser(
        nama: String, email: String, password: String,
        kelamin: String, status: String, tanggalLahir: String,
        gajipilhan: String, kotaPilihan: String, pekerjaan: String
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                        Log.d("RegisterUserDebug: ", "User: $email registered")
                    insertUserDataToDatabase(nama, email,kelamin,status,tanggalLahir,
                        gajipilhan,kotaPilihan,pekerjaan)

                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(nama)
                        .build()
                    user?.updateProfile(profileUpdates)
                    startActivity(Intent(this@SignUpActivity3, MainSeekersActivity::class.java))


                } else {
                    Log.d("RegisterUserDebug: ", "User: $email failed")
                    Log.d("RegisterUserDebug: ", task.exception.toString())
                    Toast.makeText(this,task.exception.toString(),Toast.LENGTH_SHORT).show()

                }
            }
    }

    fun insertUserDataToDatabase(
        nama: String, email: String,
        kelamin: String, status: String, tanggalLahir: String,
        gajipilhan: String, kotaPilihan: String, pekerjaan: String) {
        val uid = auth.currentUser!!.uid
        user = auth.currentUser!!

        Log.d("UserUID", "User Registered UID: $uid")
        val user = SeekersModel(nama, email,kelamin,status,tanggalLahir,
            gajipilhan,kotaPilihan,pekerjaan)
        userRef.child(uid).setValue(user)
//
//        user = auth.currentUser!!


//        val seeker = SeekersModel(in_telp.text.toString(), in_birth.text.toString())
//        db_ref.child(user.uid).setValue(seeker)

    }

}




