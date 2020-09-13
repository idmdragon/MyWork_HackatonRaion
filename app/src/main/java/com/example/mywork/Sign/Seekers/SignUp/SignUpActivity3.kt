package com.example.mywork.Sign.Seekers.SignUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.mywork.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up3.*

class SignUpActivity3 : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mUser: FirebaseUser

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

        checkBox()
        spinner_gaji()
        spinner_kota()

        btnSelesai.setOnClickListener {

            createAccount()

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
    }



//    private fun createUser(email: String, password: String) {
//
//
//
//        auth.createUserWithEmailAndPassword(email,password)
//            .addOnCompleteListener(this) {
//                if(it.isSuccessful){
//                    Toast.makeText(applicationContext,"User $password succesfull",Toast.LENGTH_LONG).show()
//                    Log.d("RegisterTes","User $password succesfull")
//                }else {
//                    Log.d("RegisterTes","User $password failed")
//                    Toast.makeText(applicationContext,"User $password fail",Toast.LENGTH_LONG).show()
//                    Toast.makeText(applicationContext,"User $password succesfull",Toast.LENGTH_LONG).show()
//
//                }
//
//
//            }
//
//
//    }

//    fun registerUser(username: String, email: String, password: String) {
//        mAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    Log.d("RegisterUserDebug: ", "User: $email registered")
//                    insertUserDataToDatabase(username, email)
//                } else {
//                    Log.d("RegisterUserDebug: ", "User: $email failed")
//                    Log.d("RegisterUserDebug: ", task.exception.toString())
//                }
//            }
//    }

//    fun insertUserDataToDatabase(username: String, email: String) {
//        val uid = mAuth.currentUser!!.uid
//        mUser = mAuth.currentUser!!
//        val uri: Uri // return https:www.gambar.com/pic/1
//
//        Log.d("UserUID", "User Registered UID: $uid")
//        val user = UserModel(username, email)
//        userRef.child(uid).setValue(user)
//
//
//    }

